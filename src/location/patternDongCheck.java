package location;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.springframework.util.StringUtils;

import common.ADDRESS_PATTERN;
import common.AddressUtils;

public class patternDongCheck {

    public static void main(String[] args) throws Exception {
        // TODO Auto-generated method stub

        //검색전 동이 있을때 검색전 동과 검색된 동을 비교하여 앞 문자열 두개가 일치하지 않으면 낮음처리
        Pattern DONG_CHECK =  ADDRESS_PATTERN.CUSTOM.DONG_CHECK.getPettern(); //동만 가지고 오는 패턴 적용
        Pattern NUMBER_OUT =  ADDRESS_PATTERN.CUSTOM.NUMBER_OUT.getPettern(); //숫자만 가지고 오는 패턴 적용
        //광주 광산구 산정동 1059 중흥 s클래스103동502호
        //서울 은평구 서울시 은평구 진관동 16-29 은평지웰테라스 1509동 403호
        //인천 부평구 삼산동 삼1동 상2동 상3동 453-1 삼산타운7단지715동 1504호

        //가|나|다|라|마|바|사|아|자|차|카|타|파|하
        //(\\d{1,4}|[a-zA-Z]{1}\\d{1,3})+
        //|([a-zA-Z]{1}+\\d{1,3})

        String addr = "전북 전주시 완산구 중앙동1가 8-10 전주시완산구고사동 443-2 객사 항아리수제비 2층 a203호";
        //"서울 도봉구 창1동 대우아파트103-1907호";
        String result = "전북 전주시 완산구 중앙동1가 8-10";
        //"서울 강남구 논현1동 마일스디오빌 58-2 1209호";
        //addr = "서울 도봉구 창2동 대우이너너너너너너너너너너스빌리지726번지";

        //서울 강남구 논현1동 마일스디오빌 논현동 58-2 1209호
        String old_dong = getMatch(DONG_CHECK, addr);
        String new_dong = getMatch(DONG_CHECK, "중앙동1가");

        System.out.println("old_dong : "+old_dong);
        System.out.println("new_dong : "+new_dong);


        System.out.println("@@ KAKAO API 정확도 체크 :: 검색전 동 = "+old_dong+", 검색된 동 = "+new_dong);

        //검색전 동과 검색된 동이 모두 있을 경우
        if(!StringUtils.isEmpty(old_dong) && !StringUtils.isEmpty(new_dong)){

            //동에 들어간 숫자때문에 일치한것을 찾기 힘드므로 비교를 위해 숫자는 우선 제거
            old_dong = AddressUtils.getMatchOutNoBlank(NUMBER_OUT, old_dong); //검색전 동에서 숫자제거
            new_dong = AddressUtils.getMatchOutNoBlank(NUMBER_OUT, new_dong); //검색된 동에서 숫자제거
            System.out.println("@@ KAKAO API  정확도 체크(숫자제거) :: 검색전 동 = "+old_dong+", 검색된 동 = "+new_dong);

            //검색전 동이 두글자이면
            if(old_dong.trim().length() == 2 ){

                //검색된 동이 한글자 이상일때
                if(new_dong.trim().length() > 1 ){
                    old_dong = old_dong.trim().substring(0,1); //검색전 동 앞 한글자 추출
                    new_dong = new_dong.trim().substring(0,1); //검색된 동 앞 한글자 추출
                    System.out.println("@@ KAKAO API  정확도 체크(한글자) :: 검색전 동 = "+old_dong+", 검색된 동 = "+new_dong);

                    //검색전 동과 검색된 동이 같지 않으면 정확도 낮음
                    if(!old_dong.equals(new_dong)){
                        System.out.println("@@ KAKAO API  정확도 체크 :: 검색전 동과 검색된 동 불일치 정확도 낮음 ADDRESS = "+addr+""
                                + ", old_dong = "+old_dong+", new_dong = "+new_dong);
                    }
                }
                //검색된 동이 한글자 이하로 정확도 낮음
                else{
                    System.out.println("@@ KAKAO API  정확도 체크 :: 검색된 동 한글자이하 정확도 낮음 ADDRESS = "+addr+""
                            + ", old_dong = "+old_dong+", new_dong = "+new_dong);
                }

            }
            //검색전 동이 두글자보다 크면
            else if( old_dong.trim().length() > 2 ){

                //검색전 동과 검색된 동의 길이가 같을때
                if(old_dong.trim().length() == new_dong.trim().length()){
                    old_dong = old_dong.trim().substring(0,2); //검색전 동 앞 두글자 추출
                    new_dong = new_dong.trim().substring(0,2); //검색된 동 앞 두글자 추출
                    System.out.println("@@ KAKAO API  정확도 체크(두글자) :: 검색전 동 = "+old_dong+", 검색된 동 = "+new_dong);

                    //검색전 동과 검색된 동이 같지 않으면 정확도 낮음
                    if(!old_dong.equals(new_dong)){
                        System.out.println("@@ KAKAO API  정확도 체크 :: 검색전 동과 검색된 동 불일치 정확도 낮음 ADDRESS = "+addr+""
                                + ", old_dong = "+old_dong+", new_dong = "+new_dong);
                    }
                }
                //검색된 동 두글자 이상이고 검색전 동과 검색된 동의 길이가 다를때
                else if(new_dong.trim().length() > 2 && old_dong.trim().length() != new_dong.trim().length()) {
                    old_dong = old_dong.trim().substring(0,1); //검색전 동 앞 한글자 추출
                    new_dong = new_dong.trim().substring(0,1); //검색된 동 앞 한글자 추출
                    System.out.println("@@ KAKAO API  정확도 체크(한글자) :: 검색전 동 = "+old_dong+", 검색된 동 = "+new_dong);

                    //검색전 동과 검색된 동이 같지 않으면 정확도 낮음
                    if(!old_dong.equals(new_dong)){
                        System.out.println("@@ KAKAO API  정확도 체크 :: 검색전 동과 검색된 동 불일치 정확도 낮음 ADDRESS = "+addr+""
                                + ", old_dong = "+old_dong+", new_dong = "+new_dong);
                    }
                }
                //검색된 동이 두글자 미만일때
                else {
                    System.out.println("@@ KAKAO API  정확도 체크 :: 검색된 동 두글자이하 정확도 낮음 ADDRESS = "+addr+""
                            + ", old_dong = "+old_dong+", new_dong = "+new_dong);
                }

            }

        }
        //str = dupleDongMatch(DUPLE_DONG, str);
        //System.out.println(str);

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

        if (m.find()) target=m.group();
        else target = null;

        return target;
    }

    /**
     * 정규식 패턴 매칭(매칭된 패턴 제거)
     * @Method Name : getMatchOut
     * @param p
     * @param target
     * @return
     */
    private static String getMatchOut(Pattern p, String target) throws Exception {

        Matcher m = p.matcher(target);

        target =  m.replaceAll("");

        return target;
    }


}
