import java.io.*;
import java.util.*;

public class Main {
	
	static int N;
	static int[][] color;
	static int[][] arr;
	
	public static void main(String[] args) throws Exception {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		N = Integer.parseInt(br.readLine());
		color = new int[N][3];
		arr = new int[N][3];
		
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for(int j=0; j<3; j++) {
				color[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		for(int i=0; i<3; i++) {
			arr[0][i] = color[0][i];
		}
		
		for(int i=1; i<N; i++) {
			for(int j=0; j<3; j++) {
				if(j==0) arr[i][j] = Math.min(arr[i-1][1], arr[i-1][2]) + color[i][j];
				else if(j==1) arr[i][j] = Math.min(arr[i-1][0], arr[i-1][2]) + color[i][j];
				else if(j==2) arr[i][j] = Math.min(arr[i-1][1], arr[i-1][0]) + color[i][j];
			}
		}
		
		System.out.println(Math.min(Math.min(arr[N-1][0], arr[N-1][1]), arr[N-1][2]));
		
		
	}
}
