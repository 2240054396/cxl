import Vue from "vue";
import Vuex from "vuex"


Vue.use(Vuex)

const store = new Vuex.Store({
  state: {
    token: ''
  },
  mutations: {
    editToken(state, payload) {
      state.token = payload;
    }
  }
});
export default store;
