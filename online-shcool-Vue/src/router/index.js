import Vue from 'vue'
import App from '../App'
import Router from 'vue-router'



import login  from '@/view/login'

import studentPage from '@/view/studentPage'
import teacherPage from '@/view/teacherPage'
import registerTeacher from '@/view/registerTeacher'
import registerStudent from '@/view/registerStudent'
import selectRegister from '@/view/selectRegister'
import coursePageTeacher from '@/view/coursePageTeacher'
import coursePageStudent from '@/view/coursePageStudent'
import correctPage from '@/view/correctPage'


Vue.use(Router)

export default new Router({
  routes: [
    {
      path: '/',
      redirect: '/login_page',
    },
    
    {
      path: '/login_page',
      name: 'login',
      component: login,
    },

   
    {
      path: '/selectRegister',
      name: 'selectRegister',
      component: selectRegister,
    },

    {
      path: '/registerTeacher',
      name: 'registerTeacher',
      component: registerTeacher,
    },
    
    {
      path: '/registerStudent',
      name: 'registerStudent',
      component: registerStudent,
    },


    {
      path: '/studentPage/:name',
      name: 'studentPage',
      component: studentPage,
    },

    {
      path: '/teacherPage/:name',
      name: 'teacherPage',
      component: teacherPage,
    },
    
    {
      path: '/coursePageTeacher/:courseName',
      name: 'coursePageTeacher',
      component: coursePageTeacher,
    },

    {
      path: '/coursePageStudent/:courseName/:username',
      name: 'coursePageStudent',
      component: coursePageStudent,
    },
    
    {
      path: '/correctPage/:workId',
      name: 'correctPage',
      component: correctPage,
    },
  ]
})
