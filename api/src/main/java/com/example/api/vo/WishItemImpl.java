package com.example.api.vo;

import com.example.api.enums.WishItemStatus;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class WishItemImpl implements WishItem {

  private final WishItemId wishListItemId;
  private final ProductId productId;
  private final DateVO registerDate;
  private final Price purchasePrice;
  private final Price profitPrice;
  private final WishItemStatus wishItemStatus;

}
