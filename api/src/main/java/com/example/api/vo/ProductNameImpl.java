package com.example.api.vo;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor(staticName = "of")
public class ProductNameImpl implements  ProductName{

  private final String productName;

}
