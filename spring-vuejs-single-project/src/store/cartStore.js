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
    const params = new URLSearchParams();
    params.append('searchType', this.searchType);
    params.append('searchValue', this.searchValue);
    commit('addStock',{item,quantity});
  }
}

const mutations = {
  addStock(state,{item,quantity}){
    let stock = state.stocks.find(stock=> stock.item.itemCd === item.itemCd)

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
