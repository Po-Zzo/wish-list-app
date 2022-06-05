import {Controller, Get, HttpCode, HttpStatus} from "@nestjs/common";
import {UsersService} from "./user.service";

@Controller({
  path: 'users',
  version: '1',
})
export class UsersController {

  constructor(private readonly usersService: UsersService) {
  }

  @Get()
  @HttpCode(HttpStatus.OK)
  test() {
    return 'test';
  }
}
