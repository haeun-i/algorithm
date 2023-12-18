import java.util.*;
import java.io.*;

public class Main {

	public static int[][] dp;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		//StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		char[] s1 = br.readLine().toCharArray();
		char[] s2 = br.readLine().toCharArray();
		
		int n1 = s1.length;
		int n2 = s2.length;
		dp = new int[n1+1][n2+1];
		
		for(int i=1; i<=n1; i++) {
			for(int j=1; j<=n2; j++) {
				if(s1[i-1] == s2[j-1]) dp[i][j] = dp[i-1][j-1] + 1;
				else dp[i][j] = Math.max(dp[i-1][j], dp[i][j-1]);
			}
		}
		
		System.out.println(dp[n1][n2]);
	}
}
