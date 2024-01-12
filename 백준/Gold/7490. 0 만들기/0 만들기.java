import java.util.*;

public class Main {
	
	static int T;
	static int N;
	static int[] visited;
	
	public static void main(String[] args) {
		 Scanner sc = new Scanner(System.in);
		 T = sc.nextInt();
		 
		 for(int i=0; i<T; i++) {
			 N = sc.nextInt();
			 calcu("", 1);
			 System.out.println();
		 }
		 
	}

	private static void calcu(String content, int size) {
		if(size == N+1) {
			if(content.charAt(0) == '+') cal(content.substring(1, content.length()));
			return;
		}
		
		calcu(content+" "+Integer.toString(size), size+1);
		calcu(content+"+"+Integer.toString(size), size+1);
		calcu(content+"-"+Integer.toString(size), size+1);
		
	}

	private static void cal(String content) {
		
		String backup = content;
		
		content = content.replace(" ", ""); // 공백 제거해서 합치기
		StringTokenizer st = new StringTokenizer(content, "+|-", true);
		
		int tmp = 0;
		boolean plus = true; // 우선 true로 설정
		while (st.hasMoreTokens()) {
		    String token = st.nextToken();

		    if(token.equals("+")) plus = true;
		    else if(token.equals("-")) plus = false;
		    else {
		    	if(plus == true) tmp += Integer.parseInt(token);
		    	else tmp -= Integer.parseInt(token);
		    }
		}
		
		if(tmp == 0) System.out.println(backup);
	}
}
