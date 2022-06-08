import {CacheModule, Module} from '@nestjs/common';
import {UsersModule} from './users/user.module';
import {WishListModule} from './wishList/wish.list.module';
import {ProductsModule} from './products/product.module';

@Module({
  imports: [
    CacheModule.register(),
    UsersModule,
    WishListModule,
    ProductsModule,
  ],
  controllers: [],
  providers: [],
})
export class AppModule {
}
