<template>
<div class="container">
  <div class="row">
    <div class="col-md-8 order-md-1">
              <h4 class="mb-3">회원정보</h4>
              <form class="needs-validation" novalidate="">
                <div class="mb-3">
                  <label for="username">ID</label>
                  <div class="input-group">
                    <input type="text" class="form-control" id="username" placeholder="id" required="">
                    <div class="invalid-feedback">
                      Your username is required.
                    </div>
                  </div>
                </div>

                <div class="mb-3">
                  <label for="password">비밀번호</label>
                  <div class="input-group">
                    <input type="text" class="form-control" id="password" placeholder="Password" required="">
                    <div class="invalid-feedback">
                      Your username is required.
                    </div>
                  </div>
                </div>

                <div class="mb-3">
                  <label for="password2">비밀번호 확인</label>
                  <div class="input-group">
                    <input type="text" class="form-control" id="password2" placeholder="Password Confirm" required="">
                    <div class="invalid-feedback">
                      Your username is required.
                    </div>
                  </div>
                </div>

                <div class="mb-3">
                  <label for="nickname">닉네임</label>
                  <div class="input-group">
                    <input type="text" class="form-control" id="nickname" placeholder="닉네임을 입력해주세요." value="" required="">
                    <div class="invalid-feedback">
                      Valid first name is required.
                    </div>
                  </div>
                </div>
                <div class="row">

                  <div class="col-md-3 mb-3">
                    <label for="zip1">우편 번호</label>
                    <input type="text" class="form-control" id="zip1" placeholder="" required="">
                    <div class="invalid-feedback">
                      Zip code required.
                    </div>
                  </div>

                  <div class="col-md-3 mb-3">
                    <label for="zip2">-</label>
                    <input type="text" class="form-control" id="zip2" placeholder="" required="">
                    <div class="invalid-feedback">
                      Zip code required.
                    </div>
                  </div>
                </div>
                <div class="mb-3">
                  <label for="address">주소</label>
                  <input type="text" class="form-control" id="address" required="">
                  <div class="invalid-feedback">
                    주소를 입력해주세요.
                  </div>
                </div>

                <div class="mb-3">
                  <label for="address2">상세 주소</label>
                  <input type="text" class="form-control" id="address2">
                </div>

                <hr class="mb-4">
                <div class="custom-control custom-checkbox">
                  <input type="checkbox" class="custom-control-input" id="save-info">
                  <label class="custom-control-label" for="save-info">아래 약관에 동의하시겠습니까?</label>
                </div>
                <hr class="mb-4">
                 신원 확인 및 이벤트 용도로 사용 되어질 예정입니다.
                <hr class="mb-4">
                <button class="btn btn-primary btn-lg btn-block" type="submit">회원가입</button>
              </form>
            </div>
  </div>
</div>
</template>
