package org.example.boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;

public class BOJ_2667 {
    static int N = 0, sum = 0;
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, 1, 0, -1};
    static int[][] arr;
    static boolean[][] visited;
    static ArrayList<Integer> ans = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        input();
        pro();
    }

    static void pro() {
        for (int x = 0; x < N; x++) {
            for (int y = 0; y < N; y++) {
                if (arr[x][y] == 1 && !visited[x][y]) {
                    System.out.printf("(x,y) = (%s, %s)\n", x, y);
                    dfs(x, y);
                    ans.add(sum);
                    sum = 0;
                }
            }
        }

        Collections.sort(ans);

        System.out.println(ans.size());
        for (int el : ans) {
            System.out.println(el);
        }
    }

    private static void dfs(int x, int y) {
        visited[x][y] = true;
        sum++;

        for (int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];

            if (nx < 0 || nx >= N || ny < 0 || ny >= N) continue;
            if (visited[nx][ny]) continue;
            if (arr[nx][ny] != 1) continue;

            dfs(nx, ny);
        }
    }

    static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        arr = new int[N][N];
        visited = new boolean[N][N];
        for (int i = 0; i < N; i++) {
            String str = br.readLine();
            for (int j = 0; j < N; j++) {
                arr[i][j] = Character.getNumericValue(str.charAt(j));
            }
        }
    }
}
