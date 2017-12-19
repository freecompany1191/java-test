package regex.basic;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

//일반 텍스트
public class plainText {

	/**
	 * The boolean matches() method attempts to match the entire input sequence against the pattern.
	   The boolean lookingAt() method attempts to match part or all of the input sequence, starting at the beginning, against the pattern.
       The boolean find() and boolean find( int ) methods scan the input sequence looking for the next subsequence that matches the pattern.

	boolean matches() 메서드는 전체 입력 시퀀스를 패턴과 비교하려고 시도합니다. 
	boolean의 lookingAt() Methods는, 입력 순서의 일부 또는 전부를, 패턴의 선두로부터 시작해 패턴과 대조합니다. 
	boolean find()와 boolean find (int) 메소드는 입력 시퀀스를 스캔하여 패턴과 일치하는 다음 하위 시퀀스를 찾습니다.
	
	The most basic regular expression is a literal text string. The alphanumeric characters are interpreted literally1.
	The word "shells" can be found in a String as follows:
	
	가장 기본적인 정규식은 리터럴 텍스트 문자열입니다. 
	영숫자는 문자 그대로 해석됩니다 1. "쉘"이라는 단어는 다음과 같이 String에서 찾을 수 있습니다.
	*/
	
	public static void main(String[] args) {
		String input = "She sells sea shells by the sea shore." ;
	    
	    try {
			// Create a Pattern object.  A Pattern is a 
			// compiled representation of a regular expression.
			
			// Pattern 객체를 만듭니다. 패턴은     
			// 정규 표현의 컴파일 된 표현.
			Pattern pattern = Pattern.compile( "shells" );
			
			// Create a Matcher object.  A Matcher is an engine that 
			// performs match operations on a character sequence by 
			// interpreting a Pattern.
			
			// Matcher 객체를 만든다. Matcher는     
			// 문자 시퀀스에서 일치 작업을 수행합니다.     
			// 패턴 해석.
			Matcher matcher = pattern.matcher( input );
			
			// Prints false.  matcher.matches() attempts to 
			// match the entire input sequence against the pattern.  
			// The match would have succeeded, if the pattern described 
			// the entire input String.
			
			// false를 인쇄합니다. matcher.matches() 시도     
			// 전체 입력 시퀀스를 패턴과 비교합니다.     
			// 설명 된 패턴이 일치하면 일치가 성공했을 것입니다.     
			// 전체 입력 문자열.
			System.out.println( "matcher.matches() : "+matcher.matches() ); //패턴과 완벽 일치시 true
			
			// Prints false.  matcher.lookingAt() attempts to 
			// match the input sequence, starting at the beginning, 
			// against the pattern.  The match would have succeeded, 
			// if the pattern were "She".
			
			// false를 인쇄합니다. matcher.lookingAt() 시도     
			// 입력 시퀀스를 처음부터 시작하고,     
			// 패턴에 대해. 그 경기는 성공했을 것이다.     
			// 패턴이 "She"인 경우.
			System.out.println( "matcher.lookingAt() : "+matcher.lookingAt() ); //패턴의 시작부 부터 패턴이 있는 부분까지 일치 하면 true
			
			/*
			 * Matcher and Pattern objects have methods to return the parts of an input String matched against a pattern. 
			 * The String group() method of the Matcher class returns the input subsequence matched by the previous match4. 
			 * The String[] split( CharSequence ) method of the Pattern class splits the specified input character sequence around matches of a pattern3. 
			 * (Since Java 1.4, String objects also have two split methods that take a regular expression as a parameter 
			 * and split the String object around matches of the regular expression, returning a String array of the result.)
			 * 
			 * Matcher 및 Pattern 객체에는 패턴과 일치하는 입력 문자열의 일부를 반환하는 메서드가 있습니다. 
			 * Matcher 클래스의 String group () 메서드는 이전 match4와 일치하는 입력 하위 시퀀스를 반환합니다.
			 * Pattern 클래스의 String [] split (CharSequence) 메서드는 지정된 입력 문자 시퀀스를 pattern3과 일치하도록 분할합니다.
			 * (Java 1.4 이후, String 객체는 정규 표현식을 매개 변수로 사용하는 두 개의 split 메소드를 가지고 있으며 
			 * 정규 표현식과 일치하는 문자열 객체를 분리하여 결과의 String 배열을 반환합니다.
			 */
			
			// The Matcher must be reset and searched again after 
			// failed attempts at matching.  The Matcher would  
			// otherwise not be in a proper state to get the 
			// information related to the last match and methods 
			// that query for such information would throw an 
			// IllegalStateException.  Note that the find() method 
			// resets the Matcher if previous attempts at matching 
			// failed.
			
			// Matcher는 재설정 된 후 다시 검색해야합니다.     
			// 일치 시도 실패. 성냥갑은     
			// 그렇지 않으면 적절한 상태에 있지 않아서     
			// 마지막 일치 및 메서드와 관련된 정보
			// 그런 정보에 대한 쿼리는     
			// IllegalStateException. find () 메소드 일치하는 이전 시도가있는 경우 
			// Matcher를 재설정합니다.     
			// failed.
			
			// Prints true.  matcher.find() attempts to find 
			// the next subsequence of the input sequence that 
			// matches the pattern.
			
			// true를 인쇄합니다. matcher.find ()가 검색을 시도합니다.     
			// 입력 시퀀스의 다음 하위 시퀀스     
			// 패턴과 일치합니다.
			System.out.println( "matcher.find() : "+matcher.find() ); //패턴과 일치하는 부분이 있으면 true
			System.out.println( "matcher.group() : "+matcher.group() );      // Prints shells.
			
			String[] splits = pattern.split( input );
			System.out.println( "splits.length : "+splits.length );        // Prints 2.
			
			for ( int i = 0 ; i < splits.length ; i++ ) // Prints 
			{                                           // She sells sea
			    System.out.println( "splits["+i+"] = "+splits[ i ] );      //  by the sea shore.
			}
			
			
			/*
			 * Note that regular expression patterns in Java are by default case sensitive. 
			 * So, using the same input, a search for "Shells" would have failed. 
			 *
			 * 자바의 정규식 패턴은 기본적으로 대소 문자를 구분합니다. 
			 * 따라서 동일한 입력을 사용하여 "Shells"검색이 실패했습니다. 
			 */
			pattern = Pattern.compile( "Shells");
			//pattern = Pattern.compile( "(?i)Shells" ); //true
			//pattern = Pattern.compile( "Shells" , Pattern.CASE_INSENSITIVE); //true
			
			// Since a new Pattern is to be used, a new Matcher 
			// must also be used.
			
			// 새로운 패턴이 사용되기 때문에, 새로운 Matcher     
			// 또한 사용해야합니다.
			matcher = pattern.matcher( input );
			
			System.out.println("Matching Shells : "+ matcher.find() ); // Prints false.
			
		} catch (Exception e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
		}
	}

}
