package regex.basic;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RepetitionQuantifiers {

	public static void main(String[] args) {
		//반복 한정어
		//"?" , "+", "*"및 "{}"는 패턴 요소를 여러 번 (또는 0 번) 일치시키는 기능을 제공합니다.
		/*
			?			Matches the preceding element zero or one times.
			+			Matches the preceding element one or more times.
			*			Matches the preceding element zero or more times.
			{n}			Matches the preceding element n number of times.
			{min,max}	Matches the preceding element a specified number of times from min to max inclusive.
			{min,}		Matches the preceding element min or more times.
	
			?			앞의 요소를 0 번 또는 1 번 일치시킵니다.
			+			이전 요소를 한 번 이상 일치시킵니다.
			*			앞의 요소를 0 번 이상 찾습니다.
			{n}			앞의 요소를 n 번 반복합니다.
			{min,max}	앞에있는 요소를 최소값 에서 최대 값 까지 지정된 횟수만큼 일치시킵니다 .
			{min,}		선행 요소와 일치 분 이상의 시간.
		*/
		
		//이 요소 앞에는 일치시킬 다른 패턴 요소가 접두어로 있어야합니다.
		
		String input = "Some say, ABBBBBBBBBBA is a grooooovy music group." ;
		input = "Some say, ABBBBBBBBBBA i" ;
	    
	    try {
			Pattern pattern = Pattern.compile( "is?" );
			// Matches the "i" character or the "i" character 
			// followed by an "s".
			
			// "i"문자 또는 "i"문자와 일치합니다.     
			// 뒤에 "s"가옵니다.
			
			Matcher matcher = pattern.matcher( input );
			System.out.println( "is? matcher.find() : "+matcher.find() );  // Prints true.
			System.out.println( "is? matcher.group() : "+matcher.group() ); // Prints is.
			System.out.println();
			
			pattern = Pattern.compile( "x?" );

			// Matches the "x" character or nothing.
			
			// "x"문자와 일치하거나 아무것도 일치하지 않습니다.
			matcher = pattern.matcher( input );
			System.out.println( "x? matcher.find() : "+matcher.find() );  // Prints true.
			System.out.println( "x? matcher.group() : "+matcher.group() ); // Prints the empty String.
			System.out.println();
			
			pattern = Pattern.compile( "AB+A" );
			// Matches the sequence of characters that begins 
			// and ends with "A" with one or more "B" characters 
			// in the middle.
			
			// 시작하는 문자의 순서와 일치합니다.     
			// "A"와 하나 이상의 "B"문자로 끝납니다.     
			// 중간에.
			
			matcher = pattern.matcher( input );
			System.out.println( "AB+A matcher.find() : "+matcher.find() );  // Prints true.
			System.out.println( "AB+A matcher.group() : "+matcher.group() ); // Prints ABBA.
			System.out.println();
			
			input = "Some say, ABBBBBBBBBBCCCCCCCCCCCCCCCCCCCCCCCCCCCCCCCCCA is a groovy music group." ;
			pattern = Pattern.compile( "AB*C*A" );
			// Matches the sequence of characters that begins 
			// and ends with "A" and has zero or more "B" 
			// characters followed by zero or more "C" characters 
			// in the middle.
			
			// 시작하는 문자의 순서와 일치합니다.     
			// "A"로 끝나고 0 개 이상의 "B"     
			// 문자 뒤에 0 개 이상의 "C"문자가옵니다.     
			// 중간에.
			
			matcher = pattern.matcher( input );
			System.out.println( "AB*C*A matcher.find() : "+matcher.find() );  // Prints true.
			System.out.println( "AB*C*A matcher.group() : "+matcher.group() ); // Prints ABBA.
			System.out.println();
			
			pattern = Pattern.compile( "gro{2,}vy" );
			// Matches the sequence of characters that begins 
			// "gr" , ends with "vy" , and has two or more "o" 
			// characters in the middle.
			
			// 시작하는 문자의 순서와 일치합니다.     
			// "gr", "vy"로 끝나며 두 개 이상의 "o" 문자가 중간에 있는 문자.
			
			matcher = pattern.matcher( input );
			System.out.println( "gro{2,}vy matcher.find() : "+matcher.find() );  // Prints true.
			System.out.println( "gro{2,}vy matcher.group() : "+matcher.group() ); // Prints grooooovy.
			System.out.println();
			
			input = "Some say, ABBA is a grvy music group." ;
			pattern = Pattern.compile( "gro?vy" );
			// Matches the sequence of characters that begins 
			// "gr" , ends with "vy" , and has zero or one "o" 
			// characters in the middle.
			
			// 시작하는 문자의 순서와 일치합니다.     
			// "gr", "vy"로 끝나며 "o" 문자가 없거나 하나만 있는 문자.
			
			matcher = pattern.matcher( input );
			System.out.println( "gro?vy matcher.find() : "+matcher.find() );  // Prints false.
			System.out.println( "gro?vy matcher.group() : "+matcher.group() ); // Prints grooooovy.
		} catch (Exception e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
		}

	}

}
