import java.io.*;
import java.util.*;

public class Main {
	
	static int[][] arr;
	static int[][] copied;
	static int n, m; // n은 세로 m은 가로
	
	static int[] dy = {1, 0, -1, 0};
	static int[] dx = {0, 1, 0, -1};
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		arr = new int[n][m];
		
		for(int i=0; i<n; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for(int j=0; j<m; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		int res = 1;
		// 바깥 공기는 2로 취급한다.
		colorTo2(0, 0);
		findc();
		while(check() == false) {
			colorTo2(0, 0);
			findc();
			colorTo0();
			colorTo2(0, 0);
			findc();
			res++;
		}
		
		int cnt = 0;
		for(int i=0; i<n; i++) {
			for(int j=0; j<m; j++) {
				if(arr[i][j] == 3) cnt++;
			}
		}
		
		System.out.println(res);
		System.out.println(cnt);
		
	}
	
	private static void colorTo2(int y, int x) {
		arr[y][x] = 2;
		
		for(int i=0; i<4; i++) {
			int ny = y + dy[i];
			int nx = x + dx[i];
			
			if(ny<0 || ny >= n || nx < 0 || nx >= m) continue;
			if(arr[ny][nx] == 0) colorTo2(ny, nx);
		}
	}
	
	private static void colorTo0() {
		for(int i=0; i<n; i++) {
			for(int j=0; j<m; j++) {
				if(arr[i][j] == 2 || arr[i][j] == 3) arr[i][j] = 0;
			}
		}
	}
	
	private static void findc() {
		for(int i=0; i<n; i++) {
			for(int j=0; j<m; j++) {
				if(arr[i][j] == 1) {
					
					for(int k=0; k<4; k++) {
						int ny = i + dy[k];
						int nx = j + dx[k];
						
						if(ny<0 || ny >= n || nx < 0 || nx >= m) continue;
						if(arr[ny][nx] == 2) {
							arr[i][j] = 3;
							break;
						}
					}
				}
			}
		}
	}
	

	public static boolean check() {
		for(int i=0; i<n; i++) {
			for(int j=0; j<m; j++) {
				if(arr[i][j] == 1) return false;
			}
		}
		return true;
	}
}
