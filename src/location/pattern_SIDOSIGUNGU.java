package location;

import java.util.regex.Pattern;

import common.ADDRESS_PATTERN;

public class pattern_SIDOSIGUNGU {

    public static void main(String[] args) throws Exception {
        // TODO Auto-generated method stub
        Pattern SIGUGUN =  ADDRESS_PATTERN.DEFAULT.SIGUGUN.getPettern();
        //광주 광산구 산정동 1059 중흥 s클래스103동502호
        //서울 은평구 서울시 은평구 진관동 16-29 은평지웰테라스 1509동 403호
        //인천 부평구 삼산동 삼1동 상2동 상3동 453-1 삼산타운7단지715동 1504호

        //가|나|다|라|마|바|사|아|자|차|카|타|파|하
        //(\\d{1,4}|[a-zA-Z]{1}\\d{1,3})+
        //|([a-zA-Z]{1}+\\d{1,3})

        String addr = "서울 강남구 역삼2동 740-9번지 토미하우스B02 입구비번 종9863";

        //String str = getMatchAddBlank(SIGUGUN, addr);
        //System.out.println("SIGUGUN : "+str);

        //str = dupleDongMatch(DUPLE_DONG, str);
        //System.out.println(str);

    }

}
