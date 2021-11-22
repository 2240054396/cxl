<template>
  <div>
    Child1
    <h1>{{nameData}}</h1>
  </div>
</template>

<script>
export default {
  name: "Child1",
  props:['nameData'],
}
</script>

<style scoped>
  div{
    width: 100%;
    height: 100px;
    background-color: #ab934c;
  }
</style>
