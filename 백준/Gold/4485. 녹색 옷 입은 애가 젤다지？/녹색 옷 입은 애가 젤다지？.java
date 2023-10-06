import java.util.*;
import java.io.*;

public class Main {
	
	public static int[] dy = {0, 1, 0, -1};
	public static int[] dx = {1, 0, -1, 0};

	public static class Node implements Comparable<Node>{
		int r;
		int c;
		int dist;
		
		public Node(int r, int c, int dist) {
			super();
			this.r = r;
			this.c = c;
			this.dist = dist;
		}
		
		@Override
		public int compareTo(Node o) {
			return this.dist - o.dist;
		}
	}
	
	public static int[][] arr;
	public static int[][] dist;
	public static PriorityQueue<Node> queue;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int tc = 0;
		int N = Integer.parseInt(br.readLine());
		while(N != 0) {
			tc++;
			queue = new PriorityQueue<>();
			arr = new int[N][N];
			dist = new int[N][N];
			
			for(int i=0; i<N; i++) {
				for(int j=0; j<N; j++) {
					dist[i][j] = Integer.MAX_VALUE;
				}
			}
			
			for(int i=0; i<N; i++) {
				st = new StringTokenizer(br.readLine(), " ");
				for(int j=0; j<N; j++) {
					arr[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			
			queue.add(new Node(0, 0, arr[0][0]));
			dist[0][0] = arr[0][0];
			while(!queue.isEmpty()) {
				Node tmp = queue.poll();
				
				for(int i=0; i<4; i++) {
					int ny = tmp.r + dy[i];
					int nx = tmp.c + dx[i];
					
					if(ny < 0 || ny >= N || nx < 0 || nx >= N) continue;
					if(dist[ny][nx] > dist[tmp.r][tmp.c] + arr[ny][nx]) {
						dist[ny][nx] = dist[tmp.r][tmp.c] + arr[ny][nx];
						queue.add(new Node(ny, nx, dist[ny][nx]));
					}
				}
			}
			
			System.out.println("Problem " + tc +": " + dist[N-1][N-1]);
			N = Integer.parseInt(br.readLine());
				
		}
	}
}