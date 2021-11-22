import axios from "axios";
import store from "../store";
import router from "../router/index"
import QS from "qs";

if (process.env.NODE_ENV === "development") {
  console.log("development environment");
  axios.defaults.baseURL = "http://localhost:8081/crm/";
} else if (process.env.NODE_ENV === "production") {
  console.log("production environment");
  axios.defaults.baseURL = "http://localhost:8081/crm/";
}

axios.defaults.timeout = 10 * 1000;

axios.defaults.headers.post['Content-Type'] = "application/x-www-form-urlencoded;charset=utf-8";

axios.interceptors.request.use(
  config => {
    const token = store.state.token;
    if (token) {
      config.headers.Token = token;
    }
    const validateKey = localStorage.getItem("ValidateKey");
    if (validateKey) {
      config.headers.ValidateKey = validateKey;
    }
    return config;
  }
)

axios.interceptors.response.use(
  response => {
    if (response.status === 200) {
      return Promise.resolve(response);
    } else {
      return Promise.reject(response);
    }
  },
  error => {
    switch (error.response.status) {
      case 404:
        router.replace({
          path: "",
        })
        break;
    }
  }
)

export function get(url, params) {
  return new Promise(
    (resolve, reject) => {
      axios.get(url, {params}).then(
        res => {
          resolve(res)
        }
      ).catch(err => {
        reject(err)
      })
    })
}

export function post(url, params) {
  return new Promise((resolve, reject) => {
    axios.post(url, QS.stringify(params)).then(
      res => {
        resolve(res)
      }
    ).catch(err => {
      reject(err)
    })
  })
}

