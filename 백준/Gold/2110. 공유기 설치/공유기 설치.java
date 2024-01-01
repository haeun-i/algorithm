import java.util.*;
import java.io.*;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		
		int N = Integer.parseInt(st.nextToken());
		int C = Integer.parseInt(st.nextToken());
		int[] arr = new int[N+1];
		int max = 0;
		
		for(int i=1; i<=N; i++) {
			arr[i] = Integer.parseInt(br.readLine());
			max = Math.max(max, arr[i]);
		}
		Arrays.sort(arr);
		
		int start = 1;
		int end = max;
		int res = -1;
		
		while(start <= end) {
			int mid = (start+end)/2; // 가장 인접한 점의 거리로 적절한 것
			
			int cnt = 1;
			int prev = arr[1];
			
			for(int i=2; i<=N; i++) {
				if(arr[i] - prev >= mid) {
					cnt++;
					prev = arr[i];
				}
			}
			
			if(cnt >= C) {
				res = Math.max(res, mid);
				start = mid+1;
			}else if(cnt < C) {
				end = mid-1;
			}
			
		}
		
		System.out.println(res);
	}
}