import java.io.*;
import java.util.*;

public class Main {

    static int[] dy = { -1, 1, 0, 0 };
    static int[] dx = { 0, 0, -1, 1 };

    public static void main(String[] args) throws IOException {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            int N = Integer.parseInt(st.nextToken());

            char[][] house = new char[N][N];
            int[][][] dist = new int[N][N][4];

            int starty = -1, startx = -1;
            for (int r = 0; r < N; r++) {
                String str = br.readLine();
                for (int c = 0; c < N; c++) {
                    house[r][c] = str.charAt(c);
                    if (starty < 0 && house[r][c] == '#') {
                        starty = r;
                        startx = c;
                    }
                }
            }

            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    Arrays.fill(dist[i][j], Integer.MAX_VALUE);
                }
            }

            Deque<int[]> q = new ArrayDeque<>();

            for (int i = 0; i < 4; i++) {
                dist[starty][startx][i] = 0;
                q.offerFirst(new int[] { starty, startx, i });
            }

            int answer = Integer.MAX_VALUE;

            while (!q.isEmpty()) {
                int[] info = q.poll();

                int y = info[0];
                int x = info[1];
                int dir = info[2];
                int cnt = dist[y][x][dir];

                if (!(y == starty && x == startx) && house[y][x] == '#') {
                    answer = Math.min(answer, cnt);
                }

                int ny = y + dy[dir];
                int nx = x + dx[dir];

                if (ny < 0 || nx < 0 || ny >= N || nx >= N || house[ny][nx] == '*')
                    continue;

                if ((house[ny][nx] == '.' || house[ny][nx] == '#' || house[ny][nx] == '!')
                        && dist[ny][nx][dir] > cnt) {
                    dist[ny][nx][dir] = cnt;
                    q.offerFirst(new int[] { ny, nx, dir });
                }

                if (house[ny][nx] == '!') {

                    for (int d : new int[] { dir < 2 ? 2 : 0, dir < 2 ? 3 : 1 }) {
                        if (dist[ny][nx][d] > cnt + 1) {
                            q.offerLast(new int[] { ny, nx, d });
                            dist[ny][nx][d] = cnt + 1;
                        }
                    }

                }

            }

            System.out.println(answer);

        }
    }
}
