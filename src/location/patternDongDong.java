package location;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class patternDongDong {

	public static void main(String[] args) {
		String input =
	      "Fee! Fie! Foe! Fum! " +
	      "Fee! Fie! Foe! Fum! I smell the blood of an Englishman. " +
	      "Be he 'live, or be he dead, " +
	      "Fee! Fie! Foe! Fum! I'll grind his bones to make my bread." ;

	    try {
			Pattern pattern = Pattern.compile( "(F[a-z]{2}! ){7}" );
			// Matches four occurrences of a pattern that begins 
			// with "F" followed by two lower case letters, a "!" 
			// and a space.
			
			// 시작하는 패턴의 네 번 일치     
			// "F"뒤에 2 개의 소문자, "!"     
			// 와 공백이 있습니다.

			Matcher matcher = pattern.matcher( input );

			System.out.println( matcher.find() );  // Prints true.
			System.out.println( matcher.group() ); // Prints "Fee! Fie! Foe! Fum! ".
			System.out.println();
			
			
			//동두개 연속 응용
			input =
		      "Humpty Dumpty sat on a wall. " +
		      "Humpty Dumpty had a great fall. " +
		      "All the king's horses and all the king's men " +
		      "Couldn't put Humpty together again! " ;

		    pattern = Pattern.compile( "((H|D)(umpty) ){2}" );
		    // Matches six characters ending in "umpty" and 
		    // beginning with "H" or "D".  Three capturing 
		    // groups are defined and remembered by the Matcher.
		    
		    // "umpty"로 끝나는 6 개의 문자와 일치하고     
		    // "H"또는 "D"로 시작합니다. 3 회 캡처     
		    // 그룹은 Matcher에 의해 정의되고 기억된다.

		    matcher = pattern.matcher( input );

		    System.out.println( matcher.find() );       // Prints true.
		    System.out.println( matcher.groupCount() ); // Prints 3.
		    System.out.println( matcher.group( 1 ) );   // Prints "Dumpty ".
		    System.out.println( matcher.group( 2 ) );   // Prints "D".
		    System.out.println( matcher.group( 3 ) );   // Prints "umpty".
		    System.out.println( matcher.group( 0 ) );   // Prints "Humpty Dumpty ".

		    // If it was expected that matcher.group( 1 ) should contain 
		    // "Humpty", then remember that the group( int ) method 
		    // returns the input subsequence captured by the specified 
		    // group during the previous match operation.  This match 
		    // operation was performed two times - the first time matching 
		    // "Humpty" and the second time matching "Dumpty".
		    
		    // matcher.group (1)에 포함되어야한다고 예상 된 경우     
		    // "Humpty", 그룹 (int) 메소드 기억     
		    // 지정된 객체가 캡처 한 입력 서브 시퀀스를 반환합니다.     
		    // 이전의 매치 조작 중에 그룹화합니다. 이 경기
		    // 작업은 두 번 수행되었습니다. 처음으로 일치하는 시간입니다.     
		    // "Humpty"와 두 번째 시간은 "Dumpty"와 일치합니다.
			
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

	}

}
