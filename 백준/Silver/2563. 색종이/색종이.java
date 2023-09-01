import java.util.*;
import java.io.*;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int t = Integer.parseInt(br.readLine());
		
		int[][] arr =  new int[100][100];
		for(int i=0; i<t; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			int n1 = Integer.parseInt(st.nextToken());
			int n2 = Integer.parseInt(st.nextToken());
			
			for(int j=n2; j<n2+10; j++) {
				for(int k=n1; k<n1+10; k++) {
					arr[j][k] = 1;
				}
			}
			
		}
		
		int cnt = 0;
		for(int i=0; i<100; i++) {
			for(int j=0; j<100; j++) {
				if(arr[i][j] != 0) cnt++;
			}
		}
	
		System.out.println(cnt);
		
	}
}
