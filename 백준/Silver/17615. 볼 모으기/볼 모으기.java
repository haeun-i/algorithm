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
		
		// 마지막 블럭 고려하기
		if(str.charAt(N-1) == 'R') {
			r_cnt--;
			for(int i=N-2; i>=0; i--) {
				if(str.charAt(i) == 'R') r_cnt--;
				else break;
			}
		}
		else if(str.charAt(N-1) == 'B') {
			b_cnt--;
			for(int i=N-2; i>=0; i--) {
				if(str.charAt(i) == 'B') b_cnt--;
				else break;
			}
		}
		
		System.out.println(Math.min(r_cnt, b_cnt));
	}
}