package com.example.api.vo;

import java.util.ArrayList;
import java.util.List;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor(staticName = "of")
public class Urls {

  private final List<Url> urls = new ArrayList<>();

  public static Urls of(Url url) {
    Urls urls = Urls.of();
    urls.add(url);

    return urls;
  }

  public boolean add(Url url) {
    return this.urls.add(url);
  }

}
