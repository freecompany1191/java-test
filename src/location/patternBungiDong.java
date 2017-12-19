package location;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class patternBungiDong {

    public static void main(String[] args) {
        // TODO Auto-generated method stub


        final Pattern DONG_BUNGI = Pattern.compile("(\\d{1,5}|\\d{1,5}(~|-)\\d{1,5})+(번지|)");


        String addr = "대전광역시 서구 월평1동 성심타운726번지bo1호";


        String str = getMatchOut(DONG_BUNGI, addr);
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

    private static String matchBlank(Pattern p, String target){

        Matcher m = p.matcher(target);
        System.out.println("### matcher = "+m);

        // StringBuffer buffer = new StringBuffer();

        while (m.find()) {
            System.out.println(m.group());
            target = target.replace(m.group(), " ");
            //m.appendReplacement(buffer, m.group());

        }

        //if (m.find()) result=m.group();
        //buffer.toString()

        return target;
    }


    /**
     * 정규식 패턴 매칭(매칭된 패턴 제거)
     * @Method Name : getMatchOut
     * @param p
     * @param target
     * @return
     */
    private static String getMatchOut(Pattern p, String target){

        Matcher m = p.matcher(target);

        System.out.println("# before target : "+target);

        while (m.find()) {
            System.out.println(m.group());
            target = target.replace(m.group(), " ");
        }

        System.out.println("# after target : "+target);

        return target;
    }
}
