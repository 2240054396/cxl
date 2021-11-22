<template>
  <div>
    <h1>{{ dayAge }}天</h1>
    <h1>{{ monthAge }}天</h1>
    <h1>{{ yearAge }}天</h1>
    <input type="button" value="-" @click="dayAge--">
    <input type="text" v-model="dayAge">
    <input type="button" value="+" @click="dayAge++">
    <span v-for="num in arr">{{ num }}</span>
    <input type="button" value="add1" @click="addOne()">
    <input type="button" value="changeObj" @click="changeObj()">
  </div>
</template>

<script>
export default {
  name: "Person",
  data() {
    return {
      dayAge: 3000,
      monthAge: this.dayAge / 30,
      yearAge: this.dayAge / 365,
      arr: [1, 2, 3],
      obj:{
        name:"张三",
        age:18
      },
    }
  },
  computed:{
    name(){
      return this.obj.name;
    }
  },
  watch: {
    dayAge: {
      handler(newValue, oldValue) {
        console.log(newValue + "----" + oldValue);
        this.monthAge = parseInt(newValue) / 30;
        this.yearAge = parseInt(newValue) / 365;
      },
      immediate: true
    },
    arr: {
      handler(newValue, oldValue) {
        console.log(newValue + "----" + oldValue)
      }
    },
    name:{
      handler(newValue, oldValue) {
        console.log(newValue + "----" + oldValue)
      }
    }
    // obj:{
    //   handler(newValue, oldValue) {
    //     console.log(newValue.name + "----" + oldValue.name)
    //   },
    //   deep:true
    // }
  },
  mounted() {
    this.monthAge = this.dayAge / 30;
    this.yearAge = this.dayAge / 365;
  },
  methods:{
    addOne(){
      this.arr.push(1);
    },
    changeObj(){
      this.obj.name="李四"
    }
  },
}
</script>

<style scoped>

</style>
