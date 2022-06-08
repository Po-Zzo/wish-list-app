import {Inject, Injectable} from '@nestjs/common';
import {ProductsService} from './product.service';
import {ProductsAxios} from './product.axios';

@Injectable()
export class ProductsServiceImpl implements ProductsService {

  constructor(@Inject('ProductsAxios')  private readonly productsAxios: ProductsAxios) {}

  async fetchProducts() {
    return this.productsAxios.fetchProducts()
  }
}
