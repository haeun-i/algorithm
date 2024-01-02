import java.util.*;
import java.io.*;

public class Main {
	
	public static class Node implements Comparable<Node>{
		
		int num;
		int dist;

		Node(int num, int dist){
			this.num = num;
			this.dist = dist;
		}
		
		@Override
		public int compareTo(Node o){
			return this.dist - o.dist;
		}
	}
	
	static int V, E;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		V = Integer.parseInt(st.nextToken());
		E = Integer.parseInt(st.nextToken());
		
		int[] dist = new int[V+1];
		List<Node>[] list = new List[V+1];
		
		for(int i=1; i<=V; i++) {
			dist[i] = Integer.MAX_VALUE;
			list[i] = new ArrayList<>();
		}
		
		int K = Integer.parseInt(br.readLine());
		for(int i=0; i<E; i++){
			st = new StringTokenizer(br.readLine(), " ");
			int u = Integer.parseInt(st.nextToken());
			int v = Integer.parseInt(st.nextToken());
			int w = Integer.parseInt(st.nextToken());
			
			list[u].add(new Node(v, w));
			//list[v].add(new Node(u, w));
		}
		
		PriorityQueue<Node> pq = new PriorityQueue<>();
		pq.add(new Node(K, 0));
		dist[K] = 0;
		
		while(!pq.isEmpty()) {
			Node tmp = pq.poll();
			for(int i=0; i<list[tmp.num].size(); i++) {
				Node to = list[tmp.num].get(i);
				if(dist[to.num] > dist[tmp.num] + to.dist) {
					dist[to.num] = dist[tmp.num] + to.dist;
					pq.add(new Node(to.num, dist[to.num]));
				}
			}
		}
		
		for(int i=1; i<=V; i++) {
			if(dist[i] == Integer.MAX_VALUE) System.out.println("INF");
			else System.out.println(dist[i]);
		}
		System.out.println();
	}
}