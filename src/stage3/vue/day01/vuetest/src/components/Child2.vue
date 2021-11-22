<template>
  <div>
    Child2
    <input type="button" value="-" @click="minus()">
    <input type="button" value="+" @click="plus()">
  </div>
</template>

<script>
export default {
  name: "Child2",
  methods: {
    minus() {
      this.$emit("minus");
    },
    plus(){
      this.$emit("plus");
    },
  }
}
</script>

<style scoped>
div {
  width: 100%;
  height: 100px;
  background-color: #a84cab;
}
</style>
