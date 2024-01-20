import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception {
    	
    	Scanner sc = new Scanner(System.in);
    	int N = sc.nextInt();
    	long[] arr = new long[N];
    	
    	for(int i=0; i<N; i++) {
    		arr[i] = sc.nextLong();
    	}
    	
    	Arrays.sort(arr);
    	long M = 0;
    	
    	if(N%2==1) {
    		M = arr[N-1];
    		for(int i=0; i<N/2; i++) {
    			M = Math.max(M, arr[i] + arr[N-i-2]);
    		}
    	}else {
    		for(int i=0; i<N/2; i++) {
    			M = Math.max(M, arr[i] + arr[N-i-1]);
    		}
    	}
    	
    	System.out.println(M);
    }
}