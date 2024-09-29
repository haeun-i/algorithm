import java.util.*;
import java.io.*;

public class Main {
	
	static int N;
	static PriorityQueue<Integer> pq;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		pq = new PriorityQueue<>();
		
		for(int i=0; i<N; i++) {
			int x = Integer.parseInt(br.readLine());
			if(x == 0) {
				if(pq.size() == 0) System.out.println(0);
				else {
					System.out.println(pq.poll());
				}
			}else {
				pq.offer(x);
			}
		}
	}
}