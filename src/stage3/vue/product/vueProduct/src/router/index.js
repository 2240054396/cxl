import Vue from 'vue'
import Router from 'vue-router'
import HelloWorld from '@/components/HelloWorld'
import A from '@/components/A'
import B from '@/components/B'
import Person from '@/components/Person'
import Parent from "@/components/Parent";
import Child1 from "../components/Child1";
import Main from "../components/Main";
import Log from "../components/Log";
import Reg from "../components/Reg";

Vue.use(Router)

export default new Router({
  routes: [
    {
      path: '/',
      name: 'HelloWorld',
      component: HelloWorld
    },
    {
      path: '/HelloWorld',
      name: 'Hello',
      component: HelloWorld
    },
    {
      path: '/A',
      name: 'A',
      component: A
    },
    {
      path: '/B',
      name: 'B',
      component: B
    },
    {
      path: '/Person',
      name: 'Person',
      component: Person
    },
    {
      path: '/Parent',
      name: 'Parent',
      component: Parent
    },
    {
      path: '/Child1',
      name: 'Child1',
      component: Child1
    },
    {
      path: '/Main',
      name: 'Main',
      component: Main
    },
    {
      name: "login",
      path: "/login",
      component: Log,
    },
    {
      name: "register",
      path: "/reg",
      component: Reg,
    },
  ]
})
