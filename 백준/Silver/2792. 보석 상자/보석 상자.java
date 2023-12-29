import java.util.*;
import java.io.*;

public class Main {
	
	static long N;
	static int M;;
	static long[] arr;
	static long max = 0;
	static long res = -1;
	
	public static void main(String[] args) throws Exception{
		Scanner sc = new Scanner(System.in);
		N = sc.nextLong();
		M = sc.nextInt();
		arr = new long[M];
		
		for(int i=0; i<M; i++) {
			arr[i] = sc.nextInt();
			max = Math.max(max, arr[i]);
		}
		search();
		System.out.println(res);
	}
	
	public static void search() {
		long start = 1;
		long end = max;
		
		while(start <= end) {
			long mid = (start + end)/2;
			long tmp = 0;
			for(int i=0; i<M; i++) {
				tmp += arr[i]/mid;
				if(arr[i]%mid != 0) tmp++;  
			}
			
			if(tmp <= N) {
				end = mid-1;
				res = mid;
			}
			else start = mid+1;
		}
	}
}