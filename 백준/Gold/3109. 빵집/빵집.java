import java.io.*;
import java.util.*;

public class Main {

	public static int R;
	public static int C;
	public static char[][] arr;
	public static boolean[][] visited;
	public static int[] dy = {-1, 0, 1};
	public static int[] dx = {1, 1, 1};
	public static int cnt = 0;
	public static boolean flag = true;
	
	public static void main(String[] args) throws Exception {

		Scanner sc = new Scanner(System.in);
		R = sc.nextInt();
		C = sc.nextInt();
		arr = new char[R][C];
		visited = new boolean[R][C];
		
		for(int i=0; i<R; i++) {
			String tmp = sc.next();
			for(int j=0; j<C; j++) {
				arr[i] = tmp.toCharArray();
			}
		}
	
		for(int i=0; i<R; i++) {
			if(dfs(i, 0) == true) cnt++;	
		}
		
		System.out.println(cnt);
	}

	private static boolean dfs(int i, int j) {

		if(j==C-1) {
			return true;
			
		}
		
		for(int k=0; k<3; k++) {
			int ny = i + dy[k];
			int nx = j + dx[k];
			
			if(check(ny, nx) == true && arr[ny][nx] != 'x' && visited[ny][nx] == false) {
				visited[ny][nx] = true;
				if(dfs(ny, nx) == true) return true;
			}
		}
	
		return false;
	}
	
	public static boolean check(int i, int j) {
		if(i < 0 || i >= R || j<0 || j>=C) return false;
		return true;
	}

}
