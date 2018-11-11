// The Vue build version to load with the `import` command
// (runtime-only or standalone) has been set in webpack.base.conf with an alias.
import Vue from 'vue'
import axios from 'axios'
import router from './router'
import store from './store'

import App from './App'
import BootstrapVue from 'bootstrap-vue'
import 'bootstrap/dist/css/bootstrap.css'
import 'bootstrap-vue/dist/bootstrap-vue.css'
import {AuthService} from './service/AuthService'

Vue.use(BootstrapVue)
Vue.config.productionTip = false
Vue.prototype.$http = axios


//filter
Vue.filter('money', function (value) {
  if (!value) return ''
  return value.toString().replace(/\B(?=(\d{3})+(?!\d))/g, ",")
})

//router config
router.beforeEach((to, from, next) => {
  if (to.matched.some(record => record.meta.requiresAuth)) {
    if (!AuthService.loggedIn()) {

    }
  }
  next() // 반드시 next()를 호출하십시오!
})

/* eslint-disable no-new */
new Vue({
  el: '#app',
  store,
  router,
  components: { App },
  template: '<App/>'
})
