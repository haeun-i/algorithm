import java.util.*;
import java.io.*;

public class Main {
	
	static int N, M;
	static Map<String, List<String>> groups;
	static Map<String, String> members;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		groups = new HashMap<>();
		members = new HashMap<>();
		
		for(int i=0; i<N; i++) {
			String group = br.readLine();
			groups.put(group, new ArrayList<>());
			int cnt = Integer.parseInt(br.readLine());
			for(int j=0; j<cnt; j++) {
				String name = br.readLine();
				groups.get(group).add(name);
				members.put(name, group);
			}
		}
		
		for(int i=0; i<M; i++) {
			// 그룹 찾기
			String quest = br.readLine();
			int qnum = Integer.parseInt(br.readLine());
			
			if(qnum == 1) {
				System.out.println(members.get(quest));
			}else if(qnum == 0) {
				List<String> ll = groups.get(quest);
				Collections.sort(ll);
				for(String m : ll) {
					System.out.println(m);
				}
			}
		}
		
		
	}
}