<template>
<div class="row">
  <div class="col-md-10 order-md-2 mb-4">
    <h4 class="d-flex justify-content-between align-items-center mb-3"><span class="text-muted">Your cart</span></h4>
    <table class="table">
      <thead>
        <tr>
          <th scope="col">선택</th>
          <th scope="col">상품명</th>
          <th scope="col">수량</th>
          <th scope="col">가격</th>
        </tr>
      </thead>
      <tbody>
        <tr v-for="stock in stocks">
          <td><input type="checkbox" value="stock.item.itemCd"></td>
          <td>{{stock.item.itemNm | money }}</td>
          <td>{{stock.amount | money }}</td>
          <td>{{stock.item.price * stock.amount | money }}</td>
        </tr>
      </tbody>
    </table>
    <button class="btn btn-primary btn-lg btn-block">구매하기</button>
             <!-- <form class="card p-2">
               <div class="input-group"><input type="text" placeholder="Promo code" class="form-control">
                 <div class="input-group-append"><button type="submit" class="btn btn-secondary">Redeem</button></div></div></form>-->
    </div>
</div>
</template>
<script>
import { mapState } from 'vuex'

export default {
   computed: {
     ...mapState({
      stocks : state => state.cart.stocks
    })
  }
}
</script>
