import java.io.*;
import java.util.*;

public class Main {
	
	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
	
		int n, k;
		n = Integer.parseInt(st.nextToken());
		k = Integer.parseInt(st.nextToken());
		
		int[] arr = new int[n];
		
		int[] dp = new int[k+1];
		
		for(int i=0; i<n; i++) {
			int num = Integer.parseInt(br.readLine());
			arr[i] = num;
		}
		
		dp[0] = 1;
		for(int i=0; i<n; i++) {
			for(int j=1; j<=k; j++) {
				if(j-arr[i] >=0) {
					dp[j] += dp[j-arr[i]];
				}
			}
		}
		
		System.out.println(dp[k]);
	}
}