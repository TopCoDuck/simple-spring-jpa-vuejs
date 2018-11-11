// class StockModel{
//   constructor(item,quantity){
//     this.item = item
//     this.amount = quantity
//   }
//
//   pluse(quantity){
//     this.amount += quantity
//   }
//
//   getItemCd(){
//     return  this.item.itemCd
//   }
//
//   getAmount(){
//     return this.amount
//   }
// }

const state = {
  stocks: []
}

const getters = {
  stockCnt (){
     var stockCnt = 0;
     for(let stock of state.stocks){
       stockCnt += stock.amount
     }
     return stockCnt
  }
}

const actions = {
  addItemToCart({commit},item,quantity=1){
    commit('addItem',{item,quantity});
  }
}

const mutations = {
  addItem(state,{item,quantity}){
    let stock = state.stocks.find(stock=> stock.item.itemCd === item.itemCd)
    console.log(stock);
    if(stock === undefined){
      state.stocks.push(
        {"item":item,"amount":quantity}
      )
    }else {
      stock.amount += quantity;
    }
  }
}

export default {
  namespaced: true,
  state,
  getters,
  actions,
  mutations
}
