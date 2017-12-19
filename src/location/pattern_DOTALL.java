package location;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class pattern_DOTALL {

	public static void main(String[] args) {
	    String str1 = "abcd";
	    String str2 = "abMcd";
	    String str3 = "abKMcd";
	    String str4 = "ab\ncd";

	    String regex1 = "b.c";
	    Pattern p1 = Pattern.compile (regex1);

	    String regex2 = "b.c";
	    Pattern p2 = Pattern.compile (regex2, Pattern.DOTALL);

	    System.out.println ( "패턴 :"+ regex1);

	    check (p1, str1);
	    check (p1, str2);
	    check (p1, str3);
	    check (p1, str4);

	    System.out.println ( "\nDOTALL 모드로 변경 \n");
	    System.out.println ( "패턴 :"+ regex2);

	    check (p2, str1);
	    check (p2, str2);
	    check (p2, str3);
	    check (p2, str4);

	}
	
	private static void check (Pattern p, String target) {
	    Matcher m = p.matcher (target);

	    if (m.find ()) {
	      System.out.println ( "O "+ target);
	    } else {
	      System.out.println ( "X "+ target);
	    }
	  }

}
