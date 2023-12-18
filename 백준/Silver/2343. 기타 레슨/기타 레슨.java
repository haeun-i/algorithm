import java.util.*;
import java.io.*;

public class Main {

	public static int N, M;
	public static int max = 0;
	public static int[] arr;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		arr = new int[N];

		st = new StringTokenizer(br.readLine(), " ");
		for(int i=0; i<N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
			max += arr[i];
		}
		search();
		
		
	}

	private static void search() {
		int start = 0;
		int end = max;
		
		
		while(start <= end) { // 이분탐색
			int mid = (start+end)/2; 
			int cnt = 0; // 블루레이 갯수
			int tmp = 0;
			boolean flag = true;
			
			for(int i=0; i<N; i++) { // 돌면서 확인
				if (mid < arr[i]) {
					flag = false;
					break;
				}
				
				if(tmp + arr[i] > mid) {
					cnt++;
					tmp = arr[i];
				}else {
					tmp += arr[i];
				}				
			}
			if(tmp != 0) cnt++;

			if(!flag || cnt > M) start = mid+1;
			else end = mid-1;
		}
		
		System.out.println(start);
	}
}
