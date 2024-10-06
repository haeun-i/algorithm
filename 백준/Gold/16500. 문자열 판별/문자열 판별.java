import java.util.*;
import java.io.*;

public class Main {
	static int N;
	static Set<String> set;
	static int[] dp;
	
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();
        N = Integer.parseInt(br.readLine());

        set = new HashSet<>();
        for(int i=0;i<N;i++) {
            String word = br.readLine();
            if(s.contains(word)) {
                set.add(word);
            }
        }

        dp = new int[s.length()];

        for(int i=s.length() -1 ;i>=0;i--) {
            for(int j=i+1;j<s.length();j++) {
                if(dp[j] == 1 && set.contains(s.substring(i,j))) {
                    dp[i] = 1;
                }
            }
            if(set.contains(s.substring(i))) {
                dp[i] = 1;
            }
        }
        
        System.out.println(dp[0]);
    }
}