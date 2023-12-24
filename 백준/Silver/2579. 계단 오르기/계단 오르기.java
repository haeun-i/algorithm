import java.util.*;

public class Main {
	 public static void main(String[] args) throws Exception {

		 Scanner sc = new Scanner(System.in);
		 int N = sc.nextInt();
		 
		 int[] dp = new int[301];
		 int[] arr = new int[301];
		 
		 for(int i=1; i<=N; i++) {
			arr[i] = sc.nextInt();
		 }
		 
		 dp[1] = arr[1];
		 dp[2] = arr[1] + arr[2];
		 for(int i=3; i<=N; i++) {
			 dp[i] += Math.max(dp[i-3]+arr[i-1], dp[i-2]) + arr[i];
		 }
		 
		System.out.println(dp[N]);
	 }
}