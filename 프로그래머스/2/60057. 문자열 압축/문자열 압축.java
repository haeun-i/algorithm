import java.util.*;

class Solution {
    public int solution(String s) {
	        int min = Integer.MAX_VALUE;
	        
	        for(int i=1; i<=s.length()/2; i++){
	            HashMap<String, Integer> map = new HashMap<>();
	            String hubo = "";
	            String tmp = s.substring(0, i);
	            map.put(tmp, 1);
	            //System.out.println(tmp);
	            for(int j=i; j<s.length()-i+1; j+=i){
	                String now = s.substring(j, j+i);
	                //System.out.println(now);
	                if(now.equals(tmp)){
	                    if(map.containsKey(now)){
	                        map.put(now, map.get(now)+1);
	                    }else{
	                        map.put(now, 1);
	                    }
	                }else{
	                	if(map.get(tmp) != 1) hubo += (map.get(tmp)+tmp);
	                	else hubo += tmp;
                        map.remove(tmp);
                        map.put(now, 1);
	                }
	                tmp = now;
	            }
	            
	            if(map.get(tmp) != 1) hubo += (map.get(tmp)+tmp);
            	else hubo += tmp;
                hubo += s.substring(s.length()- (s.length()%i), s.length());
	           
	            min = Math.min(hubo.length(), min);
	         
	        }
	        
            if(min == Integer.MAX_VALUE) min = 1;
	        
	        return min;
    }
}