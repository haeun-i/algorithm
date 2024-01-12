import java.util.*;

public class Main {
	
	static int N;
	public static void main(String[] args) throws Exception {
		
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		long[][] arr = new long[1003][10]; // 자릿수와 맨 뒷자리 수
		
		for(int i=0; i<10; i++) {
			arr[1][i] = 1;
		}
		
		for(int i=2; i<1003; i++) {
			for(int j=9; j>=0; j--) {
				for(int k=j; k<=9; k++) {
					arr[i][j] += arr[i-1][k];
					arr[i][j] %= 10007;
				}
			}
		}
		
		int res = 0;
		for(int j=0; j<10; j++) {
			res = (int) ((res + arr[N][j])%10007);
		}
		System.out.println(res);
		
	}
}