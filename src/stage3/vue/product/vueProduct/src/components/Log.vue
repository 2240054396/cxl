<template>
  <div>
    <form action="" onsubmit="return false">
      <input type="text" name="username" v-model="user.username"><br>
      <input type="password" name="password" v-model="user.password"><br>
      <input type="text" name="captcha" v-model="user.captcha"><br>
      <img :src="user.captchaImg" alt="err" @click="getCaptcha"><br>
      <input type="button" value="login" @click="login">
    </form>
  </div>
</template>

<script>

import axios from "axios";
import {validate,login} from "../request/api";

export default {
  name: "Log",
  data() {
    return {
      user: {
        username: "",
        password: "",
        captcha: "",
        captchaImg: "",
      },
    }
  },
  methods: {
    getCaptcha() {
      let _this = this;
      validate().then(response=> {
        console.log(response);
        if (response.status === 200) {
          localStorage.setItem("ValidateKey", response.headers.validatekey);
          _this.user.captchaImg = "data:image/jpg;base64," + response.data;
        }
      })
      // axios.get("http://localhost:8081/crm/user/validate")
      //   .then(function (response) {
      //     console.log(response);
      //     if (response.status === 200) {
      //       localStorage.setItem("ValidateKey", response.headers.validatekey);
      //       _this.user.captchaImg = "data:image/jpg;base64," + response.data;
      //     }
      //   })
    },
    login() {
      login(this.user)
        .then(function (response) {
          console.log(response);
        })
        .catch(function (err) {
          console.log("err" + err);
        })
        .finally(function (res) {
          console.log("res" + res);
        })


    },
  },
  created() {
    this.getCaptcha();
  }
}

</script>

<style scoped>

</style>
