import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int T = Integer.parseInt(br.readLine());
		
		for(int tc=1; tc<=T; tc++) {
			
			st = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(st.nextToken());
			int K = Integer.parseInt(st.nextToken());
			
			int[] weight = new int[N+1];
			int[] value = new int[N+1];
			int[][] dp = new int[N+1][K+1];
			
			for(int i=1; i<=N; i++) {
				st = new StringTokenizer(br.readLine());
				weight[i] = Integer.parseInt(st.nextToken());
				value[i] = Integer.parseInt(st.nextToken());
			}
			
			for(int i=1; i<=N; i++) { // 모든 물건을 봤을 때
				
				for(int j=1; j<=K; j++) { // 무게가 이럴 때
					if(j-weight[i] >= 0) { // 무게를 넣을 수 있는 경우
							dp[i][j] = Math.max(dp[i-1][j], dp[i-1][j-weight[i]] + value[i]);
					}else dp[i][j] = dp[i-1][j];
				}
			}
			
			System.out.println("#" + tc + " " + dp[N][K]);
		}
	}
}