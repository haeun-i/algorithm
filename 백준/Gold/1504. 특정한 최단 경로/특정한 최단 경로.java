import java.util.*;
import java.io.*;

public class Main {
	
	public static int N, E;
	public static int[] visited;
	public static int[] dist;
	public static List<Node>[] graph;
	
	public static long res1 = 0;
	public static long res2 = 0;
	
	public static class Node implements Comparable<Node>{

		int a;
		int b;
		int c;
		
		Node(int a, int b, int c){
			this.a = a;
			this.b = b;
			this.c = c;
		}
		
		@Override
		public int compareTo(Node o) {
			return this.c- o.c;
		}
		
	}
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		
		N = Integer.parseInt(st.nextToken());
		E = Integer.parseInt(st.nextToken());
		
		visited = new int[N+1];
		dist = new int[N+1];
		graph = new List[N+1];
		for(int i=0; i<N+1; i++) {
			graph[i] = new ArrayList<>();
			dist[i] = Integer.MAX_VALUE;
		}
		
		for(int i=0; i<E; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			
			graph[a].add(new Node(a, b, c));
			graph[b].add(new Node(b, a, c));
		}
		
		st = new StringTokenizer(br.readLine());
	    int v1 = Integer.parseInt(st.nextToken());
	    int v2 = Integer.parseInt(st.nextToken());
	     
	    res1 += bfs(1, v1);
	    res1 += bfs(v1, v2);
	    res1 += bfs(v2, N);
	 
	    res2 += bfs(1, v2);
	    res2 += bfs(v2, v1);
	    res2 += bfs(v1, N);
		
		if(res1 <= 0 || res2 <= 0) System.out.println(-1);
		else if(res1 >= Integer.MAX_VALUE || res2>=Integer.MAX_VALUE) System.out.println(-1);
		else System.out.println(Math.min(res1, res2));
	}

	private static int bfs(int s, int e) {
		int[] dist = new int[N+1];
		for(int i=0; i<=N; i++) {
			dist[i] = Integer.MAX_VALUE;
		}
		
		PriorityQueue<Node> pq = new PriorityQueue<>();
		pq.add(new Node(0, s, 0)); // 첫 시작점 임의로 설정, 그 후 도착점 s지
		dist[s] = 0;
		
		while(!pq.isEmpty()) {
			Node tmp = pq.poll();
			for(int i=0; i<graph[tmp.b].size(); i++) {
				Node tmp2 = graph[tmp.b].get(i);
				if(dist[tmp2.b] > dist[tmp.b] + tmp2.c) {
					dist[tmp2.b] = dist[tmp.b] + tmp2.c;
					pq.add(new Node(tmp.b, tmp2.b, dist[tmp2.b]));
				}
			}
//			
//			for(int i=0; i<=N; i++) {
//				System.out.print(dist[i] + " ");
//			}
//			System.out.println();
		}
		return dist[e];
	}
}