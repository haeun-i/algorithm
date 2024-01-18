import java.util.*;
import java.io.*;

public class Main {
	
	static int N, K;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		double[] arr = new double[N];
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i=0; i<N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		Arrays.sort(arr);
		double sum = 0;
		
		for(int i=0; i<N-1; i++) {
			sum += arr[i]/2;
		}
		
		arr[N-1] += sum;
		if((int)arr[N-1] == arr[N-1]) System.out.println((int)arr[N-1]);
		else System.out.println(arr[N-1]);
		
	}
}
