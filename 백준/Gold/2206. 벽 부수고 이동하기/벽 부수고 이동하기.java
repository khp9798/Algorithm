import java.io.*;
import java.util.*;

class Main {

    static int n, m;

    static int[][] map;

    static boolean[][][] visited;

    static int[] dr = { -1, 1, 0, 0 };
    static int[] dc = { 0, 0, -1, 1 };

    public static void main(String[] args) throws IOException {
        // 코드 작성
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            String[] nm = br.readLine().split(" ");

            n = Integer.parseInt(nm[0]);
            m = Integer.parseInt(nm[1]);

            map = new int[n][m];

            visited = new boolean[n][m][2];

            for (int i = 0; i < n; i++) {
                String str = br.readLine();
                for (int j = 0; j < m; j++) {
                    map[i][j] = str.charAt(j) - '0';
                }
            }

            System.out.print(bfs());

        }
    }

    static int bfs() {
        Queue<int[]> q = new ArrayDeque<>();
        q.offer(new int[] { 0, 0, 1, 1 });
        visited[0][0][1] = true;

        int answer = -1;

        while (!q.isEmpty()) {
            int[] info = q.poll();

            int r = info[0];
            int c = info[1];
            int cnt = info[2];
            int dist = info[3];

            if (r == n - 1 && c == m - 1) {
                answer = dist;
                break;
            }

            for (int d = 0; d < 4; d++) {
                int nr = r + dr[d];
                int nc = c + dc[d];

                if (nr < 0 || nc < 0 || nr >= n || nc >= m)
                    continue;

                if (map[nr][nc] == 1 && cnt > 0 && !visited[nr][nc][cnt - 1]) {
                    visited[nr][nc][cnt - 1] = true;
                    q.offer(new int[] { nr, nc, cnt - 1, dist + 1 });
                }

                else if (map[nr][nc] == 0 && !visited[nr][nc][cnt]) {
                    visited[nr][nc][cnt] = true;
                    q.offer(new int[] { nr, nc, cnt, dist + 1 });
                }
            }
        }

        return answer;
    }
}