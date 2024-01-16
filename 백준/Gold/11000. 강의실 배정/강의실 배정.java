import java.io.*;
import java.util.*;

public class Main {
	
	public static class Node implements Comparable<Node>{
		int start;
		int end;
		
		Node(int start, int end){
			this.start = start;
			this.end = end;
		}
		
		@Override
		public int compareTo(Node n) {
			if(n.start == this.start) {
				return this.end - n.end;
			}
			return this.start - n.start;
		}
	}
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		List<Node> nodeList = new ArrayList<>();
		int N = Integer.parseInt(br.readLine());
		StringTokenizer st;
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			int start = Integer.parseInt(st.nextToken());
			int end = Integer.parseInt(st.nextToken());
			
			nodeList.add(new Node(start, end));
		}
		
		Collections.sort(nodeList);
		
		PriorityQueue<Integer> pq = new PriorityQueue<>();
		pq.add(nodeList.get(0).end);
		for(int i=1; i<N; i++) {
			Node tmp = nodeList.get(i);
			int num = pq.poll();
			
			if(tmp.start < num) {
				pq.add(num);
				pq.add(tmp.end);
			}else pq.add(tmp.end);
		}
		
		System.out.println(pq.size());
	}
}