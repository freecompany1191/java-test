package location;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class patternMulti {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		final Pattern SIGUGUN =  Pattern.compile("(([가-힣]+(시|도)|bc|서울|부산|대구|인천|광주|대전|울산|세종|경기|강원|충북|충남|전북|경북|경남|제주)\\s[가-힣]+(시|군|구).*)");
	    
		final Pattern DUPLE_DONG = Pattern.compile("([가-힣]{1,5})+(\\d{1,5}|\\d{1,5}(,|.)\\d{1,5}|)+((읍|면|동|가|리)|(읍|면|동|가|리)\\d{1,5}(~|-)\\d{1,5})\\s", Pattern.DOTALL); 
		
		String result = "서울 강서구 등촌2동 목동605-11 영계동 영동아파트";
		
		//String result = "중계2.3동 목화 아파트 중계동 407동 610호";
		Matcher m = SIGUGUN.matcher(result);
		
	    if (m.find()) result=m.group();
	    
	    System.out.println(result);
	    
	    String dong = "";
	    
	    int i = 0;
	    int cnt = 0;
	    String chkStr = result;
	    
	    do{
	    	
    		m = DUPLE_DONG.matcher(chkStr);
    		System.out.println("chkStr while["+i+"] : "+m.find());
    		
    		System.out.println(m.group());
    		
    		chkStr = chkStr.replace(m.group(), "");
    		System.out.println("chkStr while["+i+"] result : "+chkStr);
    		if(i!=0){
    			System.out.println("chkStr m.group() : " +m.group());
    			cnt++;
    		}
    			
    		i++;
    		
    	} while(m.find());
	    
	    System.out.println("cnt : "+ cnt);
	    
	    if(cnt >= 1){
	    	
	    	i = 0;
	    	int cnt2 = 0;
	    	String tempStr = result;
		    String[] temp =new String[cnt];
		    System.out.println("temp.length : "+temp.length);
		   
		    do{
		    	
	    		m = DUPLE_DONG.matcher(tempStr);
	    		System.out.println("tempStr while["+i+"] : "+m.find());
	    		
	    		System.out.println(m.group());
	    		
	    		tempStr = tempStr.replace(m.group(), "");
	    		System.out.println("tempStr while["+i+"] result : "+tempStr);
	    		if(i!=0){
	    			System.out.println("tempStr temp["+cnt2+"] = "+m.group());
	    			temp[cnt2] = m.group();
	    			cnt2++;
	    		}
	    			
	    		i++;
	    		
	    	} while(m.find());
	
		    System.out.println("temp.length : "+ temp.length);
		    
		    	
	    	for(int j = 0; j<temp.length;j++){
	    		result = result.replaceAll(temp[j], "");
	    	}
	    
	    }
    	System.out.println("out : "+result);
    	//StringBuilder sb = new StringBuilder(result);
    	//System.out.println("sb : "+sb.toString());
    	
	}

}
