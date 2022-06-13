package com.example.api.vo;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor(staticName = "of")
public class UrlImpl implements Url {

  private final String url;
}
