<template>
  <div class="row">
          <div class="col-md-4 order-md-2 mb-4">
            <h4 class="d-flex justify-content-between align-items-center mb-3">
              <span class="text-muted">장바구니</span>
            </h4>
            <ul class="list-group mb-3">
              <li class="list-group-item d-flex justify-content-between lh-condensed" v-for="orderedItem in orderedItems">
                <div>
                  <h6 class="my-0">{{orderedItem.item.itemNm }}</h6>
                  <small class="text-muted">{{orderedItem.amount}} 개</small>
                </div>
                <span class="text-muted">{{orderedItem.item.price * orderedItem.amount | money }}</span>
              </li>
              <li class="list-group-item d-flex justify-content-between">
                <span>총계</span>
                <strong>{{totalSum | money}}</strong>
              </li>
            </ul>
          </div>
          <div class="col-md-8 order-md-1">
            <h4 class="mb-3">구매자</h4>
            <form class="needs-validation" novalidate="">
              <div class="row">
                <div class="col-md-6 mb-3">
                  <label for="firstName">이름</label>
                  <input type="text" class="form-control" v-model="receiverInfo.name">
                  <div class="invalid-feedback">
                    Valid first name is required.
                  </div>
                </div>
              </div>

              <div class="row">
                <div class="col-md-3 mb-3">
                  <label for="zip">우편번호</label>
                  <input type="text" class="form-control" v-model="receiverInfo.address.zipCode">
                  <div class="invalid-feedback">
                    Zip code required.
                  </div>
                </div>
              </div>
              <div class="mb-3">
                <label for="address">주소</label>
                <input type="text" class="form-control" v-model="receiverInfo.address.zipInfo">
                <div class="invalid-feedback">
                  Please enter your shipping address.
                </div>
              </div>

              <div class="mb-3">
                <label for="address2">상세주소 <span class="text-muted">(Optional)</span></label>
                <input type="text" class="form-control" v-model="receiverInfo.address.zipInfoDetail">
              </div>
              <!-- <div class="row">
                <div class="col-md-3 mb-3">
                  <label for="cc-expiration">전화번호</label>
                  <input type="text" class="form-control" v-model="receiverInfo.phoneNumber.mNumber">
                  <div class="invalid-feedback">
                    Expiration date required
                  </div>
                </div>
                <div class="col-md-3 mb-3">
                  <label for="cc-cvv">-</label>
                  <input type="text" class="form-control" v-model="receiverInfo.phoneNumber.mNumber">
                  <div class="invalid-feedback">
                    Security code required
                  </div>
                </div>
                <div class="col-md-3 mb-3">
                  <label for="cc-cvv">-</label>
                  <input type="text" class="form-control" v-model="receiverInfo.phoneNumber.lNmber">
                  <div class="invalid-feedback">
                    Security code required
                  </div>
                </div>
              </div> -->
              <hr class="mb-4">



              <h4 class="mb-3">결제</h4>
              <div class="row">
                <div class="col-md-6 mb-3">
                  <label for="cc-name">카드 성명</label>
                  <input type="text" class="form-control" v-model="paymentInfo.nameOnCard">
                  <small class="text-muted">카드에 있는 이름을 표기해주세요.</small>
                  <div class="invalid-feedback">
                    Name on card is required
                  </div>
                </div>
                <div class="col-md-6 mb-3">
                  <label for="cc-number">카드번호</label>
                  <input type="text" class="form-control" v-model="paymentInfo.cardNumber">
                  <div class="invalid-feedback">
                    Credit card number is required
                  </div>
                </div>
              </div>
              <div class="row">
                <div class="col-md-3 mb-3">
                  <label for="cc-expiration">만료일</label>
                  <input type="text" class="form-control" v-model="paymentInfo.expiration" >
                  <div class="invalid-feedback">
                    Expiration date required
                  </div>
                </div>
                <div class="col-md-3 mb-3">
                  <label for="cc-cvv">CVV</label>
                  <input type="text" class="form-control" v-model="paymentInfo.cvv">
                  <div class="invalid-feedback">
                    Security code required
                  </div>
                </div>
              </div>
              <hr class="mb-4">
              <div class="custom-control custom-checkbox">
                <input type="checkbox" class="custom-control-input"  v-model="aggree">
                <label class="custom-control-label" for="same-address">구매내역에 동의하시겠습니까?</label>
              </div>
              <hr class="mb-4">
               위 정보는 오직 상품 구매 및 배송의 목적으로만 사용 되어질 예정입니다.
              <button class="btn btn-primary btn-lg btn-block" type="button" @click="buy">결제하기</button>
            </form>
          </div>
        </div>
</template>
<script>
export default{
  data () {
    return {
      receiverInfo : {name:'',
                      address : {
                          zipCode:'',
                          zipInfo:'',
                          zipInfoDetail:''
                        },
                       phoneNumber:{
                         fNumber:'',
                         mNumber:'',
                         lNmber:''
                       }
                      },
      orderedItems : null ,
      totalSum : 0 ,
      paymentInfo : {nameOnCard:'',
                     cardNumber:'',
                     expiration:'',
                     cvv:''} ,
      aggree : false
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
      this.orderedItems = this.$route.params
      this.totalSum =  this.orderedItems.reduce((sum,value) => value.item.price * value.amount + sum,0)

      this.$http.post("/order/page")
          .then(({data}) => {
              //console.log(data)
              console.log(data.userInfo.nickName)
              this.receiverInfo.address = data.userInfo.address
              this.receiverInfo.name = data.userInfo.nickName
              this.receiverInfo.email = data.userInfo.email
            //  this.receiverInfo.phoneNumber = data.userInfo.phoneNumber
          })
    },buy(){
      let params = new URLSearchParams();

      params.append('name', this.receiverInfo.name);
      params.append('email', this.email);

      params.append('address.zipCode', this.receiverInfo.address.zipCode);
      params.append('address.zipInfo', this.receiverInfo.address.zipInfo);
      params.append('address.zipInfoDetail', this.receiverInfo.address.zipInfoDetail);

      params.append('phoneNumber.fNumber', this.receiverInfo.phoneNumber.mNumber);
      params.append('phoneNumber.mNumber', this.receiverInfo.phoneNumber.mNumber);
      params.append('phoneNumber.lNmber', this.receiverInfo.phoneNumber.lNmber);

      params.append('nameOnCard', this.paymentInfo.nameOnCard);
      params.append('paymentInfo', this.paymentInfo.paymentInfo);
      params.append('expiration', this.paymentInfo.expiration);
      params.append('cvv', this.paymentInfo.cvv);
      params.append('totalSum',10000);

      let count = 0;
      for(let orderedItem of this.orderedItems){
        params.append('orderedItems['+count+'].itemCd', orderedItem.item.itemCd);
        params.append('orderedItems['+count+'].sum', orderedItem.item.price);
        params.append('orderedItems['+count+'].amount', orderedItem.amount);
        count++;
      }

      this.$http.post("/order/purchase",params)
          .then(({data}) =>{

          })
    }
  }
}
</script>
