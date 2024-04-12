class Solution {
    public int[] solution(int[] sequence, int k) {
        int[] answer = new int[]{0, Integer.MAX_VALUE};
        
        int n = sequence.length;
        int l = 0;
        int r = 0;
        
        int tmp = 0;
        while(l <= r && l < n && r < n){
            
            if(l == 0 && r == 0){
                tmp += sequence[0];
            }
            if(l == n || r == n) break;
            
            if(tmp == k){ // 찾았을 때
                //System.out.println(l + " " + r + answer[1] + " " + answer[0]);
                if(r-l < answer[1]-answer[0]){
                    answer[0] = l;
                    answer[1] = r;
                }
                tmp -= sequence[l];
                l++; // 더 줄이는 방향으로 가야 하니까
            }else if(tmp < k){ // 늘리러 가자
                r++;
                if(r != n) tmp += sequence[r];
            }else{ // tmp > k -> 줄이러 가자
                tmp -= sequence[l];
                l++;
            }
            
        }
        
        return answer;
    }
}