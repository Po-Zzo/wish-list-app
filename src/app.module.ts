import {Module} from '@nestjs/common';
import {AppController} from './app.controller';
import {AppService} from './app.service';
import {UsersModule} from './users/user.module';
import {WishListModule} from './wishList/wish.list.module';

@Module({
  imports: [
    UsersModule,
    WishListModule,
  ],
  controllers: [AppController],
  providers: [AppService],
})
export class AppModule {
}
