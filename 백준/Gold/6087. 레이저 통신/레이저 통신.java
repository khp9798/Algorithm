import java.util.*;
import java.io.*;

public class Main {

    static int[] dy = { -1, 1, 0, 0 };
    static int[] dx = { 0, 0, -1, 1 };

    public static void main(String[] args) throws IOException {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            int w = Integer.parseInt(st.nextToken());
            int h = Integer.parseInt(st.nextToken());

            char[][] map = new char[h][w];
            int[][][] dist = new int[h][w][4];

            int sy = -1, sx = -1, fy = -1, fx = -1;
            for (int y = 0; y < h; y++) {
                String str = br.readLine();
                for (int x = 0; x < w; x++) {
                    Arrays.fill(dist[y][x], Integer.MAX_VALUE);
                    map[y][x] = str.charAt(x);
                    if (map[y][x] == 'C') {
                        if (sy < 0) {
                            sy = y;
                            sx = x;
                        } else {
                            fy = y;
                            fx = x;
                        }
                    }
                }
            }

            Deque<int[]> deque = new ArrayDeque<>();
            for (int d = 0; d < 4; d++) {
                deque.offerFirst(new int[] { sy, sx, d });
                dist[sy][sx][d] = 0;
            }

            int answer = Integer.MAX_VALUE;

            while (!deque.isEmpty()) {
                int[] info = deque.pollFirst();

                int y = info[0];
                int x = info[1];
                int dir = info[2];
                int cnt = dist[y][x][dir];

                if (y == fy && x == fx) {
                    answer = Math.min(answer, cnt);
                }

                for (int d = 0; d < 4; d++) {
                    int ny = y + dy[dir];
                    int nx = x + dx[dir];

                    if (ny < 0 || nx < 0 || ny >= h || nx >= w)
                        continue;
                    if (map[ny][nx] == '*')
                        continue;

                    if (d == dir && dist[ny][nx][d] > cnt) {
                        deque.offerFirst(new int[] { ny, nx, d });
                        dist[ny][nx][d] = cnt;
                    } else if (dist[ny][nx][d] > cnt + 1) {
                        deque.offerLast(new int[] { ny, nx, d });
                        dist[ny][nx][d] = cnt + 1;
                    }
                }

            }

            System.out.println(answer);
        }

    }
}
