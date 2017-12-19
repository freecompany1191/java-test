package regex.patternMode;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/*
(?i)	Pattern.CASE_INSENSITIVE 대소 문자 구별 매칭을 활성화.
(?d)	Pattern.UNIX_LINES	 유닉스 라인 모드를 활성화합니다.
(?m)	Pattern.MULTILINE	 멀티 라인 모드를 활성화합니다.
(?s)	Pattern.DOTALL	         개행코드 까지 포함 "." 
(?u)	Pattern.UNICODE_CASE	 유니 코드를 인식하는 경우 폴딩을 사용합니다.
(?x)	Pattern.COMMENTS	 패턴에서 공백과 주석을 허용합니다.
(?=)    Pattern.CANON_EQ	 정규 등가를 활성화합니다.
*/
public class CASE_INSENSITIVE_DOTALL {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String input =
			      "Green cheese,\n" +
			      "Yellow laces,\n" +
			      "Up and down\n" +
			      "The market places." ;

	    try {
	        //"(?is)"는 Pattern대소 문자 및 "."에 관계없이 일치 하는 것으로 지정
	    	
			Pattern pattern = Pattern.compile( "(?)[a-z]*,.[a-z]*" );
			// Regardless of case, matches consecutive letters 
			// followed by a comma, any character, then more 
			// consecutive letters where the meta character "." 
			// may match line terminators.

			// 대소 문자에 상관없이 연속 문자를 찾습니다.     
			// 뒤에 쉼표, 임의의 문자, 그 다음이옵니다.     
			// 메타 문자 "." 는 개행문자와 일치 할 수 있습니다.   
			
			Matcher matcher = pattern.matcher( input );
			while ( matcher.find() )                 // Prints 
			{                                        //   cheese,
			  System.out.println( matcher.group() ); //   Yellow
			}                                        //   laces,
			                                         //   Up

			System.out.println();
			
			int flags = Pattern.CASE_INSENSITIVE | Pattern.DOTALL ;
			pattern = Pattern.compile( "[a-z]*,.[a-z]*" , flags );
			// Regardless of case, matches consecutive letters 
			// followed by a comma, any character, then more 
			// consecutive letters where the meta character "." 
			// may match line terminators.
			
			// 대소 문자에 상관없이 연속 문자를 찾습니다.     
			// 뒤에 쉼표, 임의의 문자, 그 다음이옵니다.     
			// 메타 문자 "."  는 개행문자와 일치 할 수 있습니다. 

			matcher = pattern.matcher( input );
			while ( matcher.find() )                 // Prints 
			{                                        //   cheese,
			  System.out.println( matcher.group() ); //   Yellow
			}                                        //   laces,
			                                         //   Up
			System.out.println();
			
			input =
		      "HARK! HARK! The dogs do bark, " +
		      "The beggars are coming to town. " +
		      "Some in rags, " +
		      "And some in tags, " +
		      "And one in a velvet gown!" ;

			//"(? flags : X)"입니다. 여기서 "X"는 플래그의 영향을받는 정규식입니다. 이렇게하면 닫는 괄호 안에 플래그의 범위가 제한됩니다.
		    pattern = Pattern.compile( "(?-i:[A-Z])[A-Z]*" , Pattern.CASE_INSENSITIVE ); //대소문자 구별하기
		    //첫문자가 대문자인 모든 단어
		    // Matches any word, regardless of case except 
		    // the first letter which must be capitalized.
		    
		    // 예외를 막론하고 모든 단어를 찾습니다.     
		    // 대문자로 시작해야하는 첫 글자.

		    matcher = pattern.matcher( input );        // Prints 
		    while ( matcher.find() )                   //   HARK
		    {                                          //   HARK
		        System.out.println( matcher.group() ); //   The
		    }                                          //   The
		                                               //   Some
		                                               //   And
		                                               //   And
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

}
