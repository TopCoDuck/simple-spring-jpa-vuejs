<template>
<div class="container">
  <div class="row">
    <div class="col-md-8 order-md-1">
      <h2>회원정보</h2>
      <div class="table-responsive">
            <table class="table table-bordered table-sm">
                <col width="20%">
                <col width="80%">
                <tbody>
                    <tr>
                      <td>ID</td>
                      <td>{{member.userName}}</td>
                    </tr>
                    <tr>
                      <td>이름</td>
                      <td>{{member.nickName}}</td>
                    </tr>
                    <tr>
                      <td>전화번호</td>
                      <td>{{member.phoneNumber.fnumber}}-{{member.phoneNumber.lnmber}}-{{member.phoneNumber.mnumber}}</td>
                    </tr>
                    <tr>
                      <td>이메일</td>
                      <td>{{member.email}}</td>
                    </tr>
                    <tr>
                      <td>우편번호</td>
                      <td>{{member.address.zipCode}}</td>
                    </tr>
                    <tr>
                      <td>주소</td>
                      <td>{{member.address.zipInfo}}</td>
                    </tr>
                    <tr>
                      <td>상세주소</td>
                      <td>{{member.address.zipInfoDetail}}</td>
                    </tr>
                </tbody>
            </table>
      </div>
      <h2>주문내역</h2>
      <div class="table-responsive">
            <table class="table table-bordered table-sm">
                <thead>
                  <tr>
                    <th>주문번호</th>
                    <th>주문내역</th>
                    <th>주문수량</th>
                    <th>총액</th>
                  </tr>
                </thead>
                <tbody>
                    <tr v-for="order in orders">
                      <td>{{order.orderId}}</td>
                      <td>{{order.representItemNm}}</td>
                      <td>{{order.totalAmount}}</td>
                      <td>{{order.sumTotal}}</td>
                    </tr>
                </tbody>
            </table>
      </div>
     ※ 최근 구매 내역 5개가 보입니다.
    </div>
  </div>
</div>
</template>


<script>
export default{
  data () {
    return {
      member : {userName:'',
              nickName:'',
      address : {
          zipCode:'',
          zipInfo:'',
          zipInfoDetail:''
        },
       phoneNumber:{
         fNumber:'',
         mNumber:'',
         lNmber:''
       },
       email:''},
      orders : null
    }
  },
  created () {
      this.fetchData()
  },
  watch: {
    '$route': 'fetchData'
  },
  methods: {
    fetchData () {
      this.$http.post('/my-info')
      .then(({data}) => {
        console.log(data.member)
        this.member = data.member
        this.orders = data.orders
     })
    }
  }
}
</script>
