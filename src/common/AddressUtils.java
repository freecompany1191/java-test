package common;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.util.StringUtils;

/**
   @FileName  : AddressUtils.java
   @Description : 주소 유틸
   @author      : KMS
   @since       : 2017. 11. 16.
   @version     : 1.0

   @개정이력

   수정일          수정자         수정내용
   -----------     ---------      -------------------------------
   2017. 11. 16.    KMS            최초생성

 */
public class AddressUtils {
    private final static Logger log = LoggerFactory.getLogger(AddressUtils.class);

    /**
     * 기본 정규식 패턴 매칭
     * @Method Name : getMatch
     * @param p
     * @param target
     * @return
     */
    public static String getMatchDefault(String target) throws Exception {

        //STEP1 - [문자] or (문자) or {문자} 제거
        target = getMatchRoopOut(ADDRESS_PATTERN.DEFAULT.BRACKET_STR.getPettern(), target);
        log.info("@@ 주소 기본패턴 STEP1 적용 : "+ target);

        //STEP2 - 특수문자 제거
        target = getMatchRoopOut(ADDRESS_PATTERN.DEFAULT.SPECIAL_STR.getPettern(), target);
        log.info("@@ 주소 기본패턴 STEP2 적용 : "+ target);

        //STEP3 - 시군구 패턴 적용
        target = getMatch(ADDRESS_PATTERN.DEFAULT.SIGUGUN.getPettern(), target);
        log.info("@@ 주소 기본패턴 STEP3 적용 : "+ target);

        //STEP4 - 중복 시도 시군구 읍면동가리로길 제거
        target = getMatchdupleOut(ADDRESS_PATTERN.DEFAULT.DUPLE_SIGUGUN.getPettern(), target);
        log.info("@@ 주소 기본패턴 STEP4 적용 : "+ target);

        //STEP5 - 붙어있는 시도 시구군 동 제거 제거
        target = getMatchOut(ADDRESS_PATTERN.DEFAULT.SIGUGUN_NOBLANK_OUT.getPettern(), target);
        log.info("@@ 주소 기본패턴 STEP5 적용 : "+ target);

        //STEP6 - 아파트와 동또는 번지 분리 패턴 적용
        target = getMatchAddBlank(ADDRESS_PATTERN.DEFAULT.APT_BLANK.getPettern(), target);
        log.info("@@ 주소 기본패턴 STEP6 적용 : "+ target);

        //STEP7 - 아파트동과 호 분리
        target = getMatchAddBlank(ADDRESS_PATTERN.DEFAULT.APT_DONG_BLANK.getPettern(), target);
        log.info("@@ 주소 기본패턴 STEP7 적용 : "+ target);

        //STEP8 - 동번지일 경우 띄어쓰기 해주는 패턴 적용
        target = getMatchAddBlank(ADDRESS_PATTERN.DEFAULT.DONG_BUNGI.getPettern(), target);
        log.info("@@ 주소 기본패턴 STEP8 적용 : "+ target);

        //STEP9 - 중복동 제거
        target = getMatchdupleDongOut(ADDRESS_PATTERN.DEFAULT.DUPLE_DONG.getPettern(), target);
        log.info("@@ 주소 기본패턴 STEP9 적용 : "+ target);

        //STEP10 - 번지에 문자가 붙어있을 경우 띄어쓰기 해주는 패턴 적용
        target = getMatchAddBlank(ADDRESS_PATTERN.DEFAULT.BUNGI_BLANK.getPettern(), target);
        log.info("@@ 주소 기본패턴 STEP10 적용 : "+ target);

        //STEP11 - 번지에 문자가 붙어있을 경우 띄어쓰기 해주는 패턴2 적용
        target = getMatchAddBlank(ADDRESS_PATTERN.DEFAULT.BUNGI_BLANK2.getPettern(), target);
        log.info("@@ 주소 기본패턴 STEP11 적용 : "+ target);

        //STEP12 - 층 호 제거 :: ex)주소에 9999층 9999호 제거
        target = getMatchRoopOut(ADDRESS_PATTERN.DEFAULT.FLOOR_OUT.getPettern(), target);
        log.info("@@ 주소 기본패턴 STEP12 적용 : "+ target);

        //STEP13 - 블랭크 제거
        target = getMatchOutBlank(ADDRESS_PATTERN.DEFAULT.BLANK_OUT.getPettern(), target);
        log.info("@@ 주소 기본패턴 STEP13 적용 : "+ target);

        return target;
    }

