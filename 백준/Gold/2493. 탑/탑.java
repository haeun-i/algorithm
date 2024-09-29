import java.util.*;
import java.io.*;

public class Main {
	
	public static int N;
	public static int[] arr;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		arr = new int[N];
		
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		Stack<int[]> s = new Stack<>();
		for(int i=0; i<N; i++) {
			int top = Integer.parseInt(st.nextToken());
		
			if(s.isEmpty()) { // 초기
				System.out.print("0 ");
				s.push(new int[]{1, top});
			}else {
				while (true) { 
					
                    if (s.isEmpty()) { 
                    	System.out.print("0 "); 
                        s.push(new int[] {i+1, top});
                        break;
                    }
                    
                    int[] tmp = s.peek();
                    if (tmp[1] > top) { 
                        System.out.print(tmp[0] + " "); 
                        s.push(new int[] {i+1, top});
                        break;
                    } else { 
                        s.pop();
                    }
                }
			}
		}

		
	}
}