package location;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import common.ADDRESS_PATTERN;

public class patternBungiBlank {

    public static void main(String[] args) throws Exception {
        // TODO Auto-generated method stub
        Pattern BUNGI_BLANK =  ADDRESS_PATTERN.DEFAULT.BUNGI_BLANK.getPettern();
        Pattern BUNGI_BLANK2 =  ADDRESS_PATTERN.DEFAULT.BUNGI_BLANK2.getPettern();
        //광주 광산구 산정동 1059 중흥 s클래스103동502호
        //서울 은평구 서울시 은평구 진관동 16-29 은평지웰테라스 1509동 403호
        //인천 부평구 삼산동 삼1동 상2동 상3동 453-1 삼산타운7단지715동 1504호

        //가|나|다|라|마|바|사|아|자|차|카|타|파|하
        //(\\d{1,4}|[a-zA-Z]{1}\\d{1,3})+
        //|([a-zA-Z]{1}+\\d{1,3})

        String addr = "서울 강남구 역삼2동 740-9번지 토미하우스B02 입구비번 종9863";

        String str = getMatchAddBlank(BUNGI_BLANK, addr);
        System.out.println("BUNGI_BLANK : "+str);
        str = getMatchAddBlank(BUNGI_BLANK2, addr);
        System.out.println("BUNGI_BLANK2 : "+str);

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
    private static String getMatchAddBlank(Pattern p, String target) throws Exception {

        Matcher m = p.matcher(target);

        while (m.find()) {
            target = m.replaceAll(m.group()+" ");
        }

        return target;
    }

}
