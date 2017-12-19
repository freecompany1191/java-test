package regex.matcher;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class matcherGroups2 {

	//Non-Capturing Groups - (?:X) 단일 속성은 그룹에 포함시키지 않는다
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String input =
	      "Humpty Dumpty sat on a wall. " +
	      "Humpty Dumpty had a great fall. " +
	      "All the king's horses and all the king's men " +
	      "Couldn't put Humpty together again! " ;

	    try {
			Pattern pattern = Pattern.compile( "((?:H|D)(?:umpty) ){2}" );
			// Matches six characters ending in "umpty" and 
			// beginning with "H" or "D".  Three groups 
			// are defined, one is a capturing group that 
			// will be remembered by the Matcher.
			
			// "umpty"로 끝나는 6 개의 문자와 일치하고     
			// "H"또는 "D"로 시작합니다. 세 그룹     
			// 가 정의되면, 하나는     
			// Matcher가 기억할 것입니다.

			Matcher matcher = pattern.matcher( input );

			System.out.println( matcher.find() );       // Prints true.
			System.out.println( matcher.groupCount() ); // Prints 1.
			System.out.println( matcher.group( 1 ) );   // Prints "Dumpty ".
			System.out.println( matcher.group( 0 ) );   // Prints "Humpty Dumpty ".
		} catch (Exception e) {
			// TODO Auto-generated catch block
			System.out.println(e.getMessage());
		}
	}

}
