import java.util.*;
import java.io.*;

public class Main {
	static int N, M;
	static int[][] arr1;
	static int[][] arr2;
	static int[][] visited;
	
	static int[] dy = {1, 0, -1, 0};
	static int[] dx = {0, 1, 0, -1};
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		arr1 = new int[N][M];
		arr2 = new int[N][M];
		
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<M; j++) {
				arr1[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		boolean flag = false;
		
		int cnt = 0; // 덩어리 카운트
		int time = 0; // 소요 시간
		while(flag == false) { // 어떠한 조건이 되기 전까지
			cnt = 0; // 덩어리 개수 초기화
			sour(); // 덩어리 녹이기
			
			// 뭉텅이 몇 갠지 체크
			visited = new int[N][M];
			for(int i=0; i<N; i++) {
				for(int j=0; j<M; j++) {
					if(visited[i][j] == 0 && arr1[i][j] != 0) {
						dfs(i, j);
						cnt++;
					}
				}
			}
			if(cnt >= 2) flag = true;
			if(cnt == 0) {
				System.out.println(0);
				System.exit(0);
			}
			time++;
//			print();
//			System.out.println("=========");
		}
	
		System.out.println(time);
	}
	
	private static void print() {
		for(int i=0; i<N; i++) {
			for(int j=0; j<M; j++) {
				System.out.print(arr1[i][j] + " ");
			}
			System.out.println();
		}
	}

	private static void sour() {
		arr2 = new int[N][M];
		
		// 배열 복사
		for(int i=0; i<N; i++) {
			for(int j=0; j<M; j++) {
				arr2[i][j] = arr1[i][j];
			}
		}
		
		// 주변 빈 곳 갯수 세서 녹이기
		for(int i=0; i<N; i++) {
			for(int j=0; j<M; j++) {
				int cnt = 0;
				for(int d=0; d<4; d++) {
					int ny = i + dy[d];
					int nx = j + dx[d];
					
					if(ny < 0 || ny >= N || nx < 0 || nx >= M) continue;
					if(arr2[ny][nx] == 0) cnt++;
				}
				arr1[i][j] -= cnt;
				if(arr1[i][j] < 0) arr1[i][j] = 0; // 0 보정
			}
		}
	}

	private static void dfs(int y, int x) {
		visited[y][x] = 1;
		
		for(int i=0; i<4; i++) {
			int ny = y + dy[i];
			int nx = x + dx[i];
			
			if(ny < 0 || ny >= N || nx < 0 || nx >= M) continue;
			if(visited[ny][nx] == 0 && arr1[ny][nx] != 0) {
				visited[ny][nx] = 1;
				dfs(ny, nx);
			}
		}
	}
}
