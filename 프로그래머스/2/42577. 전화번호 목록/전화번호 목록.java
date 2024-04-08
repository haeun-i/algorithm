import java.util.*;

class Solution {
    public boolean solution(String[] phone_book) {
        boolean answer = true;
        
        Arrays.sort(phone_book);
        HashMap<String, Integer> st = new HashMap<>();
        for(String s: phone_book){
            String tmp = "";
            for(int i=0; i<s.length(); i++){
                tmp += s.charAt(i);
                if(st.get(tmp) != null){
                    answer = false;
                    break;
                }
            }
            st.put(s, 0);
        }
        
        return answer;
    }
}