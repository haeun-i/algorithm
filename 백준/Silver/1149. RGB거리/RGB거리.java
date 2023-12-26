import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	 public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		
		int N = Integer.parseInt(br.readLine());
		int[][] arr = new int[1001][3];
		int[][] dp = new int[1001][3];
		
		for(int i=0; i<N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			arr[i+1][0] = Integer.parseInt(st.nextToken()); 
			arr[i+1][1] = Integer.parseInt(st.nextToken()); 
			arr[i+1][2] = Integer.parseInt(st.nextToken()); 
		}
		
		// 초기화
		for(int i=0; i<3; i++) {
			dp[1][i] = arr[1][i];
		} 
		 
		for(int i=2; i<=N; i++) {
			dp[i][0] = Math.min(dp[i-1][1], dp[i-1][2]) + arr[i][0];
			dp[i][1] = Math.min(dp[i-1][0], dp[i-1][2]) + arr[i][1];
			dp[i][2] = Math.min(dp[i-1][0], dp[i-1][1]) + arr[i][2];
		}	
		
		int res = Math.min(Math.min(dp[N][0], dp[N][1]), dp[N][2]);
		System.out.println(res);
	 }
}