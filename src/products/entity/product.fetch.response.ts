import {Expose} from 'class-transformer';

export class ProductFetchResponse {
  pList: Array<ProductFetchItemResponse>;

  constructor({ pList }) {
    this.pList = pList;
  }
}

export class ProductFetchItemResponse {

  @Expose({ name: 'product_no'})
  productNo: number;

  isGift: boolean;

}
