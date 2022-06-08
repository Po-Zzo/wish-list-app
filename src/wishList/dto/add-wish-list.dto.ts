import {ApiProperty} from '@nestjs/swagger';

export class AddWishListDto {

  @ApiProperty({
    description: '유저 id',
  })
  userId: string;

  @ApiProperty({
    description: '위시 리스트에 추가할 아이템 링크',
    example: 'https://andar.co.kr/product/detail.html?product_no=7266&cate_no=2152'
  })
  link: string;

}
