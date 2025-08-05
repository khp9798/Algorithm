import java.io.*;
import java.util.*;

class Main {

    static int n;

    static int sharkX,sharkY;

    static int[][] map;

    static int[] dr = {-1,0,1,0};
    static int[] dc = {0,-1,0,1};

    public static void main(String[] args) throws IOException {
        // 코드 작성
        try(BufferedReader br = new BufferedReader(new InputStreamReader(System.in))){
            n = Integer.parseInt(br.readLine());

            map = new int[n][n];


            StringTokenizer st;
            for(int r=0; r<n; r++){
                st = new StringTokenizer(br.readLine());
                for(int c=0; c<n; c++){
                    map[r][c] = Integer.parseInt(st.nextToken());

                    if(map[r][c]==9){
                        sharkY = r;
                        sharkX = c;
                    }
                }
            }

            map[sharkY][sharkX] = 0;       // 상어가 차지했던 칸은 빈 칸으로
            int size = 2;                 // 아기 상어 초기 크기
            int eaten = 0;                // 지금까지 먹은 물고기 수
            int time = 0;                 // 총 이동 시간


            while (true) {
                // 1) BFS 탐색을 통해 (물고기 위치, 거리) 반환
                Fish target = findNearestFish(sharkY, sharkX, size);
                if (target == null) break;  // 더 먹을 물고기 없으면 종료

                // 2) 탐색 결과로 시뮬레이션 업데이트
                time += target.dist;
                sharkY = target.y;
                sharkX = target.x;
                map[sharkY][sharkX] = 0;    // 물고기 먹고 빈 칸으로

                // 3) 크기 증가 여부 체크
                if (++eaten == size) {
                    size++;
                    eaten = 0;
                }
            }
            System.out.println(time);

        }
    }

    static class Fish { 
        int y, x, dist;
        public Fish(int y, int x, int dist) {
            this.y = y;
            this.x = x;
            this.dist = dist;
        }
    }

    static Fish findNearestFish(int sy, int sx, int size) {
        boolean[][] visited = new boolean[n][n];
        Queue<Fish> q = new LinkedList<>();
        List<Fish> candidates = new ArrayList<>();
        visited[sy][sx] = true;
        q.offer(new Fish(sy, sx, 0));

        int minDist = Integer.MAX_VALUE;

        while (!q.isEmpty()) {
            Fish cur = q.poll();
            if (cur.dist > minDist) break;

            for (int d = 0; d < 4; d++) {
                int ny = cur.y + dr[d], nx = cur.x + dc[d];
                if (ny < 0 || ny >= n || nx < 0 || nx >= n || visited[ny][nx]) continue;
                if (map[ny][nx] > size) continue;

                visited[ny][nx] = true;
                int nd = cur.dist + 1;
                Fish next = new Fish(ny, nx, nd);

                // 먹을 수 있는 물고기일 때
                if (map[ny][nx] != 0 && map[ny][nx] < size) {
                    if (nd < minDist) {
                        // 더 가까운 물고기 발견 → 후보 초기화
                        candidates.clear();
                        candidates.add(next);
                        minDist = nd;
                    } else if (nd == minDist) {
                        // 같은 거리의 물고기 추가
                        candidates.add(next);
                    }
                }

                q.offer(next);
            }
        }

        if (candidates.isEmpty()) return null;

        // 가장 위(y), 왼쪽(x) 우선 정렬
        candidates.sort(Comparator
            .comparingInt((Fish f) -> f.y)
            .thenComparingInt(f -> f.x));

        Fish eat = candidates.get(0);
        eat.dist = minDist;
        return eat;
    }


}