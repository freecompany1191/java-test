package regex.matcher;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

//
public class matcherBehind2 {

	//Look Ahead and Look Behind Constructs - (?=X) , (?!X) , (?<=X) , (?<!X)
	
	//(?<=X) 패턴을 걸 앞문자앞에 쓰며 선행한다는 조건/ 뒷문자만 Group에 포함됨
	//(?<!X) 패턴을 걸 앞문자앞에 쓰며 선행하지 않는다는 조건/ 뒷문자만 Group에 포함됨
	
	//(?=X) 패턴을 걸 뒷문자앞에 쓰며 뒷문자와 일치한다는 조건/ 앞문자만 group에 포함됨
	//(?!X) 패턴을 걸 뒷문자앞에 쓰며 뒷문자와 일치하지 않는다는 조건/ 앞문자만 group에 포함됨
	public static void main(String[] args) {
		String input =
			      "Tomorrow's special is fried bananas with baked clam." ;

	    try {
			Pattern pattern = Pattern.compile( "(?<=fried )(bananas|clam)" );
			// Matches "bananas" or "clam" if preceded by "fried ". 
			// "fried " is not part of the resulting match, it precedes it.
			
			// "fried"가 앞에 오면 "bananas"또는 "clam"과 일치합니다.     
			// "fried"는 일치하는 결과의 일부가 아니며 앞에 나옵니다.

			Matcher matcher = pattern.matcher( input );

			System.out.println( matcher.find() );       // Prints true.
			System.out.println( matcher.groupCount() ); // Prints 1.
			System.out.println( matcher.group( 1 ) );   // Prints "bananas".
			System.out.println( matcher.group() );      // Prints "bananas".
			System.out.println();

			pattern = Pattern.compile( "(?<!fried )(bananas|clam)" );
			// Matches "bananas" or "clam" if not preceded by "fried ". 
			
			// "fried"앞에 선행하지 않으면 "bananas"또는 "clam"과 일치합니다.

			matcher = pattern.matcher( input );

			System.out.println( matcher.find() );       // Prints true.
			System.out.println( matcher.groupCount() ); // Prints 1.
			System.out.println( matcher.group( 1 ) );   // Prints "clam".
			System.out.println( matcher.group() );      // Prints "clam".
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

}
