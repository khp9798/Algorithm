import java.util.*;
import java.io.*;

public class Main {

	static int R, C;
    static char[][] map;
    static int[][] fireTime, jihoonTime;
    static int[] dr = {-1,1,0,0}, dc = {0,0,-1,1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());

        map = new char[R][C];
        fireTime   = new int[R][C];
        jihoonTime = new int[R][C];

        Queue<int[]> fireQ = new LinkedList<>();
        Queue<int[]> jihQ  = new LinkedList<>();

        for (int r = 0; r < R; r++) {
            String line = br.readLine();
            for (int c = 0; c < C; c++) {
                map[r][c] = line.charAt(c);
                if (map[r][c] == 'F') {
                    fireQ.add(new int[]{r, c});
                    fireTime[r][c] = 1;
                }
                if (map[r][c] == 'J') {
                    jihQ.add(new int[]{r, c});
                    jihoonTime[r][c] = 1;
                }
            }
        }

        // 1) 불 BFS
        while (!fireQ.isEmpty()) {
            int[] cur = fireQ.poll();
            for (int d = 0; d < 4; d++) {
                int nr = cur[0] + dr[d];
                int nc = cur[1] + dc[d];
                if (nr < 0 || nc < 0 || nr >= R || nc >= C) continue;
                if (map[nr][nc] == '#' || fireTime[nr][nc] != 0) continue;

                fireTime[nr][nc] = fireTime[cur[0]][cur[1]] + 1;
                fireQ.add(new int[]{nr, nc});
            }
        }

        // 2) 지훈이 BFS
        while (!jihQ.isEmpty()) {
            int[] cur = jihQ.poll();
            int y = cur[0], x = cur[1];

            // 가장자리 탈출 확인
            if (y == 0 || y == R-1 || x == 0 || x == C-1) {
                System.out.println(jihoonTime[y][x]);
                return;
            }

            for (int d = 0; d < 4; d++) {
                int ny = y + dr[d];
                int nx = x + dc[d];
                if (ny < 0 || nx < 0 || ny >= R || nx >= C) continue;
                if (map[ny][nx] == '#' || jihoonTime[ny][nx] != 0) continue;

                int arriveTime = jihoonTime[y][x] + 1;
                // 불이 오는 시간보다 늦게 도착해야 하거나, 불이 아예 안 오는 칸
                if (fireTime[ny][nx] != 0 && fireTime[ny][nx] <= arriveTime) continue;

                jihoonTime[ny][nx] = arriveTime;
                jihQ.add(new int[]{ny, nx});
            }
        }

        // 탈출 못 함
        System.out.println("IMPOSSIBLE");
    }
}
