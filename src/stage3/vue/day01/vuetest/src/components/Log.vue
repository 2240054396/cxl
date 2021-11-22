<template>
  <div>
    <form action="" onsubmit="return false">
      <input type="text" name="username" v-model="user.username"><br>
      <input type="password" name="password" v-model="user.password"><br>
      <input type="text" name="captcha" v-model="user.captcha"><br>
      <img src="" alt=""><br>
      <input type="button" value="login">
    </form>
  </div>
</template>

<script>
export default {
  name: "Log",
  data(){
    return {
      user:{
        username: "",
        password: "",
        captcha: "",
      },
    }
  },
  methods:{
    getCaptcha(){

    },
    login(){

    },
  }
}
</script>

<style scoped>

</style>
