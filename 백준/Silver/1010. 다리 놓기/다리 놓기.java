import java.util.*;
import java.io.*;

public class Main {
	static int[][] arr;
	static int T;
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		T = sc.nextInt();
		arr = new int[30][30];
		
		for(int i=1; i<30; i++) {
			for(int j=0; j<=i; j++) {
				if(j == 0 || j==i) arr[i][j] = 1;
				else arr[i][j] = arr[i-1][j-1] + arr[i-1][j];
			}
		}
		
		for(int tc=0; tc<T; tc++) {
			int N = sc.nextInt();
			int M = sc.nextInt();
			System.out.println(arr[M][N]);
		}
	}
}
