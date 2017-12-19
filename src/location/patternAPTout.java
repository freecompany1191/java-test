package location;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class patternAPTout {

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
        
        
        final Pattern APT_DONG_BLANK = Pattern.compile("("+APT_DONG+")+(?=((\\d{1,4}|[A-Z]{1}\\d{1,3})호))");
        //가|나|다|라|마|바|사|아|자|차|카|타|파|하
        //(\\d{1,4}|[a-zA-Z]{1}\\d{1,3})+
        //|([a-zA-Z]{1}+\\d{1,3})

        String addr = "인천 부평구 부평동 518-7 스위트홈 2동11056호 ";

        //서울 강남구 논현1동 마일스디오빌 논현동 58-2 1209호
        String str = getMatchAddBlank(APT_DONG_BLANK, addr);
        System.out.println(str);

        //str = dupleDongMatch(DUPLE_DONG, str);
        //System.out.println(str);

    }

    /**
     * 정규식 패턴 매칭(매칭된 패턴에 블랭크 추가)
     * @Method Name : getMatchAddBlank
     * @param p
     * @param target
     * @return
     */
    private static String getMatchAddBlank(Pattern p, String target){

        Matcher m = p.matcher(target);

        while (m.find()) {
            target = m.replaceAll(m.group()+" ");
        }

        return target;
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
