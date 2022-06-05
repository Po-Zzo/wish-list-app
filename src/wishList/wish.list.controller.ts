import {Controller, HttpCode, HttpStatus, Post, Query} from '@nestjs/common';
import {WishListService} from "./wish.list.service";
import {ApiCreatedResponse, ApiOperation, ApiTags} from '@nestjs/swagger';
import {AddWishListDto} from './dto/add-wish-list.dto';

@ApiTags('위시 리스트 API')
@Controller({
  path: 'wish-list',
  version: '1',
})
export class WishListController {

  constructor(private readonly usersService: WishListService) {
  }

  /**
   *
   */
  @Post()
  @HttpCode(HttpStatus.OK)
  @ApiOperation({ summary: '요약', description: '상세' })
  @ApiCreatedResponse({ description: 'test', type: String })
  test(@Query() addWishListDto: AddWishListDto ) {
    return 'test';
  }
}
