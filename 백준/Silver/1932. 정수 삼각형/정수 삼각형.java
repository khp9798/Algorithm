import java.io.*;
import java.util.*;

class Main {
    public static void main(String[] args) throws IOException {
        // 코드 작성
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            int n = Integer.parseInt(br.readLine());

            List<Integer>[] info = new ArrayList[n];

            for (int i = 0; i < n; i++) {
                info[i] = new ArrayList<>();
            }

            StringTokenizer st;
            for (int i = 1; i <= n; i++) {
                st = new StringTokenizer(br.readLine());
                for (int j = 0; j < i; j++) {
                    info[i-1].add(Integer.parseInt(st.nextToken()));
                }
            }

            int[][] dp = new int[n][n];

            int[] idx = new int[n];

            dp[0][0] = info[0].get(0);
            idx[0] = 0;

            for (int i = 1; i < n; i++) {
                for (int j = 0; j <= i; j++) {
                    int fromLeftUp = (j > 0 ? dp[i - 1][j - 1] : 0);
                    int fromUp = (j < i ? dp[i - 1][j] : 0);
                    dp[i][j] = Math.max(fromLeftUp, fromUp)
                            + info[i].get(j);
                }
            }

            int answer = 0;
            for (int j = 0; j < n; j++) {
                answer = Math.max(answer, dp[n - 1][j]);
            }
            System.out.println(answer);

        }
    }
}