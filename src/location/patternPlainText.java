package location;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class patternPlainText {

	public static void main(String[] args) {
		
		Pattern addr = Pattern.compile(""
				 +"([가-힣]+(시|도)|서울|부산|대구|인천|광주|대전|울산|세종|경기|강원|충북|충남|전북|경북|경남|제주)\\s[가-힣]+(시|군|구)\\s([가-힣]{1,5})+(\\d{1,5}|\\d{1,5}(,|.)\\d{1,5}|)+(읍|면|동|가|리)?(길|로)|"
				 +"([가-힣]+(시|도)|서울|부산|대구|인천|광주|대전|울산|세종|경기|강원|충북|충남|전북|경북|경남|제주)\\s[가-힣]+(시|군|구)|"
				 +"([가-힣]+(시|도)|서울|부산|대구|인천|광주|대전|울산|세종|경기|강원|충북|충남|전북|경북|경남|제주)"
				 + "");
		 String str = "     ";
		 str = match(addr, str);
	}
	
	private static String match(Pattern p, String target){
	    
		String result = target.trim();
		
		Matcher m = p.matcher(result);
	    System.out.println("### matcher = "+m);

        //while (m.matches()) {

        if(m.matches()){ 
        	result = m.group();
        	System.out.println("m.matches() : "+m.matches() + " | result : " +result);
        }

       //}
	
	   // if (m.find()) result=m.group();
	      
		return result;
	}

}
