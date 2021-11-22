<template>
  <div>
    <span><router-link to="/login">登录</router-link></span>
    <span><router-link to="/reg">注册</router-link></span>
    <input type="button" @click="linkToHellowWorld(2)" value="linkToHellowWorld">
    <router-view/>
  </div>
</template>

<script>

import Router from "vue-router";
import Log from "./Log";
import Reg from "./Reg";

export default {
  name: "Main",
  methods:{
    linkToHellowWorld(id){
      this.$router.push({
        path:"/HelloWorld",
        query:{
          id:id
        }
      });
    }
  }
}
</script>

<style scoped>

</style>
