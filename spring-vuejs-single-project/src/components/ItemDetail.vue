<template>
  <div class="container">
           <div class="col-md-12">
              <div class="card flex-md-row mb-4 shadow-sm h-md-250">
                <img class="card-img-right flex-auto d-none d-lg-block" data-src="holder.js/200x250?theme=thumb" alt="Thumbnail [200x250]" style="width: 200px; height: 250px;" src="data:image/svg+xml;charset=UTF-8,%3Csvg%20width%3D%22200%22%20height%3D%22250%22%20xmlns%3D%22http%3A%2F%2Fwww.w3.org%2F2000%2Fsvg%22%20viewBox%3D%220%200%20200%20250%22%20preserveAspectRatio%3D%22none%22%3E%3Cdefs%3E%3Cstyle%20type%3D%22text%2Fcss%22%3E%23holder_1666794ce6d%20text%20%7B%20fill%3A%23eceeef%3Bfont-weight%3Abold%3Bfont-family%3AArial%2C%20Helvetica%2C%20Open%20Sans%2C%20sans-serif%2C%20monospace%3Bfont-size%3A13pt%20%7D%20%3C%2Fstyle%3E%3C%2Fdefs%3E%3Cg%20id%3D%22holder_1666794ce6d%22%3E%3Crect%20width%3D%22200%22%20height%3D%22250%22%20fill%3D%22%2355595c%22%3E%3C%2Frect%3E%3Cg%3E%3Ctext%20x%3D%2256.203125%22%20y%3D%22131%22%3EThumbnail%3C%2Ftext%3E%3C%2Fg%3E%3C%2Fg%3E%3C%2Fsvg%3E" data-holder-rendered="true">
                <div class="card-body d-flex flex-column align-items-start">
                  <strong class="d-inline-block mb-2 text-primary">책</strong>
                  <h3 class="mb-0">
                    <a class="text-dark" href="#">{{item.itemNm}}</a>
                  </h3>

                  <p class="card-text mb-auto">{{item.itemDesc}}</p>
                  <span class="badge badge-info">연관주제</span>
                    <span class="badge badge-pill badge-success"  v-for="hashTage in item.hashTage">{{hashTage.hashNm}}</span>
                  <div class="mb-1 text-muted">{{item.price | money }} 원</div>
                  <div class="btn-group">
                    <button type="button" class="btn btn-sm btn-outline-secondary" v-on:click="toCart(item)">장바구니</button>
                    <button type="button" class="btn btn-sm btn-outline-secondary">구매하기</button>
                  </div>
                </div>
              </div>
            </div>
            <div class="my-3 p-3 bg-white rounded shadow-sm">
                    <h6 class="border-bottom border-n gray pb-2 mb-0">리뷰</h6>
                    <div class="media text-muted pt-3" v-for="review in reviews">
                      <img data-src="holder.js/32x32?theme=thumb&amp;bg=007bff&amp;fg=007bff&amp;size=1" alt="32x32" class="mr-2 rounded" style="width: 32px; height: 32px;" src="data:image/svg+xml;charset=UTF-8,%3Csvg%20width%3D%2232%22%20height%3D%2232%22%20xmlns%3D%22http%3A%2F%2Fwww.w3.org%2F2000%2Fsvg%22%20viewBox%3D%220%200%2032%2032%22%20preserveAspectRatio%3D%22none%22%3E%3Cdefs%3E%3Cstyle%20type%3D%22text%2Fcss%22%3E%23holder_166d953356d%20text%20%7B%20fill%3A%23007bff%3Bfont-weight%3Abold%3Bfont-family%3AArial%2C%20Helvetica%2C%20Open%20Sans%2C%20sans-serif%2C%20monospace%3Bfont-size%3A2pt%20%7D%20%3C%2Fstyle%3E%3C%2Fdefs%3E%3Cg%20id%3D%22holder_166d953356d%22%3E%3Crect%20width%3D%2232%22%20height%3D%2232%22%20fill%3D%22%23007bff%22%3E%3C%2Frect%3E%3Cg%3E%3Ctext%20x%3D%2211.546875%22%20y%3D%2216.9%22%3E32x32%3C%2Ftext%3E%3C%2Fg%3E%3C%2Fg%3E%3C%2Fsvg%3E" data-holder-rendered="true">
                      <p class="media-body pb-3 mb-0 small lh-125 border-bottom border-gray">
                        <strong class="d-block text-gray-dark">@{{review.createId}}</strong>
                        {{review.comments}}
                      </p>
                    </div>

            </div>
    </div>
</template>

<script>
import { mapActions } from 'vuex'

export default{
  data (){
    return {
       item : null
      ,reviews : null
    }
  },
  created (){
    this.fetchData()
  },
  watch: {
     '$route': 'fetchData'
  },
  methods: {
    fetchData(){
        this.$http.post('/items/'+this.$route.params.itemCd)
        .then(({data}) => {
           this.item = data.item;
           this.reviews = data.reviews;
        })
        .catch(()=>{})
    },toCart(item){
      const params = new URLSearchParams();
      params.append('itemCd', item.itemCd);
      params.append('quantity', 1);

      this.$http.post('/cart/add',params)
       .then(() => {
         addItemToCart(item)
      })
    }
    ,...mapActions(
         'cart',{addItemToCart:'addItemToCart'}
    )
  }

}
</script>
