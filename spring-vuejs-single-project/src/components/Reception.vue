<template>
<div class="container">
  <div class="row">
    <div class="col-md-8 order-md-1">
      <h2>받는 사람</h2>
      <div class="table-responsive">
            <table class="table table-bordered table-sm">
                <tbody>
                    <tr>
                      <td>이름</td>
                      <td>Lorem</td>
                    </tr>
                </tbody>
            </table>
      </div>
      <h2>배송주소</h2>
      <div class="table-responsive">
            <table class="table table-bordered table-sm">
                <tbody>
                    <tr>
                      <td>우편번호</td>
                      <td>{{reciverInfo.address.zipCode}}</td>
                    </tr>
                    <tr>
                      <td>주소</td>
                      <td>{{reciverInfo.address.zipInfo}}</td>
                    </tr>
                    <tr>
                      <td>상세주소</td>
                      <td>{{reciverInfo.address.zipInfoDetail}}</td>
                    </tr>
                </tbody>
            </table>
      </div>
      <h2>구매상품</h2>
      <div class="table-responsive">
            <table class="table table-bordered table-sm">
                <tbody>
                    <tr v-for="orderItem in orderItems">
                      <td>{{orderItem.itemNm}}</td>
                      <td>{{orderItem.itemNm}}</td>
                      <td>{{orderItem.amount}}</td>
                      <td>{{orderItem.orderPrice * orderItem.amount }}</td>
                    </tr>
                </tbody>
            </table>
      </div>
    </div>
  </div>
</div>
</template>
<script>
export default{
  data(){
    return {
      reciverInfo :{
        address :{
            zipCode : "",
            zipInfo : "",
            zipInfoDetail : ""
        },
        sumTotal : ""
      },
      orderItems : null
    }
  },
  created () {
      this.fetchData()
  },
  watch: {
    '$route': 'fetchData'
  },
  methods: {
    fetchData(){
      this.$http.get("/orders/250")
    }
  }
}
</script>
