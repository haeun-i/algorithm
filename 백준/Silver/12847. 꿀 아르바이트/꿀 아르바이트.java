import java.util.*;
import java.io.*;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		
		st = new StringTokenizer(br.readLine(), " ");
		int[] arr = new int[n];
		for(int i=0; i<n; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		long sum = 0;
		for(int i=0; i<m; i++) {
			sum += arr[i];
		}
		long max = sum; // 초깃값
		
		for(int i=0; i+m<n; i++) { //i가 cursor 역할을 한다.
			sum -= arr[i];
			sum += arr[i+m];
			max = Math.max(max, sum);
		}
		
		System.out.println(max);
	}
}
