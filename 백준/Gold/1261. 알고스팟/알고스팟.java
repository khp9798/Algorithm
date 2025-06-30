import java.io.*;
import java.util.*;

class Main {

    static int n;
    static int m;

    static int[][] miro;

    static int[] dr = { -1, 1, 0, 0 };
    static int[] dc = { 0, 0, -1, 1 };

    static int[][] dist;

    static int answer = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        // 코드 작성
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            m = Integer.parseInt(st.nextToken());

            n = Integer.parseInt(st.nextToken());

            miro = new int[n][m];
            dist = new int[n][m];

            for (int i = 0; i < n; i++) {
                String str = br.readLine();
                Arrays.fill(dist[i], Integer.MAX_VALUE);
                for (int j = 0; j < m; j++) {
                    miro[i][j] = str.charAt(j) - '0';
                }
            }

            bfs(0, 0);

        }
    }

    static void bfs(int sr, int sc) {
        Deque<int[]> q = new ArrayDeque<>();
        dist[sr][sc] = 0;
        q.offerFirst(new int[] { sr, sc });

        while (!q.isEmpty()) {
            int[] info = q.pollFirst();

            int r = info[0];
            int c = info[1];

            for (int d = 0; d < 4; d++) {
                int nr = r + dr[d];
                int nc = c + dc[d];

                if (nr < 0 || nc < 0 || nr >= n || nc >= m)
                    continue;

                int cost = miro[nr][nc];
                int nd = dist[r][c] + cost;

                if (nd < dist[nr][nc]) {
                    dist[nr][nc] = nd;

                    if (cost == 0)
                        q.offerFirst(new int[] { nr, nc });
                    else
                        q.offerLast(new int[] { nr, nc });
                }

            }
        }

        System.out.println(dist[n - 1][m - 1]);
    }
}