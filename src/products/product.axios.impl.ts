import {ProductsAxios} from './product.axios';
import axios from 'axios';
import {Injectable} from '@nestjs/common';
import {ProductFetchResponse} from './entity/product.fetch.response';

@Injectable()
export class ProductsAxiosImpl implements ProductsAxios {

  async fetchProducts() {
    const data = await axios.post<ProductFetchResponse>('https://andargift.co.kr/gift/api/get_config', {
      mall_id: 'andar01'
    }, {}).then(res => res.data);

    return data;

  }

}
