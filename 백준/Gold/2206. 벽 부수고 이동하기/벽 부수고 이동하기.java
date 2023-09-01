import java.util.*;
import java.io.*;

public class Main {
	
	static int N, M;
	static int[][] arr;
	static int[][][] visited;
	static Queue<int[]> wall;
	
	static int[] dy = {1, 0, -1, 0};
	static int[] dx = {0, 1, 0, -1};
	
	static int min = Integer.MAX_VALUE;
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		arr = new int[N][M];
		
		for(int i=0; i<N; i++) {
			String tmp = br.readLine();
			for(int j=0; j<M; j++) {
				arr[i][j] = tmp.charAt(j) - '0';
			}
		}
		
		visited = new int[N][M][2];
		Queue<int[]> q = new LinkedList<>();
		q.offer(new int[] {0, 0, 1});
		
		while(!q.isEmpty()) {
			int[] front = q.poll();
			int y = front[0];
			int x = front[1];
			int d = front[2];
			
			for(int i=0; i<4; i++) {
				int ny = y + dy[i];
				int nx = x + dx[i];
				
				if(ny<0 || ny >= N || nx < 0 || nx >= M) continue;
				if(visited[ny][nx][d] == 0) {
					if(arr[ny][nx] == 1 && d == 1) {
						q.offer(new int[] {ny, nx, d-1});
						visited[ny][nx][d-1] = visited[y][x][d] + 1;
					}else if(arr[ny][nx] == 0) {
						q.offer(new int[] {ny, nx, d});
						visited[ny][nx][d] = visited[y][x][d] + 1;
					}
				}
			}
		}
		
	
		if(visited[N-1][M-1][0] == 0) min = visited[N-1][M-1][1];
		else if(visited[N-1][M-1][1] == 0) min = visited[N-1][M-1][0];
		else {
			min = Math.min(visited[N-1][M-1][0], visited[N-1][M-1][1]);
		}
		
		if(N == 1 && M == 1) System.out.println(1);
		else {
			if(min == 0) {
				System.out.println(-1);
			}else System.out.println(min + 1);
		}
		
	}

}
