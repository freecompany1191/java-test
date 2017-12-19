package location;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class patternTest {
	
	public static void main(String[] args) {
		
		 Pattern addr = Pattern.compile("(([가-힣]+(시|도)|bc|서울|부산|대구|인천|광주|대전|울산|세종|경기|강원|충북|충남|전북|경북|경남|제주)\\s[가-힣]+(시|군|구).*)");
	
		 String str = "난곡동 (구 신림3동+신림13동) 서울시 관악구 난곡로31길 32-4 현대빌라 101호";
		 str = match(addr, str);
		 System.out.println(str);
	}
	
	private static String match(Pattern p, String target){
	    
		String result = target;
		
		Matcher m = p.matcher(target);
	    System.out.println("### matcher = "+m);
	
	    if (m.find()) result=m.group();
	      
		return result;
	}
	
}
