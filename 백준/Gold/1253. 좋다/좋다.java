import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class Main {
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));	
		int N = Integer.parseInt(br.readLine());
		int[] arr = new int[N];
		Set<Integer> s = new HashSet<>();
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i=0; i<N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		Arrays.sort(arr);
		int res = 0;
		
		for(int i=0; i<N; i++) {
			int sum = arr[i]; // 찾아야 하는 것
	
			int start = 0;
			int end = N-1;
			
			while(start < end) {
				
				if(start == i) start++;
				else if(end == i) end--;
	
				if(start != end) {
					if(arr[start] + arr[end] < sum) {
						start++;
					}else if(arr[start] + arr[end] > sum) {
						end--;
					}else {
						//System.out.println(arr[i]);
						res++;
						break;
					}
				}
			
			}
			
		}
		
		System.out.println(res);
	}
}