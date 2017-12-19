package location;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class patternDongDong3 {

    public static void main(String[] args) {
        // TODO Auto-generated method stub

        String SIDO = "서울|부산|대구|인천|광주|대전|울산|세종|경기|강원|충북|충남|전북|경북|경남|제주";

        String APT_LIST =
                "아파트|APT|스카이뷰|파크|자이|파크|아이파크|편한세상|래미안|푸르지오|프레스티지|뉴스테이|로프트|단지|차|"
                        +"홈|하이츠|s클래스|S클래스|상떼뷰|보람|모아|타운|연립|빌라|빌|빌리지|맨션|텔|"
                        + "미소가|미래가";

        String DONG_NUM = "\\d{1,5}|\\d{1,5}(,|.)\\d{1,5}";
        String BUNGI_NUM = "\\d{1,5}|\\d{1,5}(~|-)\\d{1,5}";
        String APT_KOR_DONG_STR = "(가|나|다|라|마|바|사|아|자|차|카|타|파|하)";
        String APT_DONG="("+APT_KOR_DONG_STR+"|\\d{1,4}|[a-zA-Z]{1})+동";
        String APT_HO = "(\\d{1,4}|[A-Z]{1}\\d{1,3})호?";

        final Pattern SIGUGUN =  Pattern.compile("(([가-힣]+(시|도)|bc|서울|부산|대구|인천|광주|대전|울산|세종|경기|강원|충북|충남|전북|경북|경남|제주)\\s[가-힣]+(시|군|구).*)");

        final Pattern DUPLE_DONG = Pattern.compile("\\s((?!"+APT_DONG+")([가-힣]{1,5})+("+DONG_NUM+"|)+동+(?![가-힣))");
        //가|나|다|라|마|바|사|아|자|차|카|타|파|하

        String addr = "서울 강동구 성내1동 528-15 우진빌 302호";

        //서울 강남구 논현1동 마일스디오빌 논현동 58-2 1209호
        String str = dupleDongMatch(DUPLE_DONG, addr);
        System.out.println(str);

        //str = dupleDongMatch(DUPLE_DONG, str);
        //System.out.println(str);

    }

    private static String match(Pattern p, String target){

        Matcher m;

        //중복동 제거 패턴 적용
        int i = 0;
        int cnt = 0;
        String chkStr = target;

        //돌면서 동 갯수 체크하기 위한 루프문
        do{
            m = p.matcher(chkStr);
            if(m.find()){
                System.out.println("## m.group() : "+m.group());
                chkStr = chkStr.replace(m.group(), "");
                if(i!=0) cnt++; //첫번째 동은 갯수에서 제외 두번째 동부터 cnt 증가
            }
            i++;

        } while(m.find());

        System.out.println("## cnt : "+cnt);

        //cnt 가 1이면 동이 2개이므로 cnt가 1개 이상일 때
        if(cnt >= 1){

            i = 0;
            int cnt2 = 0; //
            String tempStr = target; //임시 주소 저장
            String[] temp =new String[cnt]; //제거용 배열 생성 및 동 갯수만큼 배열크기 지정

            do{

                m = p.matcher(tempStr);
                if(m.find()){
                    //돌면서 동이 발견되면 제거
                    tempStr = tempStr.replace(m.group(), ""); //
                    if(i!=0){
                        //첫번째 동이 아니면 제거용 배열에 저장
                        temp[cnt2] = m.group();
                        cnt2++; //배열 카운트 증가
                    }
                }
                i++;

            } while(m.find());

            //최종 제거용 배열 크기 만큼 돌림
            for(int j = 0; j<temp.length;j++){
                //최종주소에서 제거용 배열에 들어있는 동을 모두 제거
                target = target.replaceAll(temp[j], "");
            }

        }
        return chkStr;
    }

    private static String dupleDongMatch(Pattern p, String target){

        Matcher m = p.matcher(target);

        int cnt = 0;
        String tmpStr = "";

        while (m.find()) {
            System.out.println("### cnt : "+cnt);
            System.out.println(m.group());
            if(cnt == 0){
                tmpStr = m.group();
                System.out.println("tmpStr : "+tmpStr);
                target = m.replaceFirst("TEMP_STR");
            }
            else{
                target = target.replace(m.group(), "");
            }
            cnt++;
        }

        target = target.replaceAll("TEMP_STR", tmpStr);

        return target;
    }





}
