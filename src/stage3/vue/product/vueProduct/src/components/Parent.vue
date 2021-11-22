<template>
  <div>
    <h1>{{age}}</h1>
    <Child1 :name-data="name"/>
    <Child2 @minus="parentMinus" @plus="parentPlus"/>
  </div>
</template>

<script>

import Child1 from "./Child1";
import Child2 from "./Child2";

export default {
  name: "parent",
  components: {Child2,Child1},
  data() {
    return {
      name:"张三",
      age:18,
    }
  },
  methods:{
    parentMinus(){
      this.age--;
    },
    parentPlus(){
      this.age++;
    },
  }
}

</script>

<style scoped>
</style>
