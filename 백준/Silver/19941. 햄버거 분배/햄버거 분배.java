import java.util.*;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int K = sc.nextInt();
		boolean[] arr = new boolean[N];
		
		// 햄버거에 true 표시
		String str = sc.next();
		for(int i=0; i<str.length(); i++) {
			if(str.charAt(i) == 'H') {
				arr[i] = true;
			}
		}
		
		int cnt = 0;
		for(int i=0; i<N; i++) {
			if(str.charAt(i) == 'P') {
				boolean flag = false;
				// 왼쪽 확인
				for(int j=i-K; j<i; j++) {
					if(j < 0) continue;
					if(arr[j] == true) {
						cnt++;
						arr[j] = false;
						//System.out.println(i);
						flag = true;
						break;
					}
				}
				
				// 왼쪽에 없는 경우 오른쪽 확인
				if(flag == false) {
					for(int j=i+1; j<=i+K; j++) {
						if(j >= N) continue;
						if(arr[j] == true) {
							cnt++;
							arr[j] = false;
							//System.out.println(i);
							break;
						}
					}
				}
			}
		}
		System.out.println(cnt);
		
	}
}