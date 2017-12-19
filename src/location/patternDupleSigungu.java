package location;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class patternDupleSigungu {

    public static void main(String[] args) {
        // TODO Auto-generated method stub

        String SIDO = "서울|부산|대구|인천|광주|대전|울산|세종|경기|강원|충북|충남|전북|경북|경남|제주";

        String APT_LIST =
                "아파트|APT|스카이뷰|파크|자이|파크|아이파크|편한세상|래미안|푸르지오|프레스티지|뉴스테이|"
                        +"홈|하이츠|s클래스|S클래스|상떼뷰|보람|모아|\\d{1,2}차|타운|연립|빌라|빌|빌리지|맨션|텔|"
                        + "미소가|미래가";

        String DONG_NUM = "\\d{1,5}|\\d{1,5}(,|.)\\d{1,5}";
        String BUNGI_NUM = "\\d{1,5}|\\d{1,5}(~|-)\\d{1,5}";
        String APT_KOR_DONG_STR = "(가|나|다|라|마|바|사|아|자|차|카|타|파|하)";
        String APT_DONG="("+APT_KOR_DONG_STR+"|\\d{1,4}|[a-zA-Z]{1})+동";
        String APT_HO = "(\\d{1,4}|[A-Z]{1}\\d{1,3})호?";

        final Pattern SIGUGUN =  Pattern.compile("([가-힣]+(시|도)|"+SIDO+")\\s[가-힣]+(시|군|구)\\s(([가-힣]{1,5})+("+DONG_NUM+"|)+(읍|면|동|가|리|로|길)\\s)?");

        //final Pattern DUPLE_DONG = Pattern.compile("((?!"+APT_DONG+")([가-힣]{1,5})+("+DONG_NUM+"|)+(?![미소가|미래가])(읍|면|동|가|리))\\s");
        final Pattern DUPLE_DONG = Pattern.compile("\\s((?!"+APT_DONG+")([가-힣]{1,5})+("+DONG_NUM+"|)+(동)(?=\\s))");

        //제외방법 +(?![미소가|미래가])(읍|면|동|가|리)

        String addr = "서울 강동구 성내1동 528-15 우진빌 302호";
        //광주 광산구 산정동 1059 중흥 s클래스103동502호
        //서울 은평구 서울시 은평구 진관동 16-29 은평지웰테라스 1509동 403호
        //인천 부평구 삼산동 삼1동 상2동 상3동 453-1 삼산타운7단지715동 1504호

        String str = dupleMatch(SIGUGUN, addr);
        System.out.println("last : "+str);

        str = dupleMatch(DUPLE_DONG, str);
        System.out.println("last2 : "+str);



    }

    private static String match(Pattern p, String target){

        Matcher m = p.matcher(target);
        System.out.println("### matcher = "+m);

        // StringBuffer buffer = new StringBuffer();

        while (m.find()) {
            System.out.println(m.group());
            target = target.replace(m.group(), m.group()+"  ");
            //m.appendReplacement(buffer, m.group());
        }

        //if (m.find()) result=m.group();
        //buffer.toString()

        return target;
    }

    private static String dupleMatch(Pattern p, String target){

        Matcher m = p.matcher(target);

        int cnt = 0;
        String tmpStr = "";

        while (m.find()) {
            if(cnt == 0){
                tmpStr = m.group();
                target = m.replaceFirst("TEMP_STR");
                System.out.println("tmpStr : "+tmpStr);
            }
            else{
                /*
                if(tmpStr.length() < m.group().length()) { //첫번째 조건값 보다 길이가 길면
                    System.out.println("length Diff : "+(m.group().length() - tmpStr.length()));
                    if(m.group().length() - tmpStr.length() > 1) //길이 차이가 1보다 크면
                        tmpStr = m.group();
                }
                 */
                System.out.println("m.group() : "+m.group());
                target = target.replace(m.group(), "  ");
            }
            cnt++;
        }

        target = target.replaceAll("TEMP_STR", tmpStr);

        return target;
    }

}
