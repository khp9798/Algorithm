import java.io.*;
import java.util.*;

class Main {

    static int[] dr = { -1, 1, 0, 0, -1, -1, 1, 1 };
    static int[] dc = { 0, 0, -1, 1, 1, -1, 1, -1 };

    static int n, m;

    static int[][] arr;

    static boolean[][] visited;

    public static void main(String[] args) throws IOException {
        // 코드 작성
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            n = Integer.parseInt(st.nextToken());
            m = Integer.parseInt(st.nextToken());

            arr = new int[n][m];

            visited = new boolean[n][m];

            for (int i = 0; i < n; i++) {
                st = new StringTokenizer(br.readLine());
                for (int j = 0; j < m; j++) {
                    arr[i][j] = Integer.parseInt(st.nextToken());
                }
            }

            int answer = 0;
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    if (arr[i][j] == 1 && !visited[i][j]) {
                        dfs(i, j);
                        answer++;
                    }
                }
            }

            System.out.println(answer);
        }
    }

    static void dfs(int r, int c) {
        visited[r][c] = true;

        for (int d = 0; d < 8; d++) {
            int nr = r + dr[d];
            int nc = c + dc[d];

            if (nr < 0 || nc < 0 || nr >= n || nc >= m)
                continue;

            if (visited[nr][nc] || arr[nr][nc] != 1)
                continue;

            dfs(nr, nc);
        }
    }
}