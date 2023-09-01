
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	
	static int[] dy = {1, 0, -1, 0};
	static int[] dx = {0, 1, 0, -1};
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st  = new StringTokenizer(br.readLine(), " ");
		int m = Integer.parseInt(st.nextToken());
		int n = Integer.parseInt(st.nextToken());
	
		int[][] arr = new int[n][m];
		int[][] visited = new int[n][m];
		
		for(int i=0; i<n; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for(int j=0; j<m; j++) {
				arr[i][j] =  Integer.parseInt(st.nextToken());
			}
		}
		
		int cnt = 0;
		int minus_cnt = 0;
		int max = 0;
		Queue<int[]> q = new LinkedList<>();
		for(int i=0; i<n; i++) {
			for(int j=0; j<m; j++) {
				if(arr[i][j] == 1) {
					q.offer(new int[] {i, j});
					cnt++;
				}else if(arr[i][j] == -1) minus_cnt++;
			}
		}
		
		while(!q.isEmpty()) {
			int[] front = q.poll();
			int y = front[0];
			int x = front[1];
			
			for(int i=0; i<4; i++) {
				int ny = y + dy[i];
				int nx = x + dx[i];
				
				if(ny < 0 || ny >= n || nx < 0 || nx >= m) continue;
				if(visited[ny][nx] == 0 && arr[ny][nx] == 0) {
					q.offer(new int[] {ny, nx});
					visited[ny][nx] = visited[y][x] + 1;
					max = Math.max(max,  visited[ny][nx]);
					cnt++;
				}
			}
		}
		
		if(cnt == n*m - minus_cnt) {
			System.out.println(max);
		}else {
			System.out.println(-1);
		}
		
	}
	
	
}
