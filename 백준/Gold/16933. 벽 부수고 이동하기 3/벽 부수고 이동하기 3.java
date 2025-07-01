import java.io.*;
import java.util.*;

public class Main {
    static int n, m, k;
    static int[][] map;
    // visited[r][c][usedWalls][day]
    static boolean[][][][] visited;
    static final int[] dr = {-1, 1, 0, 0};
    static final int[] dc = {0, 0, -1, 1};

    static class Person {
        int r, c, used, dist, day;
        Person(int r, int c, int used, int dist, int day) {
            this.r = r; this.c = c; this.used = used;
            this.dist = dist; this.day = day;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());
        map = new int[n][m];
        visited = new boolean[n][m][k + 1][2];
        for (int i = 0; i < n; i++) {
            String line = br.readLine();
            for (int j = 0; j < m; j++) {
                map[i][j] = line.charAt(j) - '0';
            }
        }
        System.out.println(bfs());
    }

    static int bfs() {
        Deque<Person> q = new ArrayDeque<>();
        // start at (0,0), usedWalls=0, day=0 (day), dist=1
        visited[0][0][0][0] = true;
        q.offer(new Person(0, 0, 0, 1, 0));

        while (!q.isEmpty()) {
            Person p = q.poll();
            int r = p.r, c = p.c, used = p.used, dist = p.dist, day = p.day;
            int nextDay = day ^ 1;

            if (r == n - 1 && c == m - 1) return dist;

            for (int d = 0; d < 4; d++) {
                int nr = r + dr[d], nc = c + dc[d];
                if (nr < 0 || nc < 0 || nr >= n || nc >= m) continue;
                if (map[nr][nc] == 0) {
                    // empty: move
                    if (!visited[nr][nc][used][nextDay]) {
                        visited[nr][nc][used][nextDay] = true;
                        q.offer(new Person(nr, nc, used, dist + 1, nextDay));
                    }
                } else {
                    // wall encountered
                    if (day == 0 && used < k) {
                        // day: can break
                        if (!visited[nr][nc][used + 1][nextDay]) {
                            visited[nr][nc][used + 1][nextDay] = true;
                            q.offer(new Person(nr, nc, used + 1, dist + 1, nextDay));
                        }
                    } else if (day == 1) {
                        // night: wait in place
                        if (!visited[r][c][used][nextDay]) {
                            visited[r][c][used][nextDay] = true;
                            q.offer(new Person(r, c, used, dist + 1, nextDay));
                        }
                    }
                }
            }
        }
        return -1;
    }
}
