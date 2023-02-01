package com.courtauction.rest;

import java.util.List;
import java.util.Set;
import org.springframework.http.HttpHeaders;
import org.springframework.stereotype.Component;

@Component
public interface CourtAuctionRest {

    void fetchList();
    Set<String> fetchCourts();

    static HttpHeaders getHttpHeaders() {
        HttpHeaders headers = new HttpHeaders();
        headers.add("Host", "www.courtauction.go.kr");
        headers.add("User-Agent", "Mozilla/5.0 (Macintosh; Intel Mac OS X 10_15_7) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/103.0.5060.53 Safari/537.36");
        headers.add("Referer", "ttps://www.courtauction.go.kr/RetrieveRealEstMulDetailList.laf");
        return headers;
    }
}
