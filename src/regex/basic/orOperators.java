package regex.basic;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

//OR 연산자
public class orOperators {

	/*
	 * "|" is the OR operator. When used outside of a character class, it allows the matching of one or the other pattern. 
	 * Inside of a character class, "|" is interpreted as a literal character and serves no meta character function.
	 * 
	 * "|" OR 연산자입니다. 문자 클래스 외부에서 사용될 때 하나 또는 다른 패턴의 일치를 허용합니다. 
	 * 문자 클래스 내부에서 "|" 리터럴 문자로 해석되며 메타 문자 기능을 제공하지 않습니다.
	 * 
	 */
	public static void main(String[] args) {
		
		try {
			Pattern pattern = Pattern.compile( "apple|orange" );
			// Matches "apples" or "oranges".
			
			String input = "I ate my orange." ;
			Matcher matcher = pattern.matcher( input );
			System.out.println( "orange matcher.find() : "+matcher.find() );  // Prints true.
			System.out.println( "orange matcher.group() : "+matcher.group() ); // Prints orange.
			System.out.println();
			
			input = "I ate my apple." ;
			matcher.reset( input );
			System.out.println( "apple matcher.find() : "+matcher.find() );  // Prints true.
			System.out.println( "apple matcher.group() : "+matcher.group() ); // Prints apple.
			System.out.println();
			
			input = "I don't have any more fruit." ;
			matcher.reset( input );
			System.out.println( "matcher.find() : "+matcher.find() );  // Prints false.
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

	}

}
