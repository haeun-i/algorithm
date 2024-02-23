package algorithm;

public class Solution {
	public static int[] solution(int[] sequence, int k) {
	    
        int N = sequence.length;
        
        int l = 0;
        int r = 0;
    
        int[] answer = {0, 1000000};
        
        int sum = sequence[0];
        while(l <= r){
           
          
            if(sum == k){
                if(r-l+1 < answer[1]-answer[0]+1){
                    answer[0] = l;
                    answer[1] = r;
                }
                r++;
                if(r == N) break;
                sum += sequence[r];
            }else if(sum < k) {
                r++;
                if(r == N) break;
                sum += sequence[r];
            }else{
            	
                sum -= sequence[l];
                l++;
                if(l == N) break;
                
            }           
            //ystem.out.println(l + " " + r + " " + sum);
        }
        
        System.out.println(answer[0] + " " + answer[1]);
        
        return answer;
    }
	
	public static void main(String[] args) throws Exception{
		int[] sequence = {1, 2, 3, 4, 5};
		solution(sequence, 7);
	}
}
