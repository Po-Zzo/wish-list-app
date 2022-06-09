package com.example.api.vo;

import java.util.List;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class WishListImpl implements WishList {

  private final List<WishItem> wishItemList;

}
