package regex.basic;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

//문자 클래스
public class characterClasses {

	/*
	 * 대괄호 "[]"는 한 문자 만 일치해야하는 문자 집합 (문자 클래스라고도 함)의 설명을 허용합니다.
	 */
	public static void main(String[] args) {
		
		String input = "I like Regular expressions." ;
		
		try {
			Pattern pattern = Pattern.compile( "[Rr]egular" );
			// Matches "Regular" or "regular".
			// "Regular"또는 "regular"와 일치합니다.
			
			Matcher matcher = pattern.matcher( input );
			System.out.println( "[Rr]egular matcher.find() : "+matcher.find() );  // Prints true.
			System.out.println( "[Rr]egular matcher.group() : "+matcher.group() ); // Prints regular.
			System.out.println();
			
			input = "Regular expressions are great." ;
			matcher.reset( input );
			// Since the same Pattern is to be used to match 
			// against a new input, the Matcher need only 
			// be reset using the new input sequence 
			// (a new Matcher need not be obtained.)
			
			// 동일한 패턴을 사용하여 일치시키기 때문에     
			// 새로운 입력에 대해, Matcher는 필요하다.     
			// 새 입력 시퀀스를 사용하여 재설정됩니다.     
			// (새로운 Matcher는 얻을 필요가 없습니다.)
			
			System.out.println( "reset matcher.find() : "+matcher.find() );  // Prints true.
			System.out.println( "reset matcher.group() : "+matcher.group() ); // Prints Regular.
			System.out.println();
			
			/*
			 * To match any single lowercase letter of the english alphabet, it's possible to specify such a pattern as:
			 * " [abcdefghijklmnopqrstuvwxyz]"Fortunately, a few "shortcut" regular expression constructs are available. 
			 * To match a range of characters, the "-" character can be used. So, "[a-z]" describes the same range of characters above.
			 * The regular expression syntax allows two styles to describe the union of two or more character classes. 
			 * "[a-c[f-h]]" and "[a-cf-h]" both describe the character class "[abcfgh]".
			 * Other "shortcut" constructs include these often used predefined character classes3:

			 * 영어 알파벳의 소문자 하나와 일치 시키려면 다음과 같은 패턴을 지정할 수 있습니다. 
			 * "[abcdefghijklmnopqrstuvwxyz]"다행히도 몇 가지 "바로 가기"정규 표현식 구문을 사용할 수 있습니다. 
			 * 문자 범위를 일치 시키려면 "-"문자를 사용할 수 있습니다. 
			 * 따라서 "[a-z]"는 위의 문자와 동일한 범위를 나타냅니다. 
			 * 정규식 구문을 사용하면 두 가지 스타일이 둘 이상의 문자 클래스 조합을 설명 할 수 있습니다. 
			 * "[a-c [f-h]]"와 "[a-cf-h]"는 모두 문자 클래스 "[abcfgh]"를 설명합니다. 
			 * 다른 "바로 가기"구문에는 자주 사용되는 미리 정의 된 문자 클래스 3이 포함됩니다.
			 */
			
			/*
			 * 
			 * .	matches a single character (may or may not match line terminators)
			 * \d	matches a digit: [0-9]
			 * \D	matches a non-digit: [^0-9] *
			 * \s	matches a whitespace character: [ \t\n\x0B\f\r] (see footnote on characters)
			 * \S	matches a non-whitespace character: [^\s] *
			 * \w	matches a word character: [a-zA-Z_0-9]
			 * \W	matches a non-word character: [^\w] *
			 *"^" is the NOT operator and is covered further down on this page.
			 *
			 * .	단일 문자와 일치합니다 ( 행 종결 자 와 일치하거나 일치하지 않을 수 있음 ).
			 *\d	숫자와 일치합니다 : [0-9]
			 *\D	비 숫자와 일치하는 항목 : [^0-9] *
			 *\s	공백 문자와 일치합니다 : [ \t\n\x0B\f\r] ( 문자의 각주 참조 )
			 *\S	비 공백 문자와 일치합니다 : [^ \ s] *
			 *\w	단어와 일치하는 단어 : [a-zA-Z_0-9]
			 *\W	비 단어 문자와 일치합니다 : [^\w] *
			 *"^"는 NOT 연산자이며이 페이지에서 더 아래로 다룹니다 .
			 */
			
			/*
			 * Note that the backslash character must be escaped (quoted) when used in a Java String in order for it to be interpreted as a String literal. 
			 * So, when specifying a predefined character to use, don't forget to escape the backslash with another backslash. 
			 * For example, to match the word eat surrounded by whitespace, the pattern \seat\s must be specified as "\\seat\\s".
			 * 
			 * String 문자열로 해석 되려면 자바 문자열에서 백 슬래시 문자를 이스케이프 (인용 부호)해야합니다. 
			 * 따라서 사용할 미리 정의 된 문자를 지정할 때는 백 슬래시를 다른 백 슬래시로 이스케이프하는 것을 잊지 마십시오. 
			 * 예를 들어, 공백으로 둘러싸인 단어를 일치 시키려면 \ seat \ s 패턴을 "\\ seat \\ s"로 지정해야합니다
			 * 
			 */
			
			 pattern = Pattern.compile( "\\seat\\s" );
		    // Matches "eat" surrounded by whitespace.
			 
			// 공백으로 둘러싸인 "eat"과 일치합니다.
		    
		    input = "When do we eat?" ;
		    matcher = pattern.matcher( input );
		    System.out.println( matcher.find() );  // Prints false.
		    System.out.println();
		    
		    input = "We eat when we're hungry." ;
		    matcher.reset( input );
		    System.out.println( matcher.find() );  // Prints true.
		    System.out.println( matcher.group() ); // Prints " eat ".
		    
		} catch (Exception e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
		}

	}

}
