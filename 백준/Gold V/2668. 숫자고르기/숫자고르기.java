import java.util.*;


public class Main {
	
	static int[] arr;
	static boolean[] visited;
	static List<Integer> list;
	static int N;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		
		arr = new int[N+1];
		visited = new boolean[N+1];
		list = new ArrayList<>();
		
		for(int i=1; i<=N; i++) {
			arr[i] = sc.nextInt();
		}
		
		
		for(int i=1; i<=N; i++) {
			dfs(i, i);
			clean();
		}
		
		System.out.println(list.size());
		for(int i : list) System.out.println(i);
	}

	static void dfs(int num, int tmp) {
		
		if(num == tmp && visited[tmp] == true) {
			list.add(num);
			return;
		}
		
		if(visited[tmp] == false) {
			visited[tmp] = true; // 방문체크
			dfs(num, arr[tmp]);
		}
		
	}
	
	static void clean() {
		for(int i=0; i<=N; i++) {
			visited[i] = false;
		}
	}
}