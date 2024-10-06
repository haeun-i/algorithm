import java.util.*;

public class Main {
	
	static int K, N;
	static long[] arr;
	public static void main(String[] args) {
		
        Scanner sc = new Scanner(System.in);
		K = sc.nextInt();
		N = sc.nextInt();
		arr = new long[K];
		
		long min = 0;
        long max = 0;
        
		for(int i=0; i<K; i++) {
			arr[i] = sc.nextLong();
			if(max < arr[i]) {
				max = arr[i];
			}
		}
        max++;
		
		long answer = 0;
		while(min < max) {
			long mid = (min+max)/2;
			
			long tmp = 0;
			for(int i=0; i<K; i++) {
				tmp += arr[i]/mid;
			}
			
			if(tmp < N) {
				max = mid;
			}
			else {
				min = mid+1;
			}
		}
		
		System.out.println(min-1);
	}
}