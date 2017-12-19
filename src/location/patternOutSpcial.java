package location;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class patternOutSpcial {

    public static void main(String[] args) {

        //Pattern addr1 = Pattern.compile("[^\"'\\{\\}\\[\\]/?;:|\\)\\(*~`!^\\-_+<>@#$%^\\\\=]");

        Pattern addr1 = Pattern.compile("[\"\'{}\\[\\];:|\\(\\).*`!_+<>@#$%^&\\=/]");

        //Pattern addr2 = Pattern.compile("[\\[\\]]");
        //[\"'\\{\\}\\[\\]/?;:|\\)\\(*~`!^\\-_+┼<>@#$%&^\\\\=]"
        Pattern addr = Pattern.compile("\\[.*\\]|\\(.*\\)|\\{.*\\}");

        String str = "서울 관악구 조원동 (구 신림8동) 526-6.202호";
        str = match(addr, str);
        System.out.println(str);

        str = match(addr1, str);
        System.out.println(str);
    }

    private static String match(Pattern p, String target){

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

}
