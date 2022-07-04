package com.courtauction.rest;

import lombok.RequiredArgsConstructor;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
@RequiredArgsConstructor
public class CourtAuctionRest {

    private static final String LIST_API = "https://www.courtauction.go.kr/RetrieveRealEstMulDetailList.laf";

    private final RestTemplate restTemplate;

    public void fetchList() {

        HttpHeaders headers = new HttpHeaders();
        headers.add("Host", "ANDAR_API_APP_KEY");
        headers.add("User-Agent", "ANDAR_API_APP_KEY");

        String uri = LIST_API + "?bubwLocGubun=1&jiwonNm=%BC%AD%BF%EF%C1%DF%BE%D3%C1%F6%B9%E6%B9%FD%BF%F8&jpDeptCd=000000&daepyoSidoCd=&daepyoSiguCd=&daepyoDongCd=&notifyLoc=on&rd1Cd=&rd2Cd=&realVowel=35207_45207&rd3Rd4Cd=&notifyRealRoad=on&saYear=2022&saSer=&ipchalGbncd=&termStartDt=2022.07.04&termEndDt=2022.07.18&lclsUtilCd=&mclsUtilCd=&sclsUtilCd=&gamEvalAmtGuganMin=&gamEvalAmtGuganMax=&notifyMinMgakPrcMin=&notifyMinMgakPrcMax=&areaGuganMin=&areaGuganMax=&yuchalCntGuganMin=&yuchalCntGuganMax=&notifyMinMgakPrcRateMin=&notifyMinMgakPrcRateMax=&srchJogKindcd=&mvRealGbncd=00031R&srnID=PNO102001&_NAVI_CMD=&_NAVI_SRNID=&_SRCH_SRNID=PNO102001&_CUR_CMD=InitMulSrch.laf&_CUR_SRNID=PNO102001&_NEXT_CMD=RetrieveRealEstMulDetailList.laf&_NEXT_SRNID=PNO102002&_PRE_SRNID=&_LOGOUT_CHK=&_FORM_YN=Y";
        String body = restTemplate.postForEntity(uri,
                new HttpEntity<>(headers),
                String.class).getBody();

        Elements table = Jsoup.parse(body)
                .getElementsByClass("Ltbl_list");
    }
}
