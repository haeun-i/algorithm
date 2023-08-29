import java.util.*;
import java.io.*;

public class Main {
	public static int[][] arr;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		arr = new int[15][15];
		
		for(int i=0; i<=14; i++) {
			arr[0][i] = i;
		}
		
		for(int i=1; i<=14; i++) {
			for(int j=1; j<=14; j++) {
				if(j==1) arr[i][j] = arr[i-1][j];
				else arr[i][j] = arr[i][j-1] + arr[i-1][j];
			}
		}
		
		
		
		for(int tc=0; tc<T; tc++) {
			int K = sc.nextInt();
			int N = sc.nextInt();
			
			System.out.println(arr[K][N]);
		}
	}
}
