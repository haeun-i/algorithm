import java.util.*;
import java.io.*;

public class Main {
	
	static int[][] board;
	static int N;
	static int K;
	static Queue<int[]> change;
	static Deque<int[]> snake;
	
	static int[] dy = {0, 1, 0, -1};
	static int[] dx = {1, 0, -1, 0};
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		board = new int[N][N];
		
		K = Integer.parseInt(br.readLine());
		StringTokenizer st;
		for(int i=0; i<K; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			int n1 = Integer.parseInt(st.nextToken());
			int n2 = Integer.parseInt(st.nextToken());
			board[n1-1][n2-1] = 10; // 사과
		}
		snake = new ArrayDeque<>();
		snake.addFirst(new int[] {0, 0});
		board[0][0] = -1; // 뱀의 시작
		
		int L = Integer.parseInt(br.readLine());
		change = new LinkedList<>();
		for(int i=0; i<L; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			int n1 = Integer.parseInt(st.nextToken());
			int n2 = 0;
			if(st.nextToken().equals("L")) n2 = 1;
			change.add(new int[] {n1, n2});
		}
		//print();
		int time = 0;
		int d = 0;
		while(true) {
			time++; // 시간 증가
			
			if(!change.isEmpty()) {
				int[] tmp = change.peek();
				if(tmp[0] == time-1) { // 방향 전환 코드
					if(tmp[1] == 0) d = (d+1)%4;
					else d = (d+3)%4;
					change.poll();
				}
			}
			
			
			int ny = snake.getFirst()[0] + dy[d];
			int nx = snake.getFirst()[1]+ dx[d];
			
			//System.out.println(ny + " " + nx + " " + time);
			
			if(ny < 0 || ny >= N || nx < 0 || nx >= N) break; // 벽에 닿으면 정지
			if(board[ny][nx] == -1) break; // 자신의 몸에 닿으면 정지 
			
			if(board[ny][nx] != 10) {
				// 사과가 없으면
				int[] tail = snake.getLast();
				board[tail[0]][tail[1]] = 0; // 꼬리 해제
				snake.removeLast();
			}
			snake.addFirst(new int[] {ny, nx});
			board[ny][nx] = -1;
			//print();
		}
		
		System.out.println(time);
	}
}
