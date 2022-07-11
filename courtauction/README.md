ANDAR wish-list 를 제작하다가, 개발자가 전체 제품 리스트 api 를 XHR 에서 없애 버렸습니다. 
api 도 막히게 되었기 때문에, 전체 카테고리 목록 api 를 가져와,
카테고리 페이지를 크롤링을 할 수 밖에 없게 되었어요. 전체 제품 목록 api 가 있는 것을 모를 땐 원래 그렇게 할 생각이었지만요..
지금은 andar 시즌 옷을 모두 구매를 하였기 때문에, 가격을 추적할 흥미가 사라졌어요.

대신 법원 경매 사이트를 크롤하여 원하는 경매정보를 편리하게 찾을 수 있게 하는 어플리케이션을 만들것입니다! 

- https://www.courtauction.go.kr/

### 모든 부동산 정보를 크롤한다.
- POST https://www.courtauction.go.kr/RetrieveRealEstMulDetailList.laf

#### request header
- Host 와 User-Agent 를 넣어줘야 합니다. 그렇지 않으면 400 에러가 납니다. 

#### payload
```title="예시"
bubwLocGubun=1&jiwonNm=%BC%AD%BF%EF%C1%DF%BE%D3%C1%F6%B9%E6%B9%FD%BF%F8&jpDeptCd=000000&daepyoSidoCd=&daepyoSiguCd=&daepyoDongCd=&notifyLoc=on&rd1Cd=&rd2Cd=&realVowel=35207_45207&rd3Rd4Cd=&notifyRealRoad=on&saYear=2022&saSer=&ipchalGbncd=&termStartDt=2022.07.04&termEndDt=2022.07.18&lclsUtilCd=&mclsUtilCd=&sclsUtilCd=&gamEvalAmtGuganMin=&gamEvalAmtGuganMax=&notifyMinMgakPrcMin=&notifyMinMgakPrcMax=&areaGuganMin=&areaGuganMax=&yuchalCntGuganMin=&yuchalCntGuganMax=&notifyMinMgakPrcRateMin=&notifyMinMgakPrcRateMax=&srchJogKindcd=&mvRealGbncd=00031R&srnID=PNO102001&_NAVI_CMD=&_NAVI_SRNID=&_SRCH_SRNID=PNO102001&_CUR_CMD=InitMulSrch.laf&_CUR_SRNID=PNO102001&_NEXT_CMD=RetrieveRealEstMulDetailList.laf&_NEXT_SRNID=PNO102002&_PRE_SRNID=&_LOGOUT_CHK=&_FORM_YN=Y
```

```shell
page: default20 
page: default20
bubwLocGubun: 1
jiwonNm: %BC%AD%BF%EF%C1%DF%BE%D3%C1%F6%B9%E6%B9%FD%BF%F8
jpDeptCd: 000000
daepyoSidoCd: 
daepyoSiguCd: 
daepyoDongCd: 
notifyLoc: on
rd1Cd: 
rd2Cd: 
realVowel: 35207_45207
rd3Rd4Cd: 
notifyRealRoad: on
saYear: 2022
saSer: 
ipchalGbncd: 
termStartDt: 2022.07.04
termEndDt: 2022.07.18
lclsUtilCd: 
mclsUtilCd: 
sclsUtilCd: 
gamEvalAmtGuganMin: 
gamEvalAmtGuganMax: 
notifyMinMgakPrcMin: 
notifyMinMgakPrcMax: 
areaGuganMin: 
areaGuganMax: 
yuchalCntGuganMin: 
yuchalCntGuganMax: 
notifyMinMgakPrcRateMin: 
notifyMinMgakPrcRateMax: 
srchJogKindcd: 
mvRealGbncd: 00031R
srnID: PNO102001
_NAVI_CMD: 
_NAVI_SRNID: 
_SRCH_SRNID: PNO102001
_CUR_CMD: InitMulSrch.laf
_CUR_SRNID: PNO102001
_NEXT_CMD: 
_NEXT_SRNID: PNO102002
_PRE_SRNID: 
_LOGOUT_CHK: 
_FORM_YN: Y
PNIPassMsg: %C1%A4%C3%A5%BF%A1+%C0%C7%C7%D8+%C2%F7%B4%DC%B5%C8+%C7%D8%BF%DCIP+%BB%E7%BF%EB%C0%DA%C0%D4%B4%CF%B4%D9.
pageSpec: default10
pageSpec: default20
targetRow: 41
lafjOrderBy: 
```

#### response element
table .Ltbl_list tbody tr
- td1 사건번호
  - textNode1 : 법원이름
  - textNode2 : (trim) 사건번호
- td2 
  - textNode1 : 물건번호
  - textNode2 : 용도
- td3  
  - a1 : 소재지
  - textNode : 내역
- td4 : 비고
- td5 : 
  - div1 : 감정평가액
  - div2 : 최저매각가격 , (퍼센트)
- td6 
  - div a : 매각 기일
  - div : 유찰 횟수

---

### 부동산 상세 페이지
요청 URL: https://www.courtauction.go.kr/RetrieveRealEstCarHvyMachineMulDetailInfo.laf
```shell
jiwonNm: (값을 디코딩할 수 없음)
saNo: 20210130100657  // 사건번호
maemulSer: 1
mokmulSer: 
_NAVI_CMD: InitMulSrch.laf
_NAVI_SRNID: PNO102001
_SRCH_SRNID: PNO102001
_CUR_CMD: RetrieveRealEstMulDetailList.laf
_CUR_SRNID: PNO102002
_NEXT_CMD: RetrieveRealEstCarHvyMachineMulDetailInfo.laf
_NEXT_SRNID: PNO102015
_PRE_SRNID: 
_LOGOUT_CHK: 
_FORM_YN: Y
_C_page: default20
_C_bubwLocGubun: 1
_C_jiwonNm: (값을 디코딩할 수 없음)
_C_jpDeptCd: 000000
_C_daepyoSidoCd: 
_C_daepyoSiguCd: 
_C_daepyoDongCd: 
_C_notifyLoc: on
_C_rd1Cd: 
_C_rd2Cd: 
_C_realVowel: 35207_45207
_C_rd3Rd4Cd: 
_C_notifyRealRoad: on
_C_saYear: 2022
_C_saSer: 
_C_ipchalGbncd: 
_C_termStartDt: 2022.07.04
_C_termEndDt: 2022.07.18
_C_lclsUtilCd: 
_C_mclsUtilCd: 
_C_sclsUtilCd: 
_C_gamEvalAmtGuganMin: 
_C_gamEvalAmtGuganMax: 
_C_notifyMinMgakPrcMin: 
_C_notifyMinMgakPrcMax: 
_C_areaGuganMin: 
_C_areaGuganMax: 
_C_yuchalCntGuganMin: 
_C_yuchalCntGuganMax: 
_C_notifyMinMgakPrcRateMin: 
_C_notifyMinMgakPrcRateMax: 
_C_srchJogKindcd: 
_C_mvRealGbncd: 00031R
_C_srnID: PNO102001
_C_PNIPassMsg: (값을 디코딩할 수 없음)
_C_pageSpec: default10
_C_targetRow: 41
_C_lafjOrderBy: 
```

## 어플리케이션이 제공하고자 하는바

- 자동차 경매의 경우
  - 자동차를 보관하고 있는 동일한 곳에 경매로 올라온 차량 조회
- 테마별 조회
  - 바닷가 근처  <- 먼저

## 어플리케이션 컴포넌트
### 모든 경매 사건 스캔 
