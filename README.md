# wish-list-app
any one!! pleaze pull request

누구나 PR 부탁드립니다


[wiki](https://github.com/Po-Zzo/wish-list-app.wiki.git)


## About
쇼핑몰 [안다르](https://andar.co.kr/product/detail.html?product_no=7295&cate_no=2030&display_group=1#none) 의 가격 추적 기능 제공을 목적으로 합니다.


## todolist

- [x] andar 프로덕트 리스트 api 가져오기
- [x] andar 프로덕트 디테일 api 가져오기
- [ ] 프로덕트 정보 갱신 하기 
- [ ] 위시 리스트에 아이템 추가/변경/삭제/구매 하기 
- [ ] 유저 추가하기
- [ ] 프로덕트 갱신 스케줄러 만들기 
- [ ] 간단한 프론트엔드만들어서 배포하기
- [ ] 고도화 진행하기

## usecase
1. 유저가 위시리스트 앱에 아이템을 추가하는 방법
    1. 브라우저 주소창의 아이템을 복사한다 -> 앱에 접속시 클립보드의 내용을 확인시켜주고 자동 등록할 지 묻는다
    2. 공유하기를 누른다. 

1. 나의 리스트 조회기능을 제공한다.
1. 리스트 구매완료 기능을 제공한다
    1. 상품 trace 기능에 의해, 처음 가격을 조회한 시점과 구매한 시점의 이득을 보여준다. 
1. 상품 trace 기능을 제공한다.
    1. 상품이 삭제되었는지 알 수 있다
    1. 상품이 품절 되었는 지 알 수 있다.
    1. 비슷한 상품을 조회할 수 있는지 보여준다.
    1. 사이트 구조를 파싱하여
        1. 대표 이미지 선정
        1. 원본 사이트로 이동
        1. 현재 가능한 옵션 조회
        1. 가격 조회 (원본 가격, 할인 가격, 과거 가격 변동, 최저가알림, 할인기간  )을 제공한다. 

## db 설계
- https://gitmind.com/app/flowchart/45e11320732

## Andar API
- 제품상세 https://andar.co.kr/api/v2/productsdetail/7207
- 카테고리 https://andarcate.co.kr/api/list
- 연관 상품 https://fit7.cre.ma/andar.co.kr/fit/products/7266/similar_products?id=7266&nonmember_token=&widget_id=35
- 모든 리스트: https://andargift.co.kr/gift/api/get_config


 

