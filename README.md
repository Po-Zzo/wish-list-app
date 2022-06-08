<p align="center">
  <a href="http://nestjs.com/" target="blank"><img src="https://nestjs.com/img/logo_text.svg" width="320" alt="Nest Logo" /></a>
</p>

[circleci-image]: https://img.shields.io/circleci/build/github/nestjs/nest/master?token=abc123def456
[circleci-url]: https://circleci.com/gh/nestjs/nest

  <p align="center">A progressive <a href="http://nodejs.org" target="_blank">Node.js</a> framework for building efficient and scalable server-side applications.</p>
    <p align="center">
<a href="https://www.npmjs.com/~nestjscore" target="_blank"><img src="https://img.shields.io/npm/v/@nestjs/core.svg" alt="NPM Version" /></a>
<a href="https://www.npmjs.com/~nestjscore" target="_blank"><img src="https://img.shields.io/npm/l/@nestjs/core.svg" alt="Package License" /></a>
<a href="https://www.npmjs.com/~nestjscore" target="_blank"><img src="https://img.shields.io/npm/dm/@nestjs/common.svg" alt="NPM Downloads" /></a>
<a href="https://circleci.com/gh/nestjs/nest" target="_blank"><img src="https://img.shields.io/circleci/build/github/nestjs/nest/master" alt="CircleCI" /></a>
<a href="https://coveralls.io/github/nestjs/nest?branch=master" target="_blank"><img src="https://coveralls.io/repos/github/nestjs/nest/badge.svg?branch=master#9" alt="Coverage" /></a>
<a href="https://discord.gg/G7Qnnhy" target="_blank"><img src="https://img.shields.io/badge/discord-online-brightgreen.svg" alt="Discord"/></a>
<a href="https://opencollective.com/nest#backer" target="_blank"><img src="https://opencollective.com/nest/backers/badge.svg" alt="Backers on Open Collective" /></a>
<a href="https://opencollective.com/nest#sponsor" target="_blank"><img src="https://opencollective.com/nest/sponsors/badge.svg" alt="Sponsors on Open Collective" /></a>
  <a href="https://paypal.me/kamilmysliwiec" target="_blank"><img src="https://img.shields.io/badge/Donate-PayPal-ff3f59.svg"/></a>
    <a href="https://opencollective.com/nest#sponsor"  target="_blank"><img src="https://img.shields.io/badge/Support%20us-Open%20Collective-41B883.svg" alt="Support us"></a>
  <a href="https://twitter.com/nestframework" target="_blank"><img src="https://img.shields.io/twitter/follow/nestframework.svg?style=social&label=Follow"></a>
</p>
  <!--[![Backers on Open Collective](https://opencollective.com/nest/backers/badge.svg)](https://opencollective.com/nest#backer)
  [![Sponsors on Open Collective](https://opencollective.com/nest/sponsors/badge.svg)](https://opencollective.com/nest#sponsor)-->

## Description

[Nest](https://github.com/nestjs/nest) framework TypeScript starter repository.

## Installation

```bash
$ npm install
```

## Running the app

```bash
# development
$ npm run start

# watch mode
$ npm run start:dev

# production mode
$ npm run start:prod
```

## Test

```bash
# unit tests
$ npm run test

# e2e tests
$ npm run test:e2e

# test coverage
$ npm run test:cov
```

## Support

Nest is an MIT-licensed open source project. It can grow thanks to the sponsors and support by the amazing backers. If you'd like to join them, please [read more here](https://docs.nestjs.com/support).

## Stay in touch

- Author - [Kamil Myśliwiec](https://kamilmysliwiec.com)
- Website - [https://nestjs.com](https://nestjs.com/)
- Twitter - [@nestframework](https://twitter.com/nestframework)

## License

Nest is [MIT licensed](LICENSE).


## Project
가장 처음으로 [안다르](https://andar.co.kr/product/detail.html?product_no=7295&cate_no=2030&display_group=1#none) 사이트의 trace 앱을 제공합니다.

1. 유저가 위시리스트 앱에 아이템을 추가하는 방법
    1. 브라우저 주소창의 아이템을 복사한다 -> 앱에 접속시 클립보드의 내용을 확인시켜주고 자동 등록할 지 묻는다
    1. 공유하기를 누른다.

1. 리스트 조회기능을 제공한다.

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


db 설계
- https://gitmind.com/app/flowchart/45e11320732

api 리스트
- 제품 https://andar.co.kr/api/v2/productsdetail/7207
- 카테고리 https://andarcate.co.kr/api/list
- https://fit7.cre.ma/andar.co.kr/fit/products/7266/similar_products?id=7266&nonmember_token=&widget_id=35
- 요청 URL: https://andargift.co.kr/gift/api/get_config

