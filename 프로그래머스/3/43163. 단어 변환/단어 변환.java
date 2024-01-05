import java.util.*;

class Solution {
    
    // 단어가 하나만 다른지 확인
    static boolean compare(String s1, String s2){
        int cnt = 0;
        for(int i=0; i<s1.length(); i++){
            if(s1.charAt(i) == s2.charAt(i)) cnt++;
        }
        
        if(cnt == s1.length()-1) return true;
        else return false;
    }
    
    static List<Integer>[] adjList;
    static int result = Integer.MAX_VALUE;
    static int[] visited;
    
    static String end;
    static String[] word;
    
    static void find(String s, int cnt){
        
        //System.out.println(s);
        if(s.equals(end)){
            result = Math.min(result, cnt+1);
            return;
        }
        
        
        int idx = -1;
        for(int i=0; i<word.length; i++){
            if(s.equals(word[i])) idx = i;
        }
        
        List<Integer> list = adjList[idx];
        for(int j=0; j<list.size(); j++){
            if(visited[list.get(j)] == 0){
                visited[list.get(j)] = 1;
                find(word[list.get(j)], cnt+1);
                visited[list.get(j)] = 0;
            } 
        }
    }
    
    public int solution(String begin, String target, String[] words) {
        
        word = new String[words.length];
        for(int i=0; i<words.length; i++){
            word[i] = words[i];
        }
        end = target;
        visited = new int[words.length];
        
        adjList = new List[words.length];
        for(int i=0; i<words.length; i++){
            adjList[i] = new ArrayList<>();
        }
        
        for(int i=0; i<words.length-1; i++){
            for(int j=i+1; j<words.length; j++){
                String s1 = words[i];
                String s2 = words[j];
                if(compare(s1, s2) == true){
                    adjList[i].add(j);
                    adjList[j].add(i);
                }
            }
        }
        
        for(int i=0; i<words.length; i++){
            if(compare(words[i], begin)){
                find(words[i], 0);
            } 
        }
        
        if(result == Integer.MAX_VALUE) result = 0;
        
        return result;
    }
}