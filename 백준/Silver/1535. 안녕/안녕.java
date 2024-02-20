import java.util.*;
import java.io.*;

public class Main {
	
	static int N;
	static int[] positive;
	static int[] negative;
	static int[][] dp;
	
	public static void main(String[] args) throws Exception {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		positive = new int[N+1];
		negative = new int[N+1];
		dp = new int[101][N+1];
		
		for(int i=1; i<=N; i++) {
			negative[i] = sc.nextInt();
		}
		for(int i=1; i<=N; i++) {
			positive[i] = sc.nextInt();
		}
		
		for(int i=1; i<101; i++) { 
            for(int j=1; j<=N; j++) { 
                if(i > negative[j]) { 
                    dp[i][j] = Math.max(dp[i][j-1] , dp[i-negative[j]][j-1] + positive[j]);
                }
                else {
                    dp[i][j] = dp[i][j-1];
                }
            }
        }

        System.out.println(dp[100][N]);
	}
}
