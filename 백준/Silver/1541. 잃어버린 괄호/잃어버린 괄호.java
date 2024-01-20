import java.util.*;

// 값이 최소가 되려면?  -가되는 값이 최대한 많아야 한다
public class Main {
	
	static String str;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		str = sc.next();
		
		String[] arr = str.split("-");
		List<Integer> list = new ArrayList<>();
		for(String s : arr) {
			list.add(cal(s));
		}
		
		int res = list.get(0);
		for(int i=1; i<arr.length; i++) {
			res -= list.get(i);
		}
		
		System.out.println(res);
	}

	private static int cal(String s) {
		if(s.contains("+")) {
			String[] arr = s.split("\\+");
			int res = 0;
			for(int i=0; i<arr.length; i++) {
				res += Integer.parseInt(arr[i]);
			}
			return res;
		}else {
			return Integer.parseInt(s);
		}
		
	}
}