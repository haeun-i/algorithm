import java.util.Scanner;

public class Main {

    static int n;
    static int[][] graph;
    static boolean[][] visited;
    static int[] dy = {1, 0, -1, 0};
    static int[] dx = {0, 1, 0, -1};
    static int depth = 0;
    static int ret = Integer.MAX_VALUE;

    static boolean check(int y, int x) {
        if (visited[y][x] == true) return false;
        for (int i = 0; i < 4; i++) {
            int ny = y + dy[i];
            int nx = x + dx[i];
            if (ny < 0 || ny >= n || nx < 0 || nx >= n || visited[ny][nx] == true) {
                return false;
            }
        }
        return true;
    }

    static int setFlower(int y, int x) {
        visited[y][x] = true;
        int s = graph[y][x];
        for (int i = 0; i < 4; i++) {
            int ny = y + dy[i];
            int nx = x + dx[i];
            visited[ny][nx] = true;
            s += graph[ny][nx];
        }
        return s;
    }

    static void eraseFlower(int y, int x) {
        visited[y][x] = false;
        for (int i = 0; i < 4; i++) {
            int ny = y + dy[i];
            int nx = x + dx[i];
            visited[ny][nx] = false;
        }
    }

    static void flower(int cnt, int hap) {
        if (cnt == 3) {
            ret = Math.min(ret, hap);
            return;
        }
        for (int i = 1; i < n - 1; i++) {
            for (int j = 1; j < n - 1; j++) {
                if (check(i, j)) {
                    flower(cnt + 1, hap + setFlower(i, j));
                    eraseFlower(i, j);
                }
            }
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        n = scanner.nextInt();

        graph = new int[n][n];
        visited = new boolean[n][n];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                graph[i][j] = scanner.nextInt();
            }
        }

        flower(0, 0);

        System.out.println(ret);
    }
}
