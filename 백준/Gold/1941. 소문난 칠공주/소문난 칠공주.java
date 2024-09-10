import java.util.*;

class Main {

    static char[][] map = new char[5][5];
    static int[] dr = {-1, 1, 0, 0};
    static int[] dc = {0, 0, -1, 1};
    static int res = 0;
    static List<int[]> selected = new ArrayList<>();

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        for (int i = 0; i < 5; i++) {
            map[i] = sc.next().toCharArray();
        }

        // 25개의 칸 중 7개의 칸을 선택하는 조합 생성
        select(0, 0);

        System.out.println(res);
    }

    private static void select(int start, int depth) {
        if (depth == 7) {
            if (isValid()) {
                res++;
            }
            return;
        }

        for (int i = start; i < 25; i++) {
            int r = i / 5;
            int c = i % 5;
            selected.add(new int[] {r, c});
            select(i + 1, depth + 1);
            selected.remove(selected.size() - 1);
        }
    }

    private static boolean isValid() {
        boolean[][] visited = new boolean[5][5];
        Queue<int[]> q = new LinkedList<>();
        q.add(selected.get(0));
        visited[selected.get(0)[0]][selected.get(0)[1]] = true;

        int connected = 1;
        int scount = 0;

        if (map[selected.get(0)[0]][selected.get(0)[1]] == 'S') {
            scount++;
        }

        while (!q.isEmpty()) {
            int[] curr = q.poll();

            for (int d = 0; d < 4; d++) {
                int nr = curr[0] + dr[d];
                int nc = curr[1] + dc[d];

                if (nr < 0 || nc < 0 || nr >= 5 || nc >= 5) continue;

                for (int[] s : selected) {
                    if (s[0] == nr && s[1] == nc && !visited[nr][nc]) {
                        visited[nr][nc] = true;
                        q.add(new int[] {nr, nc});
                        connected++;

                        if (map[nr][nc] == 'S') {
                            scount++;
                        }
                    }
                }
            }
        }

        return connected == 7 && scount >= 4;
    }
}
