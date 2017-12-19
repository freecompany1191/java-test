package location;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class patternDongDong2 {

    public static void main(String[] args) {
        // TODO Auto-generated method stub

        final Pattern SIGUGUN =  Pattern.compile("(([가-힣]+(시|도)|bc|서울|부산|대구|인천|광주|대전|울산|세종|경기|강원|충북|충남|전북|경북|경남|제주)\\s[가-힣]+(시|군|구).*)");

        //final Pattern DUPLE_DONG = Pattern.compile("([가-힣]{1,5})+(\\d{1,5}|\\d{1,5}(,|.)\\d{1,5}|)+(읍|면|동|가|리)\\s", Pattern.DOTALL);

        final Pattern DONG_BUNGI = Pattern.compile("([가-힣]{1,5})+(\\d{1,5}|\\d{1,5}(,|.)\\d{1,5}|)+(읍|면|동|가|리)+(?=\\d{1,5}(~|-)\\d{1,5})", Pattern.DOTALL);

        final Pattern DUPLE_DONG = Pattern.compile("([가-힣]{1,5})+(\\d{1,5}|\\d{1,5}(,|.)\\d{1,5}|)+(읍|면|동|가|리)\\s");

        //final Pattern BUNGI = Pattern.compile("\\d{1,5}(~|-)\\d{1,5}");

        String addr = "서울 강서구 등촌2동 중계2.3동 목화 아파트 화곡동 상계2동 상계3.2동 까치2,3동 중계동 407동 610호 영동아파트";
        addr = "서울 강남구 논현동 마일스디오빌 논현동 58-2 1209호";


        //String result = "중계2.3동 목화 아파트 중계동 407동 610호";
        //String str = match(DONG_BUNGI, result);
        //System.out.println(str);

        String str = dupleDongMatch(DUPLE_DONG, addr);
        System.out.println(str);

    }

    private static String match(Pattern p, String target){

        Matcher m = p.matcher(target);
        System.out.println("### matcher = "+m);

        // StringBuffer buffer = new StringBuffer();

        while (m.find()) {
            System.out.println(m.group());
            target = target.replace(m.group(), m.group()+" ");
            //m.appendReplacement(buffer, m.group());
        }

        //if (m.find()) result=m.group();
        //buffer.toString()

        return target;
    }

    private static String dupleDongMatch(Pattern p, String target){

        Matcher m = p.matcher(target);

        int cnt = 0;
        String tmpStr = "";

        while (m.find()) {
            System.out.println("### cnt : "+cnt);
            System.out.println(m.group());
            if(cnt == 0){
                tmpStr = m.group();
                target = m.replaceFirst("TEMP_STR");
            }
            else{
                target = target.replace(m.group(), "");
            }
            cnt++;
        }

        target = target.replaceAll("TEMP_STR", tmpStr);

        return target;
    }

}
