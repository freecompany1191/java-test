package regex.basic;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class andOperators {

	/*
	 * "&&" is the AND operator. 
	 * It allows the definition of two conditions for a pattern element to match.
	 * 
	 * "&&"는 AND 연산자입니다.
	 *  패턴 요소에 대한 두 가지 조건을 정의 할 수 있습니다.
	 */
	public static void main(String[] args) {

		try {
			Pattern pattern = Pattern.compile( "[a-z&&[^aeiou]].{5}" );
			// Matches any six characters where the first character 
			// is a lower case letter that is not a vowel.
			
			// 첫 번째 문자가있는 여섯 개의 문자와 일치합니다.     
			// 는 모음이 아닌 소문자입니다.
			
			String input = "Every lamb counts fish." ;
			Matcher matcher = pattern.matcher( input );
			
			while ( matcher.find() ) 
			{
			    System.out.println( matcher.group() ); // Prints "very l"
			                                           //        "mb cou"
			                                           //        "nts fi"
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

}
