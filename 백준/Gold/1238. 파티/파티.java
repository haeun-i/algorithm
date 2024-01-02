import java.util.*;
import java.io.*;

public class Main {
	
	public static class Node implements Comparable<Node>{
		
		int dist;
		int num;
		
		Node(int num, int dist){
			this.num = num;
			this.dist = dist;
		}

		@Override
		public int compareTo(Node o) {
			return this.dist - o.dist;
		}
	}
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int X = Integer.parseInt(st.nextToken());
		
		int[][] dist_go = new int[N+1][N+1];
		List<Node>[] list_go = new List[N+1];
		int[] dist_back = new int[N+1];
		List<Node>[] list_back = new List[N+1];
		
		for(int i=1; i<=N; i++) {
			for(int j=1;j<=N; j++) {
				dist_go[i][j] = Integer.MAX_VALUE;
			}
			dist_back[i] = Integer.MAX_VALUE;
			
			list_go[i] = new ArrayList<>();
			list_back[i] = new ArrayList<>();
		}
		
		for(int i=0; i<M; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			int u = Integer.parseInt(st.nextToken());
			int v = Integer.parseInt(st.nextToken());
			int w = Integer.parseInt(st.nextToken());
			
			list_go[u].add(new Node(v, w));
			list_back[u].add(new Node(v, w));
		}
		
		// X지점에서 각 지점까지 최단거리 계산
		PriorityQueue<Node> pq = new PriorityQueue<>();
		pq.add(new Node(X, 0));
		dist_back[X] = 0;
		while(!pq.isEmpty()) {
			Node tmp = pq.poll();
			for(int i=0; i<list_back[tmp.num].size(); i++) {
				Node next = list_back[tmp.num].get(i);
				
				if(dist_back[next.num] > dist_back[tmp.num] + next.dist) {
					dist_back[next.num] = dist_back[tmp.num] + next.dist;
					pq.add(new Node(next.num, dist_back[next.num]));
				}
			}
		}
		
		//각 지점에서 X까지의 거리
		for(int i=1; i<=N; i++) {
			pq = new PriorityQueue<>();
			pq.add(new Node(i, 0));
			dist_go[i][i] = 0;
			
			while(!pq.isEmpty()) {
				Node tmp = pq.poll();
				for(int j=0; j<list_go[tmp.num].size(); j++) {
					Node next = list_go[tmp.num].get(j);
					
					if(dist_go[i][next.num] > dist_go[i][tmp.num] + next.dist) {
						dist_go[i][next.num] = dist_go[i][tmp.num] + next.dist;
						pq.add(new Node(next.num, dist_go[i][next.num]));
					}
				}
			}
		}
		
		int res = 0;
		for(int i=1; i<=N; i++) {
			//System.out.println(dist_go[i][X] + " " + dist_back[i]);
			res = Math.max(res, dist_go[i][X] + dist_back[i]);
		}
		System.out.println(res);
	}
}