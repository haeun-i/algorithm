import java.util.*;
import java.io.*;

public class Main {
	
	static int N;
	static int[] arr;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		arr = new int[N];
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i=0; i<N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		Arrays.sort(arr);
	
		// index로 투포인터 실행
		int start = 0;
		int end = N-1;
		
		int ans_start = 0;
		int ans_end = N-1;
		int min = Integer.MAX_VALUE;
		
		while(start < end) {
			int sum = arr[start] + arr[end];
			
			if(Math.abs(min) > Math.abs(sum)) {
				// 0과 좀 더 가까운 경우
				min = sum;
				ans_start = start;
				ans_end = end;
			}
			
			if(sum == 0) break;
			else if(sum > 0) end--;
			else start++;
		}
		
		System.out.println(arr[ans_start] + " " + arr[ans_end]);
		
	}
}