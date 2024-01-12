import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.*;

public class Main {
	
	static int N;
	static int M;
	
	static class Node implements Comparable<Node>{

		int dest;
		int dist;
		
		Node(int dest, int dist){
			this.dest = dest;
	        this.dist = dist;
		}
		
		@Override
		public int compareTo(Node n) {
			return this.dist - n.dist;
		}
	}
	
	static List<Node>[] list;
	static int[] dist;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		M = Integer.parseInt(br.readLine());
		list = new List[N+1];
		dist = new int[N+1];
		
		for(int i=0; i<N+1; i++) {
			list[i] = new ArrayList<>();
			dist[i] = Integer.MAX_VALUE;
		}
		
		// 연결어딕
		StringTokenizer st;
		for(int i=0; i<M; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int w = Integer.parseInt(st.nextToken());
			list[a].add(new Node(b, w));
		}
		
		st = new StringTokenizer(br.readLine(), " ");
		int start = Integer.parseInt(st.nextToken());
		int end = Integer.parseInt(st.nextToken());
		
		PriorityQueue<Node> pq = new PriorityQueue<>();
		pq.add(new Node(start, 0));
		dist[start] = 0;
		
		while(!pq.isEmpty()) {
			Node tmp = pq.poll();
			if(tmp.dist > dist[tmp.dest]) continue;
			
			for(Node n : list[tmp.dest]) {
				if(dist[n.dest] > dist[tmp.dest] + n.dist) {
					dist[n.dest] = dist[tmp.dest] + n.dist;
					pq.add(new Node(n.dest, dist[n.dest])); // 지금까지의 거리를 노드로 만들어 pq에 저장해야 한다
				}
			}
		}
		
		System.out.println(dist[end]);

		
	}
}