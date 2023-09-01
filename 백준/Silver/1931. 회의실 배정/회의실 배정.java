import java.util.*;
import java.io.*;

public class Main {
    
	static List<int[]> list = new LinkedList<int[]>();
    public static void main(String[] args) throws Exception {
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	StringTokenizer st;
    	
    	int N = Integer.parseInt(br.readLine());
    	for(int i=0; i<N; i++) {
    		st = new StringTokenizer(br.readLine(), " ");
    		int n1 = Integer.parseInt(st.nextToken());
    		int n2 = Integer.parseInt(st.nextToken());
    		
    		list.add(new int[]{n1, n2});
    	}
    	
    	Collections.sort(list, Comparator.comparing((int[] arr) -> arr[1]).thenComparing(arr -> arr[0]));
    	
    	int cnt = 0;
    	int end = 0;
    	for(int[] m : list) {
    		if(m[0] >= end) {
    			end = m[1];
    			cnt++;
    		}
    	}
    	
    	System.out.println(cnt);
    }
}