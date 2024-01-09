import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	
	static int N;
	static int[][] arr;
	
	static int cnt1 = 0; // -1
	static int cnt2 = 0; // 0
	static int cnt3 = 0; // 1
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		arr = new int[N][N];
		
		for(int i=0; i<N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			for(int j=0; j<N; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		find(0, 0, N);
		System.out.println(cnt1);
		System.out.println(cnt2);
		System.out.println(cnt3);
	}

	private static void find(int y, int x, int size) {
		int num = arr[y][x]; // 채워져야 하는 수
		
		if(size == 1) { // 마지막 케이스
			if(num == -1) cnt1++;
			else if(num == 0) cnt2++;
			else if(num == 1) cnt3++;
			return;
		}
		
		boolean flag = true;
		for(int i=y; i<y+size; i++) {
			for(int j=x; j<x+size; j++) {
				if(arr[i][j] != num) flag = false;
			}
		}
		
		if(flag == true) { // 모두 같은 수인 경우
			if(num == -1) cnt1++;
			else if(num == 0) cnt2++;
			else if(num == 1) cnt3++;
		}else {
			find(y, x, size/3);
			find(y+size/3, x, size/3);
			find(y+((size*2)/3), x, size/3);
			
			find(y, x+size/3, size/3);
			find(y+size/3, x+size/3, size/3);
			find(y+((size*2)/3), x+size/3, size/3);
			
			find(y, x+((size*2)/3), size/3);
			find(y+size/3, x+((size*2)/3), size/3);
			find(y+((size*2)/3), x+((size*2)/3), size/3);
		}
	}
}