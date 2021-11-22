<template>
  <div>
      <h1>{{name}}今年{{age}}岁</h1>
    <input type="text" v-model="name"/>
    <input type="text" v-model="age"/>
  </div>

</template>

<script>
export default {
  name: "A",
  data(){
    return {
      name:"张三",
      age:18
    };
  },
  beforeCreate() {
    console.log("beforeCreate");
  },
  created() {
    console.log("created")
  },
  beforeMount() {
    console.log("beforeMount")
  },
  mounted() {
    console.log("mounted")
  },
  beforeUpdate() {
    console.log("beforeUpdate")
  },
  updated() {
    console.log("updated")
  },
  beforeDestroy() {
    console.log("beforeDestroy")
  },
  destroyed() {
    console.log("destroyed")
  }
}
</script>

<style scoped>

</style>
