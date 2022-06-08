import {Controller, Get, HttpCode, HttpStatus, Inject} from '@nestjs/common';
import {ProductsService} from './product.service';

@Controller({
  path: 'products',
  version: '1',
})
export class ProductsController {

  constructor(@Inject('ProductsService') private readonly productsService: ProductsService) {
  }

  @Get()
  @HttpCode(HttpStatus.OK)
  async test() {
    const response = await this.productsService.fetchProducts();
    return 'test';
  }
}
