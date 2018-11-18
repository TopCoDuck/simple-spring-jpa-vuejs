<template>
<div class="row">
  <div class="col-md-10 order-md-2 mb-4">
    <h4 class="d-flex justify-content-between align-items-center mb-3"><span class="text-muted">장바구니</span></h4>
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
          <td><input type="checkbox" v-model="stock.item.checked" ></td>
          <td>{{stock.item.itemNm | money }}</td>
          <td>{{stock.amount | money }}</td>
          <td>{{stock.item.price * stock.amount | money }}</td>
        </tr>
      </tbody>
    </table>
    <button class="btn btn-primary btn-lg btn-block" @click="buy">구매하기</button>
    </div>
</div>
</template>
<script>

import { mapState } from 'vuex'

export default {
  methods:{
    buy (){
        let params = new URLSearchParams();
        let count = 0;
        let orderedItems = [];

        for(let stock of this.stocks){
          params.append('orderedItems['+count+'].itemCd', stock.itemCd);
          params.append('orderedItems['+count+'].amount', stock.amount);
          orderedItems.push(stock);
        }

        this.$http.post('/order/page', params)
          .then(({data})=>{
              this.$router.push({name:'order',params:orderedItems})
           })
           .catch(()=>{
        })
    }
  }
  , computed: {
    ...mapState({
      stocks: state => {
        let stocks = state.cart.stocks
        for(let stock of stocks){
           stock.item.checked = false;
        }
        return stocks
      }
    })
  }
}
</script>
