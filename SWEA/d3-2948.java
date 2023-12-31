package p1228;

import java.io.*;
import java.util.*;

public class Solution_2948_문자열교집합 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		
		for(int tc=1; tc<=T; tc++) {
			int cnt = 0;
			
			StringTokenizer st = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(st.nextToken());
			int M = Integer.parseInt(st.nextToken());
			
			Map<String, Integer> m = new HashMap<>();
			st = new StringTokenizer(br.readLine());
			for(int i=0; i<N; i++) {
				m.put(st.nextToken(), 1);
			}
			
			st = new StringTokenizer(br.readLine());
			for(int i=0; i<M; i++) {
				if(m.containsKey(st.nextToken())) cnt++;
			}
			
			System.out.println("#" + tc + " " + cnt);
		}
	}
}
