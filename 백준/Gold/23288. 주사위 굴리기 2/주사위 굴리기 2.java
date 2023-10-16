import java.util.*;
import java.io.*;

public class Main {

    static class Dice {
        int up;
        int down;
        int front;
        int back;
        int east;
        int west;

        public Dice() {
            super();
            this.up = 1;
            this.down = 6;
            this.front = 2;
            this.back = 5;
            this.east = 3;
            this.west = 4;
        }
    }

    static int N, M, K;
    static int[][] arr;
    static int d = 0; // 동 0 | 남 1 | 서 2 | 북 3
    static int score = 0;

    static int[] dy = {0, 1, 0, -1};
    static int[] dx = {1, 0, -1, 0};
    static int dice_r = 0;
    static int dice_c = 0;
    static Dice dice;

    public static void main(String[] args) throws Exception {
        dice = new Dice();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        arr = new int[N][M];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            for (int j = 0; j < M; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for (int i = 0; i < K; i++) {
            int ny = dice_r + dy[d];
            int nx = dice_c + dx[d];

            if (ny < 0 || ny >= N || nx < 0 || nx >= M) {
                d = (d + 2) % 4;
                ny = dice_r + dy[d];
                nx = dice_c + dx[d];
            }

            dice_r = ny;
            dice_c = nx;
            score += getScore(ny, nx);
            setDice();

            if (dice.down > arr[ny][nx]) {
                d = (d + 1) % 4;
            } else if (dice.down < arr[ny][nx]) {
                d = (d + 4 - 1) % 4;
            }
        }
        System.out.println(score);

    }

    private static void setDice() {
        int up = dice.up;
        int down = dice.down;
        int front = dice.front;
        int back = dice.back;
        int east = dice.east;
        int west = dice.west;

        if (d == 0) { // 동쪽으로 이동
            dice.west = down;
            dice.down = east;
            dice.east = up;
            dice.up = west;
        } else if (d == 1) { // 남쪽으로 이동
            dice.front = down;
            dice.down = back;
            dice.back = up;
            dice.up = front;
        } else if (d == 2) { // 서쪽으로 이동
            dice.east = down;
            dice.down = west;
            dice.west = up;
            dice.up = east;
        } else if (d == 3) { // 북쪽으로 이동
            dice.back = down;
            dice.down = front;
            dice.front = up;
            dice.up = back;
        }
    }

    private static int getScore(int y, int x) {
        int score = arr[y][x];
        boolean[][] visited = new boolean[N][M];

        int cnt = 0;
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[] {y, x});
        visited[y][x] = true;
        while (!q.isEmpty()) {
            int[] tmp = q.poll();
            cnt++;
            visited[tmp[0]][tmp[1]] = true;
            for (int i = 0; i < 4; i++) {
                int ny = tmp[0] + dy[i];
                int nx = tmp[1] + dx[i];

                if (ny < 0 || ny >= N || nx < 0 || nx >= M) continue;
                if (arr[ny][nx] == score && !visited[ny][nx]) {
                    q.add(new int[] {ny, nx});
                    visited[ny][nx] = true;
                }
            }
        }
        return score * cnt;
    }

}
