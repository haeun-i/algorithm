import java.util.*;
import java.io.*;

public class Main {
	
    public static int[] dy_horse = {-2, -2, -1, -1, 1, 1, 2, 2};
    public static int[] dx_horse = {-1, 1, -2, 2, -2, 2, -1, 1};
    public static int[] dy = {1, 0, -1, 0};
    public static int[] dx = {0, 1, 0, -1};
    
    public static int[][] arr;
    public static int[][][] visited; 
    
    public static int K;
    public static int W, H;
    public static int min = Integer.MAX_VALUE;
    
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        K = Integer.parseInt(br.readLine());
        
        st = new StringTokenizer(br.readLine(), " ");
        W = Integer.parseInt(st.nextToken());
        H = Integer.parseInt(st.nextToken());
        arr = new int[H][W];
        visited = new int[H][W][31];
        
        for(int i=0; i<H; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            for(int j=0; j<W; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        
        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[] {0, 0, 0}); 
        visited[0][0][0] = 0;
        
        while(!q.isEmpty()) {
            int[] tmp = q.poll();
            int y = tmp[0];
            int x = tmp[1];
            int d = tmp[2]; 
            
            if(y == H - 1 && x == W - 1) {
            	min = visited[y][x][d];
                break;
            }
            
            // 원숭이로 방문
            for(int i=0; i<4; i++) {
                int ny = y + dy[i];
                int nx = x + dx[i];
                
                if(ny < 0 || ny >= H || nx < 0 || nx >= W) continue;
                if(arr[ny][nx] != 1 && visited[ny][nx][d] == 0) { 
                    q.offer(new int[] {ny, nx, d});
                    visited[ny][nx][d] = visited[y][x][d] + 1;
                }
            }
            
            if(d < K) { // 말처럼 방문이 가능한 경우
                for(int i=0; i<8; i++) {
                    int ny = y + dy_horse[i];
                    int nx = x + dx_horse[i];
                    
                    if(ny < 0 || ny >= H || nx < 0 || nx >= W) continue;
                    
                    if(arr[ny][nx] != 1 && visited[ny][nx][d+1] == 0) {
						q.offer(new int[] {ny, nx, d+1});
						visited[ny][nx][d+1] = visited[y][x][d] + 1;
					}
                }
            }
        }
        
        
        if(min == Integer.MAX_VALUE) {
            System.out.println(-1);
        } else {
            System.out.println(min);
        }
    }
}

