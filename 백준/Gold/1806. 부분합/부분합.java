import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		int[] arr = new int[N+2];
		
		st = new StringTokenizer(br.readLine(), " ");
		for(int i=0; i<N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		int l = 0;
		int r = 0;
		int res = Integer.MAX_VALUE;
		
		long sum = arr[0];
		while(r <= N) {
			if(sum < K) {
				r++;
				sum += arr[r];
			}else {
				res = Math.min(res, r-l+1);
				sum -= arr[l];
				l++;
				
			}
		}
		
		if (res == Integer.MAX_VALUE) System.out.println(0);
        else System.out.println(res);
	}
}