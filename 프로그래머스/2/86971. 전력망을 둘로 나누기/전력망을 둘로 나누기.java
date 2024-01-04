class Solution {
    
    static int N;
    static int[][] arr;
    static int[] visited;
    
    static int cnt = 0;
    
    static void find(int num){
        for(int i=1; i<=N; i++){
            if(arr[num][i] == 1 && visited[i] == 0){
                visited[i] = 1;
                find(i);
                cnt++;
            }
        }
    }
    
    public int solution(int n, int[][] wires) {
        int answer = Integer.MAX_VALUE;
        N = n;
        arr = new int[N+1][N+1];
        
        // 인접 행렬 연결
        for(int[] i : wires){
            arr[i[0]][i[1]] = 1;
            arr[i[1]][i[0]] = 1;
        }
        
        for(int[] i : wires){
            // 연결 해제
            arr[i[0]][i[1]] = 0;
            arr[i[1]][i[0]] = 0;
            
            visited = new int[N+1]; // 방문 배열 초기화
            int tmp1 = -1;
            int tmp2 = -1;
            for(int j=1; j<=N; j++){
                if(visited[j] == 0){
                    visited[j] = 1;
                    find(j);
                    if(tmp1 == -1) tmp1 = cnt;
                    else tmp2 = cnt;
                    cnt = 0;
                    visited[j] = 0;
                }
            }
            
            answer = Math.min(answer, Math.abs(tmp1-tmp2));
            
            // 원상 복구
            arr[i[0]][i[1]] = 1;
            arr[i[1]][i[0]] = 1;
        }
        
        return answer;
    }
}