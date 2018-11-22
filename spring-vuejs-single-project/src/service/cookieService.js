export default {
   set(name, value, exp){
    console.log(document.cookie);
    if(exp === null){
      document.cookie = namae + '=' + value + ';path=/';

    }else{
      var date = new Date();
      date.setTime(date.getTime() + exp*24*60*60*1000);
      document.cookie = namae + '=' + value + ';expires=' + date.toUTCString() + ';path=/';
    }
  },
   get(name){
    var value = document.cookie.match('(^|;) ?' + name + '=([^;]*)(;|$)');
    return value? value[2] : null;
  },
   delete(){
    document.cookie = name + '=; expires=Thu, 01 Jan 1970 00:00:01 GMT;';
  }
}
