import java.util.*;

class Solution {
    public int solution(int[] scoville, int K) {
        int answer = 0;
        
        PriorityQueue<Integer> list = new PriorityQueue<>();
        for(int i : scoville){
            list.add(i);
        }
        
        while(list.peek() < K && list.size()>=2){
            int n1 = list.poll();
            int n2 = list.poll();
            list.add(n1 + 2 * n2);
            answer++;
        }
        
        if(list.peek()<K) answer = -1; // 다 해도 작으면
        return answer;
    }
}