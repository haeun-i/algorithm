import java.util.*;
import java.io.*;

public class Main {
    
    static int N;
    static List<Integer>[] adj;
    static boolean[] visited;
    static boolean[] cycle;
    static int[] dist;
    static boolean answered = false;
    
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        N = Integer.parseInt(br.readLine());
        
        adj = new List[N+1];
        dist = new int[N+1];
        cycle = new boolean[N+1];
        
        for(int i=0; i<N+1; i++) {
            adj[i] = new ArrayList<>();
        }
        
        for(int i=0; i<N; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int n1 = Integer.parseInt(st.nextToken());
            int n2 = Integer.parseInt(st.nextToken());
            adj[n1].add(n2);
            adj[n2].add(n1);
        }
        
        for(int i=1; i<=N; i++) {
        	visited = new boolean[N+1];
        	answered = false;
        	dfs(i, i, -1);
        }
        
        
        for(int i=1; i<=N; i++) {
            if(cycle[i] == true) { // 순환선 내부에 있으면
                dist[i] = 0;
            } else {
                dist[i] = bfs(i);
            }
        }
        
        for(int i=1; i<=N; i++) {
            System.out.print(dist[i] + " " );
        }
    }

    private static int bfs(int n) {
        Queue<Integer> q = new LinkedList<>();
        int[] tmp = new int[N+1]; // dist
        
        q.add(n);
        while(!q.isEmpty()) {
        	int t = q.poll();
            for(int i=0; i<adj[t].size(); i++) {
            	int next = adj[t].get(i);
            	if(tmp[next] == 0) {
            		q.add(next);
            		tmp[next] = tmp[t] + 1;
            		if(cycle[next] == true) return tmp[next];
            	}
            }
        }
        return 0;
    }

    private static void dfs(int num, int tmp, int before) {
    	
    	if(answered == true) return;
    	 
        if(tmp == num && before != -1) { // 시작점이 아닌데 원래 점으로 왔다 -> cycle
            cycle[num] = true;
        	answered = true;
            return;
        }
        
        for(int i=0; i<adj[tmp].size(); i++) {
            int next = adj[tmp].get(i);
            if(visited[next] == false && before != next) {
                visited[next] = true;
                dfs(num, next, tmp);
                if(answered == true) return;
            }
        }
        return;
    }

}