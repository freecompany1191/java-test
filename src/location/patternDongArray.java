package location;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class patternDongArray {

    public static String[] dongArr;

    public static void main(String[] args) {
        // TODO Auto-generated method stub

        String SIDO = "서울|부산|대구|인천|광주|대전|울산|세종|경기|강원|충북|충남|전북|경북|경남|제주";

        String APT_LIST =
                "아파트|APT|스카이뷰|파크|자이|파크|아이파크|편한세상|래미안|푸르지오|프레스티지|뉴스테이|"
                        +"홈|하이츠|s클래스|S클래스|상떼뷰|보람|모아|\\d{1,2}차|타운|연립|빌라|빌|빌리지|맨션|텔";

        String DONG_NUM = "\\d{1,5}|\\d{1,5}(,|.)\\d{1,5}";
        String BUNGI_NUM = "\\d{1,5}|\\d{1,5}(~|-)\\d{1,5}";
        String APT_KOR_DONG_STR = "(가|나|다|라|마|바|사|아|자|차|카|타|파|하)";
        String APT_DONG="("+APT_KOR_DONG_STR+"|\\d{1,4}|[a-zA-Z]{1})+동";
        String APT_HO = "(\\d{1,4}|[A-Z]{1}\\d{1,3})호?";

        final Pattern SIGUGUN =  Pattern.compile("([가-힣]+(시|도)|"+SIDO+")\\s[가-힣]+(시|군|구)\\s(([가-힣]{1,5})+("+DONG_NUM+"|)+(읍|면|동|가|리|로|길)\\s)?");

        final Pattern DUPLE_DONG = Pattern.compile("((?!"+APT_DONG+")([가-힣]{1,5})+("+DONG_NUM+"|)+(읍|면|동|가|리))\\s");

        String addr = "서울 동대문구 휘경2동 417-3 형인허브빌1차101동1002호";
        //광주 광산구 산정동 1059 중흥 s클래스103동502호
        //서울 은평구 서울시 은평구 진관동 16-29 은평지웰테라스 1509동 403호

        addr = dupleMatch(DUPLE_DONG, addr);
        System.out.println("last : "+addr);

        if(dongArr != null){
            for(String dong : dongArr){
                addr = dongRoop(DUPLE_DONG, addr, dong);
                System.out.println("dong : "+dong+" | addr : "+addr);
            }
        }
    }

    /**
     * 정규식 패턴 매칭(루프돌며 중복동 제거)
     * @Method Name : getMatchdupleOut
     * @param p
     * @param target
     * @return
     */
    private static String dupleMatch(Pattern p, String target){

        Matcher m = p.matcher(target);

        int cnt = 0;
        String tmpStr = "";
        String dongArrStr = "";

        while (m.find()) {
            if(cnt == 0){
                //첫번째 동을 tmpStr에 담는다
                tmpStr = m.group();
                target = m.replaceFirst("TEMP_STR");
                dongArrStr=tmpStr;
            }
            else{
                //첫번째 동과 같으면 제거
                if(m.group().equals(tmpStr))
                    target = target.replace(m.group(), "");
                else{//다르면 | 구분자로 문자열 담는다
                    dongArrStr=String.join("@",dongArrStr,m.group());
                    target = target.replaceAll(m.group(), "");
                }
            }
            cnt++;
        }

        System.out.println("## cnt : "+cnt);
        System.out.println("## tmpStr : "+tmpStr);
        System.out.println("## dongArrStr : "+dongArrStr);

        if(!dongArrStr.equals(tmpStr))
            dongArr = dongArrStr.split("@");

        System.out.println("## dongArr : "+dongArr);
        if(dongArr != null){
            System.out.println(dongArr.length);
            System.out.println(dongArr[0]);
        }

        //tmpStr이 있으면 TEMP_STR로 변환시킨 첫번째 동을 다시 원복시킨다
        target = target.replaceAll("TEMP_STR", tmpStr);

        return target;
    }

    /**
     * 정규식 패턴 매칭(루프돌며 중복동 제거)
     * @Method Name : getMatchdupleOut
     * @param p
     * @param target
     * @return
     */
    private static String dongRoop(Pattern p, String target, String dong){

        Matcher m = p.matcher(target);

        if (m.find()) target = target.replaceAll(m.group(), dong);

        return target;
    }

}
