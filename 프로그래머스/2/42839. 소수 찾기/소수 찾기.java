import java.util.*;

class Solution {

    public static char[] list;
    public static int[] visited;
    public static boolean[] isPrime;
    public static Set<Integer> ss; // Set 대신 List 사용
    public static int n;

    public static void makePerm(int size, String s) {
        if (size > n) return;

        for (int i = 0; i < list.length; i++) {
            if (visited[i] == 0) {
                s += list[i];
                visited[i] = 1;

                // 소수 확인
                int num = Integer.parseInt(s);
                if (!isPrime[num]) {
                    ss.add(num);
                }

                makePerm(size + 1, s);

                visited[i] = 0;
                s = s.substring(0, s.length() - 1); // 마지막 한 글자를 제외한 부분 문자열로 갱신
            }
        }
    }

    public static void findPrime() {
        isPrime = new boolean[10000000];
        isPrime[0] = true;
        isPrime[1] = true;
        for (int i = 2; i <= Math.sqrt(10000000); i++) {
            if (!isPrime[i]) {
                for (int j = i * i; j < 10000000; j += i) {
                    isPrime[j] = true;
                }
            }
        }
    }

    public int solution(String numbers) {
        ss = new HashSet<>();
        findPrime();
        n = numbers.length();
        list = numbers.toCharArray();
        visited = new int[n];
        makePerm(0, "");

        // for (int i : ss) {
        //     System.out.println(i);
        // }
        return ss.size();
    }
}
