package org.example.boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_7768 {
    private static int T, N, M;
    private static int[] A, B;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        T = Integer.parseInt(br.readLine());

        while (T > 0) {
            st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            M = Integer.parseInt(st.nextToken());
            A = new int[N];
            B = new int[M];

            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < N; i++)
                A[i] = Integer.parseInt(st.nextToken());

            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < M; i++)
                B[i] = Integer.parseInt(st.nextToken());

            // B 정렬
            Arrays.sort(B);

            int ans = 0;
            // A 각각의 원소로 이분탐색 실행
            for (int i = 0; i < N; i++) {
                ans += lowerBound(B, 0, M - 1, A[i]);
            }

            // 정답 출력
            System.out.println(ans);

            T--;
        }
    }

    private static int lowerBound(int[] B, int L, int R, int X) {
        int idx = 0;

        while (L <= R) {
            int mid = (L + R) / 2;
            if (B[mid] < X) {
                L = mid + 1;
                idx = mid;
            } else {
                R = mid - 1;
            }
        }

        if (idx == 0 && B[idx] >= X) {
            idx = -1;
        }

        return idx + 1;
    }

}
