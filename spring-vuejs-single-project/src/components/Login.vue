<template>
  <div class="col-md-8 order-md-2">
         <h4 class="mb-3">로그인</h4>

           <div class="mb-3">
             <label for="username">아이디</label>
               <input type="text" class="form-control" id="username" placeholder="USER NAME" v-model="username" required="true">
           </div>
           <div class="mb-3">
             <label for="password">비밀번호</label>
             <input type="password" class="form-control" id="password" placeholder="PASSWORD" v-model="password"  required="true">
           </div>
           <button  class="btn btn-primary btn-lg btn-block"  @click="login()">로그인</button>
 </div>
</template>
<script>
//import {Cookie} from '../service/cookieService.js'

export default {
  data (){
    return {
      username : '',
      password : ''
    }
  },
  methods:{
      login(event){

       const auth =  {auth:{ username : "normal-app" , password : 'secret'}}

       const params = new URLSearchParams();
       params.append('grant_type', 'password');
       params.append('username', this.username);
       params.append('password', this.password);
       params.append('client_id', 'normal-app');

      this.$http.post('/oauth/token', params,auth)
        .then(({data})=>{
              this.$http.defaults.headers.common['Authorization'] = `Bearer `+ data.access_token;
              this.$cookies.set("AuthToken",data.access_token,"0");
         })
         .catch(()=>{
      })

        // var httpRequest = new XMLHttpRequest();
        //
        // httpRequest.open('POST', 'http://test.sample-project.com:8080/oauth/token');
        // httpRequest.setRequestHeader('Authorization', 'Basic normal-app:secret');
        // httpRequest.setRequestHeader('Content-type', 'application/x-www-form-urlencoded; charset=utf-8');
        //
        // httpRequest.send('userName=' + encodeURIComponent("TESTER")
        //                   +'&password=' + encodeURIComponent("TESTER")
        //                 +'&grant_type=' + encodeURIComponent("password")
        //                 +'&scope='+encodeURIComponent("me")
        //               +'&client_id=' + encodeURIComponent("normal-app"));

      }

  }


}
</script>
