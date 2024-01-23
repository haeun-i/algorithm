import java.util.*;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		String str = sc.next();
		Stack<String> sta = new Stack<>();
		
		//B로 자르기
		int b_cnt = 0;
		StringTokenizer st = new StringTokenizer(str, "B", true);
		while(st.hasMoreTokens()) {
			String tmp = st.nextToken();
			if(tmp.contains("B")) b_cnt++;
		}
		
		// R로 자르기
		int r_cnt = 0;
		st = new StringTokenizer(str, "R", true);
		while(st.hasMoreTokens()) {
			String tmp = st.nextToken();
			if(tmp.contains("R")) r_cnt++;
		}
		
		int back_r = r_cnt;
		int back_b = b_cnt;
		// 마지막 블럭 고려하기
		if(str.charAt(N-1) == 'R') {
			back_r--;
			for(int i=N-2; i>=0; i--) {
				if(str.charAt(i) == 'R') back_r--;
				else break;
			}
		}
		else if(str.charAt(N-1) == 'B') {
			back_b--;
			for(int i=N-2; i>=0; i--) {
				if(str.charAt(i) == 'B') back_b--;
				else break;
			}
		}
		
		int front_r = r_cnt;
		int front_b = b_cnt;
		// 마지막 블럭 고려하기
		if(str.charAt(0) == 'R') {
			front_r--;
			for(int i=1; i<N; i++) {
				if(str.charAt(i) == 'R') front_r--;
				else break;
			}
		}
		else if(str.charAt(0) == 'B') {
			front_b--;
			for(int i=1; i<N; i++) {
				if(str.charAt(i) == 'B') front_b--;
				else break;
			}
		}
		
		int min_b = Math.min(back_b, front_b);
		int min_r = Math.min(back_r, front_r);
		System.out.println(Math.min(min_b, min_r));
	}
}

