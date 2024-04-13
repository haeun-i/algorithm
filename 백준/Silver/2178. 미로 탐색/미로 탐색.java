import java.io.*;
import java.util.*;

public class Main {
	
	static int N, M;
	static int[][] arr;
	static int[][] visited;
	
	static int[] dy = {1, 0, -1, 0};
	static int[] dx = {0, 1, 0, -1};
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		arr = new int[N][M];
		visited = new int[N][M];
		
		for(int i=0; i<N; i++) {
			String srt = br.readLine();
			for(int j=0; j<M; j++) {
				arr[i][j] = srt.charAt(j)-'0';
			}
		}
		
		Queue<int[]> q = new LinkedList<>();
		q.add(new int[] {0, 0});
		visited[0][0] = 1;
		
		while(!q.isEmpty()) {
			int[] tmp = q.poll();
			
			if(tmp[0] == N-1 && tmp[1] == M-1) break;
			for(int d=0; d<4; d++) {
				int ny = tmp[0] + dy[d];
				int nx = tmp[1] + dx[d];
				
				if(ny < 0 || ny >= N || nx < 0 || nx >= M) continue;
				
				if(arr[ny][nx] == 1 && visited[ny][nx] == 0) {
					q.add(new int[] {ny, nx});
					visited[ny][nx] = visited[tmp[0]][tmp[1]] + 1;
				} 
			}
		}
		
		System.out.println(visited[N-1][M-1]);
		
		
	}
}