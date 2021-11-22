<template>
  <div>
    <h1>{{ name }}今年{{ age }}岁</h1>
    <input type="text" v-model="name"/>
    <input type="button" value="-" v-on:click="minus">
    <input type="text" v-model="age"/>
    <input type="button" value="+" @click.once="plus">
    <div onclick="alert('div')">
      <ul onclick="alert('ul')">
        <li @click.stop="testli('li')">11111111111</li>
      </ul>
    </div>
    <h1 @contextmenu.prevent="testli('h1右键')" v-bind:title="name">测试右键</h1>
    <textarea vue-model="content" @keyup.left="testli('textarea')"/>

    <table>
      <tr>
        <th>姓名</th>
        <th>年龄</th>
      </tr>
      <tr v-for="(user,index) in users">
        <td>{{ index + 1 }}</td>
        <td>{{ user.name }}</td>
        <td>{{ user.age }}</td>
      </tr>
    </table>
    <ul>
      <li v-for="(value,key) in person">
        {{ key }}:{{ value }}
      </li>
    </ul>
    <div>
      <div v-if="age<18">
        age below 18
      </div>
      <div v-else-if="age>18">
        age over 18
      </div>
      <div v-else>
        age equal 18
      </div>
    </div>
    <hr>
    <div>
      <div v-show="age<18">
        age below 18
      </div>
      <div v-show="age>18">
        age over 18
      </div>
      <div v-show="age=18">
        age equal 18
      </div>
    </div>
  </div>
</template>

<script>
export default {
  name: "B",
  data() {
    return {
      name: "张三",
      age: 18,
      content: "<b>加粗了没有</b>>",
      users: [
        {name: "张三", age: 18},
        {name: "张三", age: 18},
        {name: "张三", age: 18},
        {name: "张三", age: 18},
        {name: "张三", age: 18},
        {name: "张三", age: 18},
        {name: "张三", age: 18},
        {name: "张三", age: 18},
        {name: "张三", age: 18},
      ],
      person: {
        name: "李四",
        age: 19
      }
    };
  },
  methods: {
    minus() {
      this.age--;
    },
    plus() {
      this.age++;
    },
    testli(str) {
      alert(str);
    }
  }
}
</script>

<style scoped>
table, th, td {
  border: 1px solid;
  border-collapse: collapse;
  margin: auto;
}
</style>
