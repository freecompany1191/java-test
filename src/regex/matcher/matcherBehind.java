package regex.matcher;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

//
public class matcherBehind {

	//앞서보고를 구축 뒤에 봐 - (? = X), (<= X?), (X?!) (<X?!)
	//Look Ahead and Look Behind Constructs - (?=X) , (?!X) , (?<=X) , (?<!X)
	public static void main(String[] args) {
		String input =
	      "Today's specials are apple chocolate pie and cherry banana pie." ;

		//아파트에 번지 붙은거나 동에 번지 붙은거 응용
	    try {
			Pattern pattern = Pattern.compile( "(apple|cherry)(?= chocolate)" );
			// Matches "apple" or "cherry" where the following pattern 
			// matches " chocolate".  " chocolate" is not a part of the 
			// resulting match, it follows it.
			
			// 다음 패턴이있는 "apple"또는 "cherry"과 일치합니다.     
			// "초콜릿"과 일치합니다. "초콜릿"은     
			// 결과가 일치하면 그 뒤를 잇는다.

			Matcher matcher = pattern.matcher( input );

			System.out.println( matcher.find() );       // Prints true.
			System.out.println( matcher.groupCount() ); // Prints 1.
			System.out.println( matcher.group( 1 ) );   // Prints "apple".
			System.out.println( matcher.group() );      // Prints "apple".
			System.out.println();

			pattern = Pattern.compile( "(apple|cherry)(?! chocolate)" );
			// Matches "apple" or "cherry" where the following pattern 
			// does not match " chocolate".
			
			// 다음 패턴이있는 "apple"또는 "cherry"과 일치합니다.     
			// "초콜릿"과 일치하지 않습니다.

			matcher = pattern.matcher( input );

			System.out.println( matcher.find() );       // Prints true.
			System.out.println( matcher.groupCount() ); // Prints 1.
			System.out.println( matcher.group( 1 ) );   // Prints "cherry".
			System.out.println( matcher.group() );      // Prints "cherry".
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

}
