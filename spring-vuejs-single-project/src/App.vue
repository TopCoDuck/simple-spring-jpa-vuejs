<template>
  <div id="app">
    <div class="d-flex flex-column flex-md-row align-items-center p-3 px-md-4 mb-3 bg-white border-bottom shadow-sm">
      <h5 class="my-0 mr-md-auto font-weight-normal">쇼핑몰</h5>
      <nav  class="my-2 my-md-0 mr-md-3">
        <router-link class="p-2 text-dark" to="/item-list">상품리스트</router-link>
        <router-link class="p-2 text-dark" to="/my-info">내 정보</router-link>
        <router-link class="p-2 text-dark" to="/login">로그인</router-link>
        <router-link class="p-2 text-dark" to="/cart">장바구니<span class="badge badge-secondary badge-pill">{{stockCnt}}</span></router-link>
        <router-link class="p-2 text-dark" to="/order">주문</router-link>
        <router-link class="p-2 text-dark" to="/reception">주문서</router-link>
        <router-link class="p-2 text-dark" to="/join">회원가입</router-link>
      </nav>
    </div>
    <div class="container">
      <router-view/>
    </div>
  </div>
</template>

<script>
import { mapGetters, mapActions  } from 'vuex'

export default {
  name: 'App',
  computed: {
     ...mapGetters(
       'cart', {
         stockCnt:'stockCnt'
        }
      )
  }
}
</script>
