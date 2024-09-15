import java.io.*;
import java.util.*;

class Main {

    static int R;
    static int C;
    static char[][] map;
    static boolean[][] visited;
    static Queue<int[]> fireQueue;

    static class jihun {
        int r;
        int c;
        int time;

        public jihun(int r, int c, int time) {
            this.r = r;
            this.c = c;
            this.time = time;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        for (int t = 1; t <= T; t++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            C = Integer.parseInt(st.nextToken());
            R = Integer.parseInt(st.nextToken());

            map = new char[R][C];
            visited = new boolean[R][C];
            fireQueue = new LinkedList<>();

            jihun jihunStart = null;

            // 입력 받기 및 불과 지훈의 초기 위치 저장
            for (int r = 0; r < R; r++) {
                map[r] = br.readLine().toCharArray();
                for (int c = 0; c < C; c++) {
                    if (map[r][c] == '@') {
                        jihunStart = new jihun(r, c, 0);  // 지훈의 시작 위치
                    } else if (map[r][c] == '*') {
                        fireQueue.add(new int[]{r, c});  // 불의 초기 위치
                    }
                }
            }

            int result = bfs(jihunStart);
            System.out.println(result != -1 ? result : "IMPOSSIBLE");
        }
    }

    static int[] dr = {-1, 1, 0, 0};
    static int[] dc = {0, 0, -1, 1};

    private static int bfs(jihun start) {
        Queue<jihun> q = new LinkedList<>();
        q.add(start);
        visited[start.r][start.c] = true;

        while (!q.isEmpty()) {
            // 불을 먼저 퍼뜨림
            fire();

            // 지훈의 이동 처리
            int qSize = q.size();
            for (int i = 0; i < qSize; i++) {
                jihun j = q.poll();

                for (int d = 0; d < 4; d++) {
                    int nr = j.r + dr[d];
                    int nc = j.c + dc[d];

                    if (nr < 0 || nc < 0 || nr >= R || nc >= C) {
                        return j.time + 1;  // 탈출 성공
                    }

                    if (map[nr][nc] == '#' || map[nr][nc] == '*' || visited[nr][nc]) {
                        continue;
                    }

                    visited[nr][nc] = true;
                    q.add(new jihun(nr, nc, j.time + 1));
                }
            }
        }
        return -1;  // 탈출 불가능
    }

    private static void fire() {
        int fireSize = fireQueue.size();
        for (int i = 0; i < fireSize; i++) {
            int[] arr = fireQueue.poll();

            for (int d = 0; d < 4; d++) {
                int nr = arr[0] + dr[d];
                int nc = arr[1] + dc[d];

                if (nr < 0 || nc < 0 || nr >= R || nc >= C) continue;
                if (map[nr][nc] == '#' || map[nr][nc] == '*') continue;

                map[nr][nc] = '*';
                fireQueue.add(new int[]{nr, nc});  // 새로운 불의 위치를 큐에 추가
            }
        }
    }
}
