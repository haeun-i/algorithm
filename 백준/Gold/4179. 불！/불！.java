import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

	static int R;
	static int C;

	static int[] dy = { 1, 0, -1, 0 };
	static int[] dx = { 0, 1, 0, -1 };

	static char[][] arr;
	static int[][] fireVisit;
	static int[][] jihoonVisit;
	
	static int sy = -1;
	static int sx = -1;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		arr = new char[R][C];
		fireVisit = new int[R][C];
		jihoonVisit = new int[R][C];

		Queue<int[]> q = new LinkedList<>();
		for (int i = 0; i < R; i++) {
			String s = br.readLine();
			for (int j = 0; j < C; j++) {
				arr[i][j] = s.charAt(j);
				if(arr[i][j] == 'F') q.add(new int[] {i, j});
				else if(arr[i][j] == 'J') {
					sy = i;
					sx = j;
				}
			}
		}

		// fire 확산
		while(!q.isEmpty()) {
			int[] tmp = q.poll();
			
			for(int i=0; i<4; i++) {
				int ny = tmp[0] + dy[i];
				int nx = tmp[1] + dx[i];
				
				if(ny < 0 || ny >= R || nx < 0 || nx >= C) continue;
				if(arr[ny][nx] == '.' && fireVisit[ny][nx] == 0) {
					q.add(new int[] {ny, nx});
					fireVisit[ny][nx] = fireVisit[tmp[0]][tmp[1]] + 1;
				}
			}
		}
		
		// 지훈 확산
		q.clear();
		q.add(new int[] {sy, sx});
		while(!q.isEmpty()) {
			int[] tmp = q.poll();
			
			for(int i=0; i<4; i++) {
				int ny = tmp[0] + dy[i];
				int nx = tmp[1] + dx[i];
				
				if(ny < 0 || ny >= R || nx < 0 || nx >= C) continue;
				if(arr[ny][nx] == '.' && jihoonVisit[ny][nx] == 0) {
					q.add(new int[] {ny, nx});
					jihoonVisit[ny][nx] = jihoonVisit[tmp[0]][tmp[1]] + 1;
				}
			}
		}
		
		for(int i=0; i<R; i++) {
			for(int j=0; j<C; j++) {
				if((jihoonVisit[i][j] < fireVisit[i][j]) || (arr[i][j] == '.' && fireVisit[i][j] == 0)) {
					arr[i][j] = '.'; // 갈 수 있는 곳
				}else arr[i][j] = '#'; // 갈 수 없는 곳
			}
		}
		
		// 다시 지훈을 옮겨본
		jihoonVisit = new int[R][C];
		q.add(new int[] {sy, sx});
		jihoonVisit[sy][sx] = 1;
		while(!q.isEmpty()) {
			int[] tmp = q.poll();
			
			for(int i=0; i<4; i++) {
				int ny = tmp[0] + dy[i];
				int nx = tmp[1] + dx[i];
				
				if(ny < 0 || ny >= R || nx < 0 || nx >= C) {
					// 탈출
					System.out.println(jihoonVisit[tmp[0]][tmp[1]]);
					System.exit(0);
				}
				
				if(arr[ny][nx] == '.' && jihoonVisit[ny][nx] == 0) {
					q.add(new int[] {ny, nx});
					jihoonVisit[ny][nx] = jihoonVisit[tmp[0]][tmp[1]] + 1;
				}
			}
		}
		
		if(res == -1) System.out.println("IMPOSSIBLE");
		
	}
	
	static int res = -1;

}