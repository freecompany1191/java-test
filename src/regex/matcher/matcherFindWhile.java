package regex.matcher;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

//비 캡처 그룹 - (? : X)
public class matcherFindWhile {

	//Look Ahead and Look Behind Constructs - (?=X) , (?!X) , (?<=X) , (?<!X)
	public static void main(String[] args) {
		String input =
	      "John Jacob Jingleheimer Schmidt " +
	    	      "His name is my name, too! " +
	    	      "Whenever we go out, " +
	    	      "The people always shout " +
	    	      "There goes Johnnn Jacobbb Jingleheimer Schmidt " ;
	
	    try {
			Pattern pattern = Pattern.compile( "(J\\w+)(?=.+Schmidt )" );
			// Matches all words starting with "J" that 
			// precede "Schmidt " (note the space following the t). 
			// The ".+Schmidt " part of the regular 
			// expression is not consumed.
			
			// "J"로 시작하는 모든 단어와 일치합니다.
			// "Schmidt "앞에옵니다 (t 다음의 공백에주의하십시오).
			// 정규식의 ".+Schmidt "부분
			// 표현식이 사용되지 않습니다.

			Matcher matcher = pattern.matcher( input );
			while ( matcher.find() )                 // Prints 
			{                                        //   "John"
			  System.out.println( matcher.group() ); //   "Jacob"
			}                                        //   "Jingleheimer"
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

}
