import Vue from 'vue'
import Router from 'vue-router'

import Cart from '../components/Cart.vue'
import ItemDetail from '../components/ItemDetail.vue'
import ItemList from '../components/ItemList.vue'
import MyInfo from '../components/MyInfo.vue'

import Login from '../components/Login.vue'
import Join from '../components/Join.vue'

import Order from '../components/Order.vue'
import Reception from '../components/Reception.vue'


Vue.use(Router)

export default new Router({
  mode:'history',
  routes: [
    { path : '/item-detail/:itemCd',
      component : ItemDetail
    },{
      path : '/item-list',
      component : ItemList,
      alias : '/'
    },{
      path : '/my-info',
      component : MyInfo ,
      meta: { requiresAuth: true }
    },{
      path: '/login',
      component : Login
    },{
      path : '/cart',
      component : Cart
    },{
      path : '/order',
      component : Order,
      name : 'order'
    },{
      path : '/reception',
      component : Reception
    },{
      path : '/Join',
      component : Join
    }
  ]
})
