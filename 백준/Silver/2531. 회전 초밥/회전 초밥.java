import java.util.*;
import java.io.*;
 
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        
        int N = Integer.parseInt(st.nextToken());
        int d = Integer.parseInt(st.nextToken());   // 초밥 가짓수
        int k = Integer.parseInt(st.nextToken());   // 연속해서 먹는 접시의 수
        int c = Integer.parseInt(st.nextToken());   // 쿠폰 번호
        
        int[] sushi = new int[N];
        for(int i = 0 ; i < N ; i++) {
            sushi[i] = Integer.parseInt(br.readLine());
        }
        
        int[] chk = new int[d+1];   // 먹은 초밥 종류 관련 배열
        chk[c] = 3001;  // 무료 초밥 종류
        
        int cnt = 1;    // 무료 초밥이 1개이므로
        
        // 1. 회전하지 않았을 때 초밥 종류 구하기
        for(int i = 0 ; i < k ; i++) {
            if(chk[sushi[i]] == 0)
                cnt++;
            
            chk[sushi[i]]++;
        }
        
        int max = cnt;
        
        for(int i = 0 ; i < N-1 ; i++) {
            int sIdx = sushi[i];    
            int eIdx = sushi[((i+k) < N) ? (i+k) : (i+k) % N];    // 마지막 + 1번째 먹을 초밥 종류
            
            // 처음 먹은 초밥 종류가 더 이상 없을 때
            if(--chk[sIdx] == 0)
                cnt--;
                
            // 마지막 +1번째 먹을 초밥이 처음 먹는 것일 때
            if(++chk[eIdx] == 1)
                cnt++;
           
            max = Math.max(max, cnt);
        }
        
        System.out.println(max);
    }
}