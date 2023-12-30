import java.util.*;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int subin = sc.nextInt();
		int sister = sc.nextInt();
		
		Queue<Integer> q = new LinkedList<>();
		int[] visited = new int[100001];
		
		q.add(subin);
		while(!q.isEmpty()) {
			int tmp = q.poll();
			
			if(tmp == sister) { // 찾은 경우
				System.out.println(visited[tmp]);
				break;
			}
			
			if(tmp-1 >= 0 && visited[tmp-1] == 0 ) {
				q.add(tmp-1);
				visited[tmp-1] = visited[tmp] + 1;
			}
			if(tmp+1 <= 100000 && visited[tmp+1] == 0) {
				q.add(tmp+1);
				visited[tmp+1] = visited[tmp] + 1;
			}
			if(tmp*2 <= 100000 && visited[tmp*2] == 0) {
				q.add(tmp*2);
				visited[tmp*2] = visited[tmp] + 1;
			}
		}
	}
}