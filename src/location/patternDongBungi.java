package location;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import common.ADDRESS_PATTERN;

public class patternDongBungi {

    public static void main(String[] args) {
        // TODO Auto-generated method stub

        Pattern DONG_BUNGI =  ADDRESS_PATTERN.DEFAULT.DONG_BUNGI.getPettern();
        //광주 광산구 산정동 1059 중흥 s클래스103동502호
        //서울 은평구 서울시 은평구 진관동 16-29 은평지웰테라스 1509동 403호
        //인천 부평구 삼산동 삼1동 상2동 상3동 453-1 삼산타운7단지715동 1504호

        //가|나|다|라|마|바|사|아|자|차|카|타|파|하
        //(\\d{1,4}|[a-zA-Z]{1}\\d{1,3})+
        //|([a-zA-Z]{1}+\\d{1,3})

        String addr = "서울 도봉구 창2동 대우아파트103-1907호";
        addr = "서울 도봉구 상도동712-323안녕";

        //서울 강남구 논현1동 마일스디오빌 논현동 58-2 1209호
        String str = getMatchAddBlank(DONG_BUNGI, addr);
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
            System.out.println("m.group() : "+m.group());
            target = m.replaceAll(m.group()+" ");
        }

        return target;
    }

}
