<template>
<div class="container">
  <div class="row">
    <div class="col-md-8 order-md-1">
              <h4 class="mb-3">회원정보</h4>
                <div class="mb-3">
                  <label for="username">ID</label>
                  <div class="input-group">
                    <input type="text" class="form-control" v-model="userName" >
                  </div>
                </div>
                <div class="mb-3">
                  <label for="password">비밀번호</label>
                  <div class="input-group">
                    <input type="text" class="form-control" v-model="password" >
                  </div>
                </div>
                <div class="mb-3">
                  <label for="password2">비밀번호 확인</label>
                  <div class="input-group">
                    <input type="text" class="form-control">
                  </div>
                </div>
                <div class="mb-3">
                  <label for="nickname">성명</label>
                  <div class="input-group">
                    <input type="text" class="form-control" v-model="nickName" >
                  </div>
                </div>
                <div class="row">
                  <div class="col-md-3 mb-3">
                    <label for="zip1">전화번호</label>
                    <input type="text" class="form-control" v-model="phoneNumber.fnumber" >
                  </div>
                  <div class="col-md-3 mb-3">
                    <label for="zip1">-</label>
                    <input type="text" class="form-control" v-model="phoneNumber.mnumber" >
                  </div>
                  <div class="col-md-3 mb-3">
                    <label for="zip1">-</label>
                    <input type="text" class="form-control" v-model="phoneNumber.lnmber" >
                  </div>
                </div>
                <div class="mb-3">
                  <label for="nickname">이메일</label>
                  <div class="input-group">
                    <input type="text" class="form-control" v-model="email" >
                  </div>
                </div>
                <div class="row">
                  <div class="col-md-3 mb-3">
                    <label for="zip1">우편 번호</label>
                    <input type="text" class="form-control" v-model="address.zipCode" >
                  </div>
                  <!-- <div class="col-md-3 mb-3">
                    <label for="zip2">-</label>
                    <input type="text" class="form-control">
                  </div> -->
                </div>
                <div class="mb-3">
                  <label for="address">주소</label>
                  <input type="text" class="form-control" v-model="address.zipInfo" >
                </div>
                <div class="mb-3">
                  <label for="address2">상세 주소</label>
                  <input type="text" class="form-control" v-model="address.zipInfoDetail" >
                </div>
                <hr class="mb-4">
                <div class="custom-control custom-checkbox">
                  <input type="checkbox" class="custom-control-input">
                  <label class="custom-control-label" for="save-info">아래 약관에 동의하시겠습니까?</label>
                </div>
                <hr class="mb-4">
                 신원 확인 및 이벤트 용도로 사용 되어질 예정입니다.
                <hr class="mb-4">
                <button class="btn btn-primary btn-lg btn-block" type="button" @click="join()">회원가입</button>
            </div>
  </div>
</div>
</template>
<script>
export default {
  data (){
    return {
      userName:'',
      nickName:'',
      password:'',
      address : {
          zipCode:'',
          zipInfo:'',
          zipInfoDetail:''
        },
       phoneNumber:{
         fnumber:'',
         mnumber:'',
         lnmber:''
       },
       email:''
     }
  },
  methods :{
    join(){
      const params = new URLSearchParams();
      params.append('userName', this.userName);
      params.append('nickName', this.nickName);
      params.append('password', this.password);
      params.append('address.zipCode', this.address.zipCode);
      params.append('address.zipInfo', this.address.zipInfo);
      params.append('address.zipInfoDetail', this.address.zipInfoDetail);
      params.append('phoneNumber.fNumber', this.phoneNumber.fnumber);
      params.append('phoneNumber.mNumber', this.phoneNumber.mnumber);
      params.append('phoneNumber.lNmber', this.phoneNumber.lnmber);
      params.append('email', this.email);
      this.$http.post('/members',params)
    }
  }
}
</script>
