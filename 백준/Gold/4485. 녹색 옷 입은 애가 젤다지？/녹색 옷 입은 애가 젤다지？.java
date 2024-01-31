import java.util.*;
import java.io.*;

public class Main {
	
	static int[][] cave;
	static int[][] dist;
	static PriorityQueue<Node> pq;
	
	static int[] dy = {0, 1, 0, -1};
	static int[] dx = {1, 0, -1, 0};
	
	public static class Node implements Comparable<Node>{
		int[] dest;
		int dist;
		
		Node(int[] dest, int dist){
			// 위치의 x, y
			this.dest = new int[2];
			this.dest[0] = dest[0];
			this.dest[1] = dest[1];
			
			// 가중치
			this.dist = dist;
		}
		
		@Override
		public int compareTo(Node n) {
			return this.dist - n.dist;
		}
	}
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));	
		int N = Integer.parseInt(br.readLine());
		int tc = 0;
		while(N != 0) {
			tc++;
			cave = new int[N][N];
			dist = new int[N][N];
			
			StringTokenizer st;
			for(int i=0; i<N; i++) {
				st = new StringTokenizer(br.readLine(), " ");
				for(int j=0; j<N; j++) {
					cave[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			
			for(int i=0; i<N; i++) {
				for(int j=0; j<N; j++) { // 최댓값으로 초기화
					dist[i][j] = Integer.MAX_VALUE;
				}
			}
			
			pq = new PriorityQueue<>();
			pq.add(new Node(new int[] {0, 0}, cave[0][0])); // 출발지
			dist[0][0] = cave[0][0];		
			
			while(!pq.isEmpty()) {
				Node node = pq.poll();
				for(int i=0; i<4; i++) {
					// 다음 위치
					int ny = node.dest[0] + dy[i];
					int nx = node.dest[1] + dx[i];
					
					// 넘어가면 불가
					if(ny < 0 || ny >= N || nx < 0 || nx >= N) continue;
					
					if(dist[ny][nx] > node.dist + cave[ny][nx]) {
						dist[ny][nx] = node.dist + cave[ny][nx];
						pq.add(new Node(new int[] {ny, nx}, dist[ny][nx]));
					}
				}
			}
			System.out.println("Problem " + tc + ": " + dist[N-1][N-1]);
			N = Integer.parseInt(br.readLine()); // N 갱신
		}
	}

}