    /**
     * 정규식 패턴 매칭(매칭된 패턴과 일치할때는 일치한것 만 아니면 그대로)
     * @Method Name : getMatch
     * @param p
     * @param target
     * @return
     */
    public static String getMatch(Pattern p, String target) throws Exception {

        Matcher m = p.matcher(target);

        if (m.find()) target=m.group();

        return target;
    }

    /**
     * 정규식 패턴 매칭(매칭된 패턴과 일치한 것만 가져옴 일치하지 않으면 null)
     * @Method Name : getMatch
     * @param p
     * @param target
     * @return
     */
    public static String getMatchOnly(Pattern p, String target) throws Exception {

        Matcher m = p.matcher(target);

        if (m.find()) target=m.group();
        else target = null;

        return target;
    }

    /**
     * 정규식 패턴 매칭(매칭된 패턴 제거)(공백추가)
     * @Method Name : getMatchOut
     * @param p
     * @param target
     * @return
     */
    public static String getMatchOut(Pattern p, String target) throws Exception {

        Matcher m = p.matcher(target);

        if(m.find())
            System.out.println("m.group : "+m.group());
        target =  m.replaceAll(" ");

        return target;
    }

    /**
     * 정규식 패턴 매칭(매칭된 패턴 제거)(공백제거)
     * @Method Name : getMatchOutNoBlank
     * @param p
     * @param target
     * @return
     */
    public static String getMatchOutNoBlank(Pattern p, String target) throws Exception {

        Matcher m = p.matcher(target);

        target =  m.replaceAll("");

        return target;
    }

    /**
     * 정규식 패턴 매칭(매칭된 패턴에 블랭크 추가)
     * @Method Name : getMatchAddBlank
     * @param p
     * @param target
     * @return
     */
    public static String getMatchAddBlank(Pattern p, String target) throws Exception {

        Matcher m = p.matcher(target);

        while (m.find()) {
            target = m.replaceAll(m.group()+" ");
        }

        return target;
    }

    /**
     * 정규식 패턴 매칭(매칭된 패턴에 블랭크 제거)
     * @Method Name : getMatchOutBlank
     * @param p
     * @param target
     * @return
     */
    public static String getMatchOutBlank(Pattern p, String target) throws Exception {

        Matcher m = p.matcher(target);

        while (m.find()) {
            target = m.replaceAll(" ");
        }

        return target;
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

    /**
     * 정규식 패턴 매칭(루프돌며 중복동 제거)
     * @Method Name : getMatchdupleOut
     * @param p
     * @param target
     * @return
     */
    public static String getMatchdupleDongOut(Pattern p, String target) throws Exception {

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

        if(!dongArrStr.equals(tmpStr))
            //공유 변수에 담기
            ShareVal.dongArr = dongArrStr.split("@");

        //tmpStr이 있으면 TEMP_STR로 변환시킨 첫번째 동을 다시 원복시킨다
        target = target.replaceAll("TEMP_STR", tmpStr);

        return target;
    }

    /**
     * 정규식 패턴 매칭(루프돌며 배열에 저장된 동으로 주소를 변환)
     * @Method Name : getMatchDongRoop
     * @param p
     * @param target
     * @param netxDong
     * @return
     */
    public static String getMatchDongRoop(String target, String netxDong) throws Exception {

        Matcher m = ADDRESS_PATTERN.DEFAULT.DUPLE_DONG.getPettern().matcher(target);

        if (m.find()) target = target.replaceAll(m.group(), netxDong);

        return target;
    }

    /**
     * 정규식 패턴 매칭(루프돌며 중복 패턴 제거)
     * @Method Name : getMatchdupleOut
     * @param p
     * @param target
     * @return
     */
    public static String getMatchdupleOut(Pattern p, String target) throws Exception {

        Matcher m = p.matcher(target);

        int cnt = 0;
        String tmpStr = "";

        while (m.find()) {
            if(cnt == 0){
                tmpStr = m.group();
                target = m.replaceFirst("TEMP_STR");
            }
            else{
                if(tmpStr.length() < m.group().length()) { //첫번째 조건값 보다 길이가 길면
                    log.debug("length Diff : "+(m.group().length() - tmpStr.length()));
                    if(m.group().length() - tmpStr.length() > 1) //길이 차이가 1보다 크면
                        tmpStr = m.group();
                }
                target = target.replace(m.group(), "");
            }
            cnt++;
        }

        if(!StringUtils.isEmpty(tmpStr))
            target = target.replaceAll("TEMP_STR", tmpStr);

        return target;
    }

    /**
     * 정규식 패턴 매칭(매칭되는 패턴에 의해 정확도 확인)
     * @Method Name : getMatchXyAccType
     * @param p
     * @param target
     * @return
     */
    public static boolean getMatchXyAccType(Pattern p, String target) throws Exception {
        boolean result = false;
        Matcher m = p.matcher(target);

        result = m.matches();

        //log.debug("## getMatchXyAccType target : "+target+" | result : "+result);
        return result;
    }

    /**
     * 뒤에서부터 공백을 기준으로 한블럭씩 잘라냄
     * @Method Name : nextAddr
     * @param address
     * @return
     */
    public static String nextAddr(String address) throws Exception {
        log.debug("# Address address.length() : "+address.length());

        //검색할 주소가 3보다 작으면 null
        if (address.length() < 3)
            return null;

        String[] temp = address.split(" ");

        /*
        for (int i = 0; i < temp.length ; i++) {
            log.debug("# temp["+i+"] = "+temp[i]);
        }

        log.debug("# temp splite length() : "+temp.length);
         */

        if (temp == null || temp.length <= 1) {
            return null;
        }

        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < temp.length - 1; i++) {
            stringBuilder.append(temp[i]);
            stringBuilder.append(" ");
        }

        return stringBuilder.toString().trim();
    }

