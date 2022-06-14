package com.example.api.vo;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor(staticName = "of")
public class ImageImpl implements Image {

  private final String imageUrl;

}
