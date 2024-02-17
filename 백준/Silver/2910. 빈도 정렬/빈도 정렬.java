import java.io.*;
import java.util.*;

public class Main {
	
	static int N, C;
	
	static class Node implements Comparable<Node>{
		
		int num;
		int cnt;
		int order;
		
		Node(int num, int cnt, int order){
			this.num = num;
			this.cnt = cnt;
			this.order = order;
		}
		
		@Override
		public int compareTo(Node n) {
			if(n.cnt == this.cnt) {
				return this.order - n.order;
			}
			return n.cnt - this.cnt;
		}
	}
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int N = Integer.parseInt(st.nextToken());
		int C = Integer.parseInt(st.nextToken());
		
		HashMap<Integer, Integer> m = new HashMap<>();
		HashMap<Integer, Integer> order = new HashMap<>();
		
		st = new StringTokenizer(br.readLine(), " ");
		for(int i=0; i<N; i++) {
			int tmp = Integer.parseInt(st.nextToken());
			if(m.containsKey(tmp)) {
				m.put(tmp, m.get(tmp)+1);
			}else {
				m.put(tmp, 1);
				order.put(tmp, order.size()+1);
			}
		}
		
		List<Node> list = new ArrayList<>();
		for(Integer i : m.keySet()) {
			list.add(new Node(i, m.get(i), order.get(i)));
			//System.out.println(i + " " + m.get(i)+ " " + order.get(i));
		}
		Collections.sort(list);
		
		for(Node n : list) {
			for(int i=0; i<n.cnt; i++) {
				System.out.print(n.num + " ");
			}
		}
		
	}
}
