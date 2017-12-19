package location;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import common.ADDRESS_PATTERN;

public class patternDupleDong {

    public static void main(String[] args) throws Exception {

        Pattern DUPLE_DONG =  ADDRESS_PATTERN.DEFAULT.DUPLE_DONG.getPettern();
        //광주 광산구 산정동 1059 중흥 s클래스103동502호
        //서울 은평구 서울시 은평구 진관동 16-29 은평지웰테라스 1509동 403호
        //인천 부평구 삼산동 삼1동 상2동 상3동 453-1 삼산타운7단지715동 1504호

        //가|나|다|라|마|바|사|아|자|차|카|타|파|하
        //(\\d{1,4}|[a-zA-Z]{1}\\d{1,3})+
        //|([a-zA-Z]{1}+\\d{1,3})

        //        String addr = "서울 도봉구 창2동 대우아파트103-1907호";
        String addr = "서울 도봉구 창4동 창동팡파44.24동 1210호";

        //서울 강남구 논현1동 마일스디오빌 논현동 58-2 1209호
        String str = getMatchOnlyRoop(DUPLE_DONG, addr);
        System.out.println(str);

        //str = dupleDongMatch(DUPLE_DONG, str);
        //System.out.println(str);

    }


    /**
     * 정규식 패턴 매칭(매칭된 패턴과 일치한 것만 가져옴 일치하지 않으면 null)
     * @Method Name : getMatchOnly
     * @param p
     * @param target
     * @return
     */
    public static String getMatchOnlyRoop(Pattern p, String target) throws Exception {

        Matcher m = p.matcher(target);

        while (m.find()){
            target=m.group();
            System.out.println(target);
        }

        return target;
    }

    /**
     * 정규식 패턴 매칭(루프돌며 중복동 제거)
     * @Method Name : getMatchdupleOut
     * @param p
     * @param target
     * @return
     */
    private static String getMatchdupleDongOut(Pattern p, String target) throws Exception {

        Matcher m = p.matcher(target);
        String[] dongArr = null;

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

        if(!dongArrStr.equals(tmpStr))
            dongArr = dongArrStr.split("@");

        System.out.println("dongArr.length : "+dongArr.length);
        int i=0;
        for(String dong : dongArr){
            System.out.println("dongArr["+(i++)+"] : "+dong);
        }

        //tmpStr이 있으면 TEMP_STR로 변환시킨 첫번째 동을 다시 원복시킨다
        target = target.replaceAll("TEMP_STR", tmpStr);

        return target;
    }
}
