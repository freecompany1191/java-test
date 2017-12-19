package location;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import common.ADDRESS_PATTERN;

public class patternSigungu {

    public static void main(String[] args) throws Exception {
        // TODO Auto-generated method stub

        Pattern SIGUGUN =  ADDRESS_PATTERN.DEFAULT.SIGUGUN.getPettern();
        String addr = "가가가가가가가가가가가가가가가가가가가시 강동구 성내1동 528-15 우진빌 302호";
        //광주 광산구 산정동 1059 중흥 s클래스103동502호
        //서울 은평구 서울시 은평구 진관동 16-29 은평지웰테라스 1509동 403호
        //인천 부평구 삼산동 삼1동 상2동 상3동 453-1 삼산타운7단지715동 1504호

        String str = getMatch(SIGUGUN, addr);
        System.out.println("last2 : "+str);

    }


    /**
     * 정규식 패턴 매칭(매칭된 패턴과 일치한 것만 가져옴)
     * @Method Name : getMatch
     * @param p
     * @param target
     * @return
     */
    private static String getMatch(Pattern p, String target) throws Exception {

        Matcher m = p.matcher(target);

        if (m.find()){
            System.out.println("m.group() : "+m.group());
            target=m.group();
        }

        return target;
    }
}
