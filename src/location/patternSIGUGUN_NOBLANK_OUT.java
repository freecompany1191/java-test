package location;

import java.util.regex.Pattern;

import common.ADDRESS_PATTERN;
import common.AddressUtils;

public class patternSIGUGUN_NOBLANK_OUT {

    public static void main(String[] args) throws Exception {
        // TODO Auto-generated method stub

        //검색전 동이 있을때 검색전 동과 검색된 동을 비교하여 앞 문자열 두개가 일치하지 않으면 낮음처리
        Pattern SIGUGUN_NOBLANK_OUT =  ADDRESS_PATTERN.DEFAULT.SIGUGUN_NOBLANK_OUT.getPettern(); //동만 가지고 오는 패턴 적용
        //광주 광산구 산정동 1059 중흥 s클래스103동502호
        //서울 은평구 서울시 은평구 진관동 16-29 은평지웰테라스 1509동 403호
        //인천 부평구 삼산동 삼1동 상2동 상3동 453-1 삼산타운7단지715동 1504호

        //가|나|다|라|마|바|사|아|자|차|카|타|파|하
        //(\\d{1,4}|[a-zA-Z]{1}\\d{1,3})+
        //|([a-zA-Z]{1}+\\d{1,3})

        String addr = " 서울시 만안구박달동";
        //"서울 도봉구 창1동 대우아파트103-1907호";
        //String result = "전북 전주시 완산구 중앙동1가 8-10";
        //"서울 강남구 논현1동 마일스디오빌 58-2 1209호";
        //addr = "서울 도봉구 창2동 대우이너너너너너너너너너너스빌리지726번지";

        //서울 강남구 논현1동 마일스디오빌 논현동 58-2 1209호
        String result = AddressUtils.getMatchOut(SIGUGUN_NOBLANK_OUT, addr);

        System.out.println("result : "+result);


    }

}
