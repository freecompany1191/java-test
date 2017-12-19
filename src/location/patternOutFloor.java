package location;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import common.ADDRESS_PATTERN;

public class patternOutFloor {

    public static void main(String[] args) throws Exception {

        Pattern FLOOR_OUT =  ADDRESS_PATTERN.DEFAULT.FLOOR_OUT.getPettern();
        //광주 광산구 산정동 1059 중흥 s클래스103동502호
        //서울 은평구 서울시 은평구 진관동 16-29 은평지웰테라스 1509동 403호
        //인천 부평구 삼산동 삼1동 상2동 상3동 453-1 삼산타운7단지715동 1504호

        //가|나|다|라|마|바|사|아|자|차|카|타|파|하
        //(\\d{1,4}|[a-zA-Z]{1}\\d{1,3})+
        //|([a-zA-Z]{1}+\\d{1,3})

        String addr = "서울 송파구 문정2동 639-3 11층agd";
        //addr = "서울 도봉구 창2동 범계동 상도동 ";

        //서울 강남구 논현1동 마일스디오빌 논현동 58-2 1209호
        String str = getMatchRoopOut(FLOOR_OUT, addr);
        System.out.println(str);

    }

    /**
     * 정규식 패턴 매칭(루프돌며 매칭된 패턴 모두 제거)
     * @Method Name : getMatchRoopOut
     * @param p
     * @param target
     * @return
     */
    public static String getMatchRoopOut(Pattern p, String target) throws Exception {

        Matcher m = p.matcher(target);

        while (m.find()) {
            target = m.replaceAll(" ");
        }

        return target;
    }

}
