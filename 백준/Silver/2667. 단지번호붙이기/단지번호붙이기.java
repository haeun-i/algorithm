import java.io.*;
import java.util.*;

public class Main {

	static int N;
	static int[][] map;
	static int[] dr = {-1, 0, 1, 0};
	static int[] dc = {0, 1, 0, -1};
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		map = new int[N][N];
		
		for(int i=0; i<N; i++) {
			String s = br.readLine();
			char[] cs = s.toCharArray();
			for(int j=0; j<N; j++) {
				map[i][j] = cs[j] - '0';
			}
		}
		
		int cnt = 0;
		for(int i=0; i<N; i++) {
			for(int j=0; j<N; j++) {
				if(map[i][j] == 1) {
					cnt++;
					bfs(i, j, cnt+1);
				}
			}
		}
		
		System.out.println(cnt);
		int[] res = new int[cnt];
		
		for(int k = 2; k < 2+cnt; k++) {
			for(int i=0; i<N; i++) {
				for(int j=0; j<N; j++) {
					if(map[i][j] == k) {
						res[k-2]++;
					}
				}
			}
		}
		
		Arrays.sort(res);
		for(int i=0; i<cnt; i++) {
			System.out.println(res[i]);
		}
		
	}

	private static void bfs(int r, int c, int g) {
		Queue<int[]> que = new LinkedList<int[]>();
		que.offer(new int[] {r, c});
		map[r][c] = g;
		
		while(!que.isEmpty()) {
			int[] cur = que.poll();
			int cr = cur[0];
			int cc = cur[1];
			
			for(int d=0; d<4; d++) {
				int nr = cr+dr[d];
				int nc = cc+dc[d];
				if(!check(nr, nc)) continue;
				
				if(map[nr][nc] == 1) {
					que.offer(new int[] {nr, nc});
					map[nr][nc] = g;
				}
			}
		}
	}

	static boolean check(int r, int c) {
		return r>=0 && r<N && c>=0 && c<N;
	}
}