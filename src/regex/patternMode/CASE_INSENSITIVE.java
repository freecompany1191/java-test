package regex.patternMode;

import java.util.regex.Matcher;
import java.util.regex.Pattern;


/**
   @FileName  : CASE_INSENSITIVE.java
   @Description : 대소문자 구분 안함 모드
   @author      : KMS
   @since       : 2017. 8. 30.
   @version     : 1.0
  
   @개정이력
   
   수정일           수정자         수정내용
   -----------      ---------      -------------------------------
   2017. 8. 30.     KMS            최초생성
 
 */

/*
(?i)	Pattern.CASE_INSENSITIVE 대소 문자 구별안함 매칭을 활성화.
(?d)	Pattern.UNIX_LINES	 유닉스 라인 모드를 활성화합니다.
(?m)	Pattern.MULTILINE	 멀티 라인 모드를 활성화합니다.
(?s)	Pattern.DOTALL	         개행코드 까지 포함 "." 
(?u)	Pattern.UNICODE_CASE	 유니 코드를 인식하는 경우 폴딩을 사용합니다.
(?x)	Pattern.COMMENTS	 패턴에서 공백과 주석을 허용합니다.
(?=)    Pattern.CANON_EQ	 정규 등가를 활성화합니다.
*/
public class CASE_INSENSITIVE {

	public static void main(String[] args) {
		String input =
			      "Hey, diddle, diddle, " +
			      "The cat and the fiddle, " +
			      "The cow jumped over the moon. " +
			      "The little dog laughed " +
			      "To see such sport, " +
			      "And the dish ran away with the spoon." ;

	    try {
			Pattern pattern = Pattern.compile( "the \\w+?(?=\\W)" , Pattern.CASE_INSENSITIVE );
			// Matches "the " followed by any word, regardless of case.
			
			// 대문자와 상관없이 "the"와 그 뒤에 오는 단어를 찾습니다.

			Matcher matcher = pattern.matcher( input );

			while ( matcher.find() )                   // Prints 
			{                                          // The cat
			    System.out.println( matcher.group() ); // the fiddle
			}                                          // The cow
			                                           // the moon
			                                           // The little
			                                           // the dish
			                                           // the spoon
			
			
			System.out.println();
					
			pattern = Pattern.compile( "(?i)the \\w+?(?=\\W)" );
			// Matches "the " followed by any word, regardless of case.
			
			// 대문자와 상관없이 "the"와 그 뒤에 오는 단어를 찾습니다.

			matcher = pattern.matcher( input );

			while ( matcher.find() )                   // Prints 
			{                                          // The cat
			    System.out.println( matcher.group() ); // the fiddle
			}                                          // The cow
			                                           // the moon
			                                           // The little
			                                           // the dish
			                                           // the spoon
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

	}

}
