import java.util.*;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int M = sc.nextInt();
		
		Map<String, Integer> list = new HashMap<>();
		for(int i=0; i<N; i++) {
			list.put(sc.next(), 0);
		}
		
		List<String> answer = new ArrayList<>();
		for(int i=0; i<M; i++) {
			String tmp = sc.next();
			if(list.containsKey(tmp)) {
				answer.add(tmp);
			}
		}
		
		Collections.sort(answer);
		System.out.println(answer.size());
		for(String s : answer) {
			System.out.println(s);
		}
		
	}
}