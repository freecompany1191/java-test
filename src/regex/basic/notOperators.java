package regex.basic;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class notOperators {

	/*
	 * "^" is the NOT operator when prefixed inside a character class. 
	 * "[^b]" would match any character other than a "b". 
	 * Note that it does not match the empty string. 
	 * Outside a character class, "^" takes on a different meaning and is covered in a later lesson.
	 * 
	 * "는 문자 클래스 내 접두사가 붙은 NOT 연산자입니다. 
	 * "[^ b]"는 "b"이외의 모든 문자와 일치합니다. 
	 * 빈 문자열과 일치하지 않습니다. 
	 * 문자 클래스 외부의 "^"는 다른 의미를 가지며 이후 단원에서 다룹니다.
	 */
	public static void main(String[] args) {

		try {
			Pattern pattern = Pattern.compile( "[^b]lop" );
			// Matches any four characters, of which the first 
			// cannot be "b" and the last three must be "lop".
			
			// 네 개의 문자 중 첫 번째 문자와 일치합니다.     
			// 는 "b"가 될 수없고 마지막 세 개는 "lop"이어야합니다.
			
			String input = "blop" ;
			Matcher matcher = pattern.matcher( input );
			System.out.println( "blop matcher.find() : "+matcher.find() );  // Prints false.
			
			input = "flop" ;
			matcher.reset( input );
			System.out.println( "flop matcher.find() : "+matcher.find() );  // Prints true.
			System.out.println( "flop matcher.group() : "+matcher.group() ); // Prints flop.
			
			input = "lop" ;
			matcher.reset( input );
			System.out.println( "lop matcher.find() : "+matcher.find() );  // Prints false.
			                                       // The empty String does 
			                                       // not match "^b".
		} catch (Exception e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
		}
	}

}
