import java.util.*;

class Solution {
    static int[] visited;
    static int[][] arr;
    static int N;
    
    public static void bfs(int num){
        Queue<Integer> q = new LinkedList<>();
        q.add(num);
        visited[num] = 1;
        
        while(!q.isEmpty()){
            int tmp = q.poll();
            for(int i=0; i<N; i++){
                if(arr[tmp][i] == 1 && visited[i] == 0){
                    q.add(i);
                    visited[i] = 1;
                }
            }
        }
    }
    
    public int solution(int n, int[][] computers) {
        int answer = 0;
        arr = computers;
        visited = new int[n];
        N = n;
        
        for(int i=0; i<n; i++){
            if(visited[i] == 0) {
                bfs(i);
                answer++;
            }
        }
        return answer;
    }
}