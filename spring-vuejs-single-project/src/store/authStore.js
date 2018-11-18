const state = {
  token : null ,
  username : ""
}

const getters = {
   isLogin(){
     return state.token !== null
   }
}

const actions = {
   setLoginInfo({commit},loginInfo){
      commit('updateState',loginInfo);
   }
}

const mutations = {
    updateState(state,loginInfo){
     state = loginInfo
   }
}


export default {
  namespaced: true,
  state,
  getters,
  mutations
}
