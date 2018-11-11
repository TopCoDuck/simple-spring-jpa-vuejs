const state = {
   token : null
}


const getters = {
   isLogin(){
     return state.token !=== null
   }
}

const mutations = {
   logined(){
     //????
   }
}


export default {
  namespaced: true,
  state,
  getters,
  mutations
}
