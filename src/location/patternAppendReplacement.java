package location;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class patternAppendReplacement {

	public static void main(String args[]) {

        Pattern p = Pattern.compile("(James) (Bond)");

        StringBuffer sb = new StringBuffer();

        String candidateString = "My name is Bond. James Bond.";

        String replacement = "$1 Waldo $2";

        Matcher matcher = p.matcher(candidateString);

        matcher.find();

        matcher.appendReplacement(sb, replacement);

        String msg = sb.toString();

        System.out.println(msg);

    }

}
