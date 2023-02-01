package com.courtauction.pojo;

import com.courtauction.rest.CourtAuctionRest;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;

import java.util.HashSet;
import java.util.Set;
import lombok.extern.slf4j.Slf4j;

/**
 * 법원 리스트 객체
 *
 * 싱글턴
 * 예시
 *   0 = "제천지원"
 *   1 = "상주지원"
 *   2 = "안동지원"
 *   3 = "부산동부지원"
 *   4 = "진주지원"
 *   5 = "부산지방법원"
 *   6 = "서산지원"
 *   7 = "부천지원"
 *   8 = "정읍지원"
 *   9 = "군산지원"
 *   10 = "대전지방법원"
 *   11 = "대구서부지원"
 *   12 = "고양지원"
 *   13 = "밀양지원"
 *   14 = "마산지원"
 *   15 = "서울동부지방법원"
 *   16 = "울산지방법원"
 *   17 = "인천지방법원"
 *   18 = "김천지원"
 *   19 = "여주지원"
 *   20 = "의성지원"
 *   21 = "전주지방법원"
 *   22 = "통영지원"
 *   23 = "전체"
 *   24 = "평택지원"
 *   25 = "대구지방법원"
 *   26 = "제주지방법원"
 *   27 = "서울남부지방법원"
 *   28 = "강릉지원"
 *   29 = "춘천지방법원"
 *   30 = "안양지원"
 *   31 = "영동지원"
 *   32 = "영덕지원"
 *   33 = "천안지원"
 *   34 = "목포지원"
 *   35 = "경주지원"
 *   36 = "광주지방법원"
 *   37 = "남양주지원"
 *   38 = "영월지원"
 *   39 = "순천지원"
 *   40 = "충주지원"
 *   41 = "홍성지원"
 *   42 = "창원지방법원"
 *   43 = "청주지방법원"
 *   44 = "서울서부지방법원"
 *   45 = "원주지원"
 *   46 = "의정부지방법원"
 *   47 = "공주지원"
 *   48 = "논산지원"
 *   49 = "포항지원"
 *   50 = "안산지원"
 *   51 = "성남지원"
 *   52 = "거창지원"
 *   53 = "남원지원"
 *   54 = "서울중앙지방법원"
 *   55 = "수원지방법원"
 *   56 = "장흥지원"
 *   57 = "서울북부지방법원"
 *   58 = "부산서부지원"
 *   59 = "해남지원"
 *   60 = "속초지원"
 */
@RequiredArgsConstructor(
  access = AccessLevel.PRIVATE
)
@Slf4j
public class Courts {

    private static final Courts instance = new Courts();

    private static final Set<String> courtClass = new HashSet<>();

    public static Courts getInstance() {
        if (courtClass.isEmpty()) {
            log.error("CourtClass instance is null. initialize CourtClass");
            throw new NullPointerException();
        }

        return instance;
    }

    public static Courts init(CourtAuctionRest courtAuctionRest) {
        fetch(courtAuctionRest);
        save
        return Courts.instance;
    }

    private static void fetch(CourtAuctionRest courtAuctionRest) {
        courtClass.addAll(courtAuctionRest.fetchCourts());
    }
}
