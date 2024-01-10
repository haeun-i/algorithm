import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	
	static int N, M;
	static int[] arr;
	static int max;
	static int s, e=0;
	static int res = 0;
	
	static void find() {
		s = 0;
		while(s <= e) {
			int mid = (s+e)/2;
			int tmp = 0;
			for(int i=0; i<N; i++) {
				if(arr[i] <= mid) tmp += arr[i];
				else tmp += mid;
			}

			if(tmp > max) e = mid-1;
			else {
				s = mid+1;					
				res = Math.max(res, mid);
			}
		}
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		arr = new int[N];
		
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		for(int i=0; i<N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
			e = Math.max(arr[i], e);
		}
		
		max = Integer.parseInt(br.readLine());
		find();
		System.out.println(res);
	}
}