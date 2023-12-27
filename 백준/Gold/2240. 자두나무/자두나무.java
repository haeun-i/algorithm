import java.util.*;
import java.io.*;

public class Main {
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int T = Integer.parseInt(st.nextToken());
		int W = Integer.parseInt(st.nextToken());
		
		int[][][] dp = new int[1001][32][3]; // T초에 W번 바꿔서 위치가 어디인지
		
		
		for(int i=1; i<=T; i++) {
			int num = Integer.parseInt(br.readLine())-1; // 입력받는 위치
			
			for(int j=1; j<=W+1; j++) {
				if(num == 0) { // 1번 위치에 떨어진다
					dp[i][j][1] = Math.max(dp[i-1][j][1], dp[i-1][j-1][2]) + 1;
					dp[i][j][2] = Math.max(dp[i-1][j-1][1], dp[i-1][j][2]);
				}else { // 자리를 바꿔야 된다
					if (i == 1 && j == 1) continue; //첫 1초에서 2번 자두는 먹을 수 없다
					dp[i][j][1] = Math.max(dp[i-1][j][1], dp[i-1][j-1][2]);
					dp[i][j][2] = Math.max(dp[i-1][j-1][1], dp[i-1][j][2])+1;
				}
			}
		}
		
		int max = 0;
		for(int i=1; i<=W+1; i++) {
			for(int j=1; j<=2; j++) {
				max = Math.max(max, dp[T][i][j]);
			}
		}
		
		System.out.println(max);

	}
}