import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

	static int N, M;
	static int[] arr;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		arr = new int[N];
		
		st = new StringTokenizer(br.readLine());
		for(int i=0; i<N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		Arrays.sort(arr);
		int start = 0;
		int end = 1000000000;
		int res = 0;
		
		while(start <= end) {
			int mid = (start+end)/2;
			
			long sum = 0;
			for(int i=0; i<N; i++) {
				if(arr[i] > mid) sum += arr[i]-mid;
			}
			
			if(sum < M) end = mid-1;
			else {
				res = Math.max(res, mid);
				start = mid+1;
			}
		}
		
		System.out.println(res);
		
	}
}