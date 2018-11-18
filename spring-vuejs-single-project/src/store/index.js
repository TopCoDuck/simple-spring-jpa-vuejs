import Vue from 'vue'
import Vuex from 'vuex'
import cart from './cartStore'
import auth from './authStore'

Vue.use(Vuex)


export default new Vuex.Store({
  modules: {
    cart,
    auth
  }
})
