import java.io.*;
import java.util.*;

public class Main {
	
	static int n, m;
	static int[][] arr;
	static int[][] visited;
	static int[] dy = {1, 0, -1, 0};
	static int[] dx = {0, 1, 0, -1};
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int t = Integer.parseInt(br.readLine());
		
		for(int tc = 0; tc<t; tc++) {
			st = new StringTokenizer(br.readLine(), " ");
			m = Integer.parseInt(st.nextToken());
			n = Integer.parseInt(st.nextToken());
			int k = Integer.parseInt(st.nextToken());
			arr = new int[n][m];
			visited = new int[n][m];
			
			int y, x;
			for(int i=0; i<k; i++) {
				st = new StringTokenizer(br.readLine(), " ");
				x = Integer.parseInt(st.nextToken());
				y = Integer.parseInt(st.nextToken());
				
				arr[y][x] = 1;
			}
			
			
			int cnt = 0;
			for(int i=0; i<n; i++) {
				for(int j=0; j<m; j++) {
					if(visited[i][j] == 0 && arr[i][j] == 1) {
						dfs(i, j);
						cnt++;
					}
				}
			}
			
			System.out.println(cnt);
			
		}
		
	}

	private static void dfs(int y, int x) {
		visited[y][x] = 1;
		
		for(int i=0; i<4; i++) {
			int ny = y + dy[i];
			int nx = x + dx[i];
			if(ny < 0 || ny >= n || nx < 0 || nx >= m) continue;
			if(visited[ny][nx] == 0 && arr[ny][nx] == 1) dfs(ny, nx);
		}
		
	}
}