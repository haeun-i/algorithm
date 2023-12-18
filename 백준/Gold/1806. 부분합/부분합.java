
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static int N, S;
    public static long[] arr;
    public static int length = Integer.MAX_VALUE;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        N = Integer.parseInt(st.nextToken());
        S = Integer.parseInt(st.nextToken());
        arr = new long[N];

        st = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        cal();
        if (length == Integer.MAX_VALUE) System.out.println(0);
        else System.out.println(length);
    }

    private static void cal() {
        int l = 0;
        int r = 0;
        long sum = 0;

        while (l < N && r < N) {
            // 확인
            if (sum + arr[r] >= S) {
                length = Math.min(r - l + 1, length);
                sum -= arr[l];
                l++;
            } else {
                sum += arr[r];
                r++;
            }
        }
    }
}
