import java.util.*;
import java.io.*;

public class Main {
	static int R, C, T;
	static int[][] arr;
	static int[][] copy;
	static List<int[]> cleaner;
	
	static int[] dy = {0, -1, 0, 1};
	static int[] dx = {1, 0, -1, 0};
	static int cnt = 0;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		T = Integer.parseInt(st.nextToken());
		
		arr = new int[R][C];
		
		cleaner = new ArrayList<>();
		for(int i=0; i<R; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for(int j=0; j<C; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
				if(arr[i][j] == -1) cleaner.add(new int[] {i, j});
			}
		}
		
		for(int tc = 0; tc<T; tc++) { // t초 동안 진
			spread();
			circle();
		}
		print();
		System.out.println(cnt+2); // -1 두 번 되는거 체크
	}
	
	private static void spread() {
		copy = new int[R][C];
		// 모든 점에 대해 확산 수 구하
		for(int i=0; i<R; i++) {
			for(int j=0; j<C; j++) {
				if(arr[i][j] != 0 && arr[i][j] != -1) { // 순환 할 게 있는 경
					for(int d=0; d<4; d++) {
						int ny = i + dy[d];
						int nx = j + dx[d];
						
						if(ny < 0 || ny >= R || nx < 0 || nx >= C) continue;
						if(arr[ny][nx] == -1) continue;
						copy[ny][nx] += arr[i][j]/5;
						copy[i][j] -= arr[i][j]/5;
					}
				}
			}
		}
		
		// 확산 수를 원 배열에 더해주
		for(int i=0; i<R; i++) {
			for(int j=0; j<C; j++) {
				arr[i][j] += copy[i][j];
			}
		}
	}

	private static void circle() {
		copy = new int[R][C];
		
		Queue<int[]> q = new LinkedList<>();
		// 공기청정기의 윗부분 좌표 -> 반시계방향으로 회전한다.
		int[] point1 = cleaner.get(0);
		q.add(new int[] {point1[0], point1[1]+1});
		int d = 0;
		while(!q.isEmpty()) {
			int tmp[] = q.poll();
			int ny = tmp[0] + dy[d];
			int nx = tmp[1] + dx[d];
			
			if(ny < 0 || ny >= R || nx < 0 || nx >= C) {
				d++;
				ny = tmp[0] + dy[d];
				nx = tmp[1] + dx[d];
			}
			copy[ny][nx] = arr[tmp[0]][tmp[1]];
			q.add(new int[] {ny, nx});
			if(ny == point1[0] && nx == point1[1]) break;
		}
		
		q.clear();
		// 공기청정기의 아랫부분 좌표 -> 시계방향으로 회전한다.
		int[] point2 = cleaner.get(1);
		q.add(new int[] {point2[0], point2[1]+1});
		d = 4;
		while(!q.isEmpty()) {
			int tmp[] = q.poll();
			int ny = tmp[0] + dy[d%4];
			int nx = tmp[1] + dx[d%4];
			
			if(ny < 0 || ny >= R || nx < 0 || nx >= C) {
				d--;
				ny = tmp[0] + dy[d%4];
				nx = tmp[1] + dx[d%4];
			}
			copy[ny][nx] = arr[tmp[0]][tmp[1]];
			q.add(new int[] {ny, nx});
			
			if(ny == point2[0] && nx == point2[1]) break;
		}
		
		// 회전한 거 원래대로 붙이기
		for(int i=0; i<R; i++) {
			for(int j=0; j<C; j++) {
				if((j == 0 || j == C-1) || (i == 0 || i == point1[0] || i == point2[0] || i == R-1)){
					arr[i][j] = copy[i][j];
				}
			}
		}
		arr[point1[0]][point1[1]] = -1;
		arr[point2[0]][point2[1]] = -1;
	}
	
	private static void print() {
		for(int i=0; i<R; i++) {
			for(int j=0; j<C; j++) {
				cnt += arr[i][j];
			}
		}
	}
}
