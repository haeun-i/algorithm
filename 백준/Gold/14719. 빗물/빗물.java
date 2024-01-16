import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	
	static int H, W;
	static int[] arr;
	
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        H = Integer.parseInt(st.nextToken());
        W = Integer.parseInt(st.nextToken());
        arr = new int[W+2]; // 양옆 고려 셋팅
        
        // 배열 생성
        st = new StringTokenizer(br.readLine(), " ");
        for(int i=1; i<=W; i++) {
        	arr[i] = Integer.parseInt(st.nextToken());
        }
        
        // 계산
        int cnt = 0;
        for(int i=1; i<=W; i++) {
        	int left_max = 0;
        	for(int j=0; j<i; j++) {
        		left_max = Math.max(left_max, arr[j]);
        	}
        	
        	int right_max = 0;
        	for(int j=i+1; j<=W; j++) {
        		right_max = Math.max(right_max, arr[j]);
        	}
        
        	int max = Math.min(right_max, left_max);
        	if(max > arr[i]) cnt += (max - arr[i]);
        	
        }
    	System.out.println(cnt);
       
        
    }
}