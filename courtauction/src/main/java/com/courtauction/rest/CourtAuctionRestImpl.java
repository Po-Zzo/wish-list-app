package com.courtauction.rest;

import com.courtauction.consts.CourtAuctionPayLoadConsts;
import com.courtauction.consts.CourtAuctionQueryConsts;
import com.courtauction.pojo.CourtClass;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.http.HttpEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
@RequiredArgsConstructor
public class CourtAuctionRestImpl implements CourtAuctionRest {

    private static final String BASE_URI = "https://www.courtauction.go.kr/";
    private static final String LIST_API = BASE_URI + "RetrieveRealEstMulDetailList.laf";
    private static final String OPTION_API = BASE_URI + "InitMulSrch.laf";
    private static final String COURT_CLASS_API = OPTION_API + "?_NEXT_SRNID=PNO102001";


    private final RestTemplate restTemplate;

    @Override
    public void fetchList() {

        String uri = LIST_API + "?bubwLocGubun=1&jiwonNm=%BC%AD%BF%EF%C1%DF%BE%D3%C1%F6%B9%E6%B9%FD%BF%F8&jpDeptCd=000000&daepyoSidoCd=&daepyoSiguCd=&daepyoDongCd=&notifyLoc=on&rd1Cd=&rd2Cd=&realVowel=35207_45207&rd3Rd4Cd=&notifyRealRoad=on&saYear=2022&saSer=&ipchalGbncd=&termStartDt=2022.07.04&termEndDt=2022.07.18&lclsUtilCd=&mclsUtilCd=&sclsUtilCd=&gamEvalAmtGuganMin=&gamEvalAmtGuganMax=&notifyMinMgakPrcMin=&notifyMinMgakPrcMax=&areaGuganMin=&areaGuganMax=&yuchalCntGuganMin=&yuchalCntGuganMax=&notifyMinMgakPrcRateMin=&notifyMinMgakPrcRateMax=&srchJogKindcd=&mvRealGbncd=00031R&srnID=PNO102001&_NAVI_CMD=&_NAVI_SRNID=&_SRCH_SRNID=PNO102001&_CUR_CMD=InitMulSrch.laf&_CUR_SRNID=PNO102001&_NEXT_CMD=RetrieveRealEstMulDetailList.laf&_NEXT_SRNID=PNO102002&_PRE_SRNID=&_LOGOUT_CHK=&_FORM_YN=Y";
        String body = restTemplate.postForEntity(uri,
                new HttpEntity<>(CourtAuctionRest.getHttpHeaders()),
                String.class).getBody();

        Elements trEl = Jsoup.parse(body)
                .getElementsByClass("Ltbl_list")
                .select("tr");

        List<Element> elements = trEl.subList(1, trEl.size());
    }

    @Override
    public CourtClass fetchCourtClass() {
        String body = restTemplate.postForEntity(COURT_CLASS_API,
                new HttpEntity<>(CourtAuctionRest.getHttpHeaders()),
                String.class).getBody();

        return CourtClass.of(Jsoup.parse(body)
                .getElementById(CourtAuctionPayLoadConsts.COURT_CLASS)
                .select(CourtAuctionQueryConsts.OPTION)
                .eachText());
    }

}
