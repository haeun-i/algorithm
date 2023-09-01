
import java.io.*;
import java.util.*;

public class Main {
	static int N, r, c;
	static int cnt = 0;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		r = sc.nextInt();
		c = sc.nextInt();
		
		int n = (int) Math.pow(2, N);
		recur(0, 0, n);
		System.out.println(cnt);
	}
	
	private static void recur(int i, int j, int size) {
		if(size==1) {
			return;
		}
		
		size = size/2;
		if(r < i+size && c < j+size) {
			// 1사분면
			recur(i, j, size);
		}else if(r >= i+size && c < j+size) {
			// 3사분면
			cnt += 2 * (size * size);
			recur(i+size, j, size);
		}else if(r < i+size && c >= j+size) {
			// 2사분면
			cnt += (size * size);
			recur(i, j+size, size);
		}else if(r >= i+size && c >= j+size) {
			// 4사분면
			cnt += 3 * (size * size);
			recur(i+size, j+size, size);
		}
		
	}
	
	
}
