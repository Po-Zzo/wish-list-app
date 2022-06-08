import {Module} from '@nestjs/common';
import {ProductsController} from './product.controller';
import {ProductsService} from './product.service';
import {ProductsAxios} from './product.axios';
import {ProductsServiceImpl} from './product.service.impl';
import {ProductsAxiosImpl} from './product.axios.impl';

@Module({
  controllers: [ProductsController],
  providers: [
    { provide: 'ProductsService', useClass: ProductsServiceImpl },
    { provide: 'ProductsAxios', useClass: ProductsAxiosImpl },
  ],
  exports: []
})
export class ProductsModule {

}
