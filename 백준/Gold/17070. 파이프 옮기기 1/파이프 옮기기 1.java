import java.io.*;
import java.util.*;

public class Main {

    static int N;
    static int[][] arr;
    static int[][] visited;
    //세 방향으로 turn 가능
    static int[] dy = {0, 1, 1};
    static int[] dx = {1, 1, 0};

    static int cnt = 0;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        N = Integer.parseInt(br.readLine());
        arr = new int[N][N];
        visited = new int[N][N];

        for(int i=0; i<N; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            for(int j=0; j<N; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        dfs(0, 1, 0);
        System.out.println(cnt);
    }
    public static void dfs(int y, int x, int d) {

        if(y == N-1 && x == N-1) {
            cnt++;
            return;
        }
        
        for(int i=0; i<3; i++) {
        	if(d==0 && i==2) continue;
        	if(d==2 && i==0) continue;
        	
        	int ny = y + dy[i];
            int nx = x + dx[i];

            if(ny<0 || ny >= N || nx < 0 || nx >= N) continue;
            
            if(i==1) {
            	if(arr[y+1][x] == 1 ||  arr[y][x+1] == 1) continue;
            }
            
            if(visited[ny][nx] == 0 && arr[ny][nx] != 1) {
                visited[ny][nx] = 1;
                dfs(ny, nx, i);
                visited[ny][nx] = 0;
            }
        }

    }

}