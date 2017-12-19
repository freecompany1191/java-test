package regex.basic;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

//Maximal and Minimal (Greedy and Reluctant) Matching Behavior
//최대 및 최소 (욕심 많고 피곤한) 매칭 행동
public class matchingBehavior {

	/*
	 * Note that the default behavior of the regular expression elements presented so far is to be greedy 
	 * (hungry) and match as much of the input as possible (a maximal match).
	 * 
	 * 지금까지 제시된 정규 표현식 요소의 기본 동작은 욕심 많고 
	 * (배고픈) 가능한 한 많은 입력 (최대 일치)과 일치하는 것입니다.
	 */
	public static void main(String[] args) {
		
		try {
			String input = "1001 0101 0011 1100" ;
			
			Pattern pattern = Pattern.compile( "1.*1" );
			// Matches the sequence of characters where the first 
			// and last character is "1" with zero or more characters 
			// in between.
			
			// 첫 번째 문자가있는 문자 시퀀스와 일치합니다.     
			// 그리고 마지막 문자는 0 개 이상의 문자로 "1"입니다.     
			// 사이.
			
			Matcher matcher = pattern.matcher( input );
			System.out.println( "1.*1 matcher.find() : "+matcher.find() );  // Prints true.
			System.out.println( "1.*1 matcher.group() : "+matcher.group() ); // Prints 1001 0101 0011 11.
			System.out.println();
			
			/*
			 * A minimal match, also known as a reluctant match, would match as little of the input sequence as possible in order to satisfy the entire regular expression. 
			 * In this example, such a match would have matched the input sequence four times, the first matching subsequence being "1001". 
			 * To specify a minimal match, follow the appropriate repetition quantifier construct with a "?" . 
			 * "?" modifies the behavior of the repetition quantifier to match reluctantly.
			 * 
			 * 꺼리는 성냥이라고도하는 최소 일치는 전체 정규 표현식을 만족시키기 위해 가능한 한 적은 입력 시퀀스와 일치합니다. 
			 * 이 예에서, 이러한 일치는 입력 시퀀스를 4 번 일치 시켰으며 첫 번째 일치하는 하위 시퀀스는 "1001"이었습니다. 
			 * 최소 일치를 지정하려면 해당 반복 수량 한정자 구문에 "?" . 
			 * "?" 마지 막으로 일치하도록 반복 수량 한정자의 동작을 수정합니다.
			 * 
			 */
			
			
			input = "1001 0101 0011 1100" ;
			
			pattern = Pattern.compile( "1.*?1" );
			// Matches the sequence of characters where the first 
			// and last character is "1" with as few as possible 
			// characters in between to make the pattern match.
			
			// 첫 번째 문자가있는 문자 시퀀스와 일치합니다.     
			// 그리고 마지막 문자는 가능한 한 적게 "1"입니다.     
			// 패턴을 일치시키기 위해 중간에있는 문자.
			
			matcher = pattern.matcher( input );
			
			while ( matcher.find() )                 // Prints 
			{                                        //  1001
			  System.out.println( "1.*?1 matcher.group() : "+matcher.group() ); //  101
			}                                        //  11
			                                         //  11
			
			/*
			    ??	   	   Matches the preceding element up to one time, as few times as possible.*
				+?	   	   Matches the preceding element one or more times, as few times as possible.*
				*?	   	   Matches the preceding element zero or more times, as few times as possible.*
				{min,max}? Matches the preceding element from min to max inclusive, as few times as possible.*
				{min,}?	   Matches the preceding element min or more times, as few times as possible.*
				* Note that "as few times as possible" means "as few times as possible in order to satisfy the entire regular expression being matched."

				??	       가능한 한 적은 횟수로 앞의 요소를 최대 한 번 일치시킵니다. *
				+?	       가능한 한 적은 횟수만큼 선행 요소를 한 번 이상 일치시킵니다. *
				*?	   	   앞의 요소를 가능한 한 적은 횟수만큼 0 번 이상 일치시킵니다. *
				{min,max}? 가능한 한 몇 배로 선행 요소를 최소 에서 최대 까지 포함합니다. *
				{min,}?	   앞의 요소를 가능한 한 최소 몇 번 이상 일치시킵니다 . *
				* "최대한 적은 횟수"란 "정규 표현식 전체를 만족시키기 위해 가능한 한 수회"를 의미합니다.
			*/
		} catch (Exception e) {
			System.out.println();
			e.printStackTrace();
		}

	}

}