    /**
     * 뒤에서부터 공백을 기준으로 한블럭씩 잘라냄 길이 설정가능
     * @Method Name : nextAddr
     * @param address
     * @return
     */
    public static String nextAddr(String address, int length) throws Exception {
        log.debug("# Keyword address.length() : "+address.length());

        if (address.length() < length)
            return null;

        String[] temp = address.split(" ");

        /*
        for (int i = 0; i < temp.length ; i++) {
            log.debug("# temp["+i+"] = "+temp[i]);
        }

        log.debug("# temp splite length() : "+temp.length);
         */

        if (temp == null || temp.length <= 1) {
            return null;
        }

        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < temp.length - 1; i++) {
            stringBuilder.append(temp[i]);
            stringBuilder.append(" ");
        }

        return stringBuilder.toString().trim();
    }

    /**
     * 앞에서부터 공백을 기준으로 한블럭씩 잘라냄
     * @Method Name : beforeAddr
     * @param address
     * @return
     */
    public static String beforeAddr(String address) throws Exception {
        log.debug("# Address address.length() : "+address.length());

        //검색할 주소가 3보다 작으면 null
        if (address.length() < 3)
            return null;

        String[] temp = address.split(" ");

        /*
        for (int i = 0; i < temp.length ; i++) {
            log.debug("# temp["+i+"] = "+temp[i]);
        }

        log.debug("# temp splite length() : "+temp.length);
         */

        if (temp == null || temp.length <= 2) {
            return null;
        }

        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 1; i < temp.length; i++) {
            stringBuilder.append(temp[i]);
            stringBuilder.append(" ");
        }

        return stringBuilder.toString().trim();
    }

    /**
     * 앞에서부터 공백을 기준으로 한블럭씩 잘라냄 길이 설정가능
     * @Method Name : beforeAddr
     * @param address
     * @return
     */
    public static String beforeAddr(String address, int length) throws Exception {
        log.debug("# Keyword address.length() : "+address.length());

        if (address.length() < length)
            return null;

        String[] temp = address.split(" ");

        /*
        for (int i = 0; i < temp.length ; i++) {
            log.debug("# temp["+i+"] = "+temp[i]);
        }

        log.debug("# temp splite length() : "+temp.length);
         */

        if (temp == null || temp.length <= 2) {
            return null;
        }

        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 1; i < temp.length; i++) {
            stringBuilder.append(temp[i]);
            stringBuilder.append(" ");
        }

        return stringBuilder.toString().trim();
    }

}