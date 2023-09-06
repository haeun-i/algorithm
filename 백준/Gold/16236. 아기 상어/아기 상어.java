import java.util.*;
import java.io.*;

public class Main {
	
	static class Food implements Comparable<Food>{
		int y;
		int x;
		int dist;
		
		public Food(int y, int x, int dist) {
			super();
			this.y = y;
			this.x = x;
			this.dist = dist;
		}

		@Override
		public int compareTo(Food o) {
			if(dist == o.dist) {
				if(y == o.y) {
					return x - o.x; // x도 작은 순
				}
				return y - o.y; // y는 작은 순
			}
			return dist - o.dist; // 거리 작은 순
		}
	}
	
	public static int N;
	public static int[][] arr;
	public static int[][] visited;
	public static PriorityQueue<Food> foodlist;
	public static Queue<int[]> q;
	
	public static int sy, sx;
	public static int[] dy = {1, 0, -1, 0};
	public static int[] dx = {0, 1, 0, -1};
	
	public static int sharkSize = 2;
	public static int time = 0;
	public static int eaten = 0;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		N = Integer.parseInt(br.readLine());
		arr = new int[N][N];
		visited = new int[N][N];
		
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for(int j=0; j<N; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
				if(arr[i][j] == 9) {
					sy = i;
					sx = j;
				}
			}
		}
		
		while(true) {
			arr[sy][sx] = 0;
			bfs(sy, sx);	
			if(foodlist.isEmpty()) break;
			else move();
		}
		
		System.out.println(time);
	}


	private static void move() {
		// 첫 원소 꺼내기
		Food front = foodlist.poll();
		
		// 시간에 이동하는 데 걸리는 시간 추가하기
		time += front.dist;
		eaten++;
		
		// sharkSize 다시 만들기
		if(sharkSize == eaten) {
			sharkSize++;
			eaten = 0;
		}
		
		// 상어 이동시키기
		sy = front.y;
		sx = front.x;
	}


	private static void bfs(int sy, int sx) {
		Queue<int[]> q = new LinkedList<>();
		foodlist = new PriorityQueue<>();
		visited = new int[N][N];
		q.offer(new int[] {sy, sx});
		
		boolean flag = false;
		while(!q.isEmpty()) {
			int[] front = q.poll();
			int y = front[0];
			int x = front[1];
			
			for(int i=0; i<4; i++) {
				int ny = y + dy[i];
				int nx = x + dx[i];
				
				if(ny < 0 || ny >= N || nx < 0 || nx >= N) continue;
				if(visited[ny][nx] == 0 && arr[ny][nx] <= sharkSize) {
					visited[ny][nx] = visited[y][x] + 1;
					q.offer(new int[] {ny, nx});
					if(arr[ny][nx] != 0 && arr[ny][nx] < sharkSize) {
						foodlist.add(new Food(ny, nx, visited[ny][nx]));
					}
				}
			}
		}
	}
}
