import java.util.*;

class Solution {
    public int[] solution(int[] lottos, int[] win_nums) {
        int size = lottos.length;
        int correct_cnt = 0;
        int zero_cnt = 0;
        
        List<Integer> win = new ArrayList<>();
        for(int i : win_nums){
            win.add(i);
        }
        
        
        
        for(int i=0; i<size; i++){
            if(win.contains(lottos[i])) correct_cnt++;
            if(lottos[i] == 0) zero_cnt++;
        }
        
        
        System.out.println(correct_cnt + " " + zero_cnt);
        int big = correct_cnt + zero_cnt;
        int small = correct_cnt;
        System.out.println(big + " " + small);
        
        int[] answer = new int[2];
        answer[0] = 7-big;
        answer[1] = 7-small;
        
        if(answer[0] == 7) answer[0] = 6;
        if(answer[1] == 7) answer[1] = 6;
        return answer;
    }
}