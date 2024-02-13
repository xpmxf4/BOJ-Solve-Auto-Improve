package org.example.boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_1012 {
    static int M, N;
    private static final int[] dx = {-1, 0, 1, 0};
    private static final int[] dy = {0, 1, 0, -1};

    private static boolean[][] baechu;
    private static boolean[][] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int T = Integer.parseInt(br.readLine());

        while (T > 0) {
            input(br);
            int cnt = pro();
            System.out.println(cnt);

            T--;
        }
    }

    private static int pro() {
        int cnt = 0;
        for (int i = 0; i < M; i++) {
            for (int j = 0; j < N; j++) {
                if (baechu[i][j] && !visited[i][j]) {
                    cnt++;
                    dfs(i, j);
                }
            }
        }
        return cnt;
    }

    private static void input(BufferedReader br) throws IOException {
        StringTokenizer st;
        st = new StringTokenizer(br.readLine());
        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        baechu = new boolean[M][N];
        visited = new boolean[M][N];

        for (int i = 0; i < K; i++) {
            st = new StringTokenizer(br.readLine());
            int bx = Integer.parseInt(st.nextToken());
            int by = Integer.parseInt(st.nextToken());

            baechu[bx][by] = true;
        }
    }

    private static void dfs(int x, int y) {
        visited[x][y] = true;

        for (int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];

            if (nx < 0 || nx >= M || ny < 0 || ny >= N) continue;
            if (visited[nx][ny]) continue;
            if (!baechu[nx][ny]) continue;
            dfs(nx, ny);
        }
    }
}
