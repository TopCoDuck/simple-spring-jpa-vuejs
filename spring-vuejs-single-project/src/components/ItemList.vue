<template>
  <div class="album py-5">
          <div class="container">
            <div class="row text-center">
              <label for="exampleInputEmail1" class="col-md-1">검색</label>
              <select class="form-control col-md-1" v-model="searchType" >
                <option value="ALL">전체</option>
                <option value="NAME">제목</option>
                <option value="DESC">내용</option>
              </select>
              <input type="text" class="form-control col-md-6" v-model="searchValue">
              <button type="button" class="btn btn-sm btn-outline-secondary" @click="search()">검색</button>
            </div>

            <div class="row">
              <div class="col-md-4" v-for="item in items">
                <div class="card mb-4 shadow-sm">
                  <img class="card-img-top" data-src="holder.js/100px225?theme=thumb&amp;bg=55595c&amp;fg=eceeef&amp;text=Thumbnail" alt="Thumbnail [100%x225]" style="height: 225px; width: 100%; display: block;" src="data:image/svg+xml;charset=UTF-8,%3Csvg%20width%3D%22208%22%20height%3D%22225%22%20xmlns%3D%22http%3A%2F%2Fwww.w3.org%2F2000%2Fsvg%22%20viewBox%3D%220%200%20208%20225%22%20preserveAspectRatio%3D%22none%22%3E%3Cdefs%3E%3Cstyle%20type%3D%22text%2Fcss%22%3E%23holder_16667489839%20text%20%7B%20fill%3A%23eceeef%3Bfont-weight%3Abold%3Bfont-family%3AArial%2C%20Helvetica%2C%20Open%20Sans%2C%20sans-serif%2C%20monospace%3Bfont-size%3A11pt%20%7D%20%3C%2Fstyle%3E%3C%2Fdefs%3E%3Cg%20id%3D%22holder_16667489839%22%3E%3Crect%20width%3D%22208%22%20height%3D%22225%22%20fill%3D%22%2355595c%22%3E%3C%2Frect%3E%3Cg%3E%3Ctext%20x%3D%2266.953125%22%20y%3D%22117.3%22%3EThumbnail%3C%2Ftext%3E%3C%2Fg%3E%3C%2Fg%3E%3C%2Fsvg%3E" data-holder-rendered="true">
                  <div class="card-body">
                    <p class="card-text" @click="detail(item.itemCd)">{{ item.itemNm }}</p>
                    <div class="d-flex justify-content-between align-items-center">
                      <div class="btn-group">
                        <button type="button" class="btn btn-sm btn-outline-secondary" @click="toCart(item)">장바구니</button>
                        <button type="button" class="btn btn-sm btn-outline-secondary">구매하기</button>
                      </div>
                      <small class="text-muted">{{ item.price | money }} 원</small>
                    </div>
                  </div>
                </div>
              </div>
            </div>
          </div>
<nav aria-label="Page navigation example text-center">
  <ul class="pagination">
    <li class="page-item"><a class="page-link" href="#"><</a></li>
    <li class="page-item"><a class="page-link" href="#">1</a></li>
    <li class="page-item"><a class="page-link" href="#">2</a></li>
    <li class="page-item"><a class="page-link" href="#">3</a></li>
    <li class="page-item"><a class="page-link" href="#">></a></li>
  </ul>
 </nav>
  </div>
</template>

<script>
import { mapActions } from 'vuex'

export default{
  data () {
    return {
      items : null ,
      searchType : 'ALL',
      searchValue : ''
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
      this.$http.post('/items')
        .then(({data}) => {
          this.items = data.content
        })
    },detail(itemCd){
         this.$router.push({path:'/item-detail/'+itemCd} )
    },search(){
      const params = new URLSearchParams();
      params.append('searchType', this.searchType);
      params.append('searchValue', this.searchValue);
      this.$http.post('/items',params)
       .then(({data}) => {
             this.items = data.content
       })
    },toCart(item){
      const params = new URLSearchParams();
      params.append('itemCd', item.itemCd);
      params.append('quantity', 1);

      this.$http.post('/cart/add',params)
       .then(() => {
         this.addItemToCart(item)
      })
    }
    ,...mapActions(
         'cart',{addItemToCart:'addItemToCart'}
    )
  }
}

</script>
