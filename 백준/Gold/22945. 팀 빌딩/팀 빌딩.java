import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		int[] arr = new int[N];
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i=0; i<N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		
		int res = 0;
		int start = 0;
		int end = N-1;
		while(start <= end) {
			
			int tmp = Math.min(arr[start], arr[end]) * (end-start-1);
			res = Math.max(res, tmp);
			
			if(arr[start] < arr[end]) start++;
			else end--;
		}
		
		System.out.println(res);
	}
}