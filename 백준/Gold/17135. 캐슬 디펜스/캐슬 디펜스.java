import java.io.*;
import java.util.*;

public class Main {

    static int N, M, D;
    static int[][] origin;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        D = Integer.parseInt(st.nextToken());

        origin = new int[N][M];
        for (int r = 0; r < N; r++) {
            st = new StringTokenizer(br.readLine());
            for (int c = 0; c < M; c++) {
                origin[r][c] = Integer.parseInt(st.nextToken());
            }
        }

        int ans = 0;
        // 궁수 3명 자리 조합 (아래 가상의 N행, 열 0..M-1)
        for (int a = 0; a < M - 2; a++) {
            for (int b = a + 1; b < M - 1; b++) {
                for (int c = b + 1; c < M; c++) {
                    ans = Math.max(ans, simulate(a, b, c));
                }
            }
        }
        System.out.println(ans);
    }

    // 시뮬레이션: 궁수 열 3개를 받아 최대 처치 수 계산
    static int simulate(int ar1, int ar2, int ar3) {
        int[][] map = copyBoard(origin);
        int kill = 0;

        // 라운드: 적이 모두 사라질 때까지 (최대 N번 이동하면 끝)
        for (int round = 0; round < N; round++) {
            // 이번 턴에 세 궁수가 조준한 타깃들을 모아 중복 처치 방지
            // (같은 적을 여러 궁수가 골라도 한 번만 제거)
            Set<Long> targets = new HashSet<>();

            int[] archers = { ar1, ar2, ar3 };
            for (int col : archers) {
                int[] t = pickTarget(map, col);
                if (t != null) {
                    long key = ((long)t[0] << 20) | t[1]; // (r,c) 압축
                    targets.add(key);
                }
            }

            // 타깃 제거
            for (long key : targets) {
                int r = (int)(key >> 20);
                int c = (int)(key & ((1 << 20) - 1));
                if (map[r][c] == 1) {
                    map[r][c] = 0;
                    kill++;
                }
            }

            // 적 하강
            moveDown(map);
        }
        return kill;
    }

    // 해당 궁수 열에서 사거리 D 이내, "거리 최소 -> 열 작은 순" 타깃 선정
    static int[] pickTarget(int[][] map, int arCol) {
        int bestDist = Integer.MAX_VALUE;
        int bestR = -1, bestC = -1;

        for (int r = 0; r < N; r++) {
            for (int c = 0; c < M; c++) {
                if (map[r][c] != 1) continue;
                int dist = Math.abs(N - r) + Math.abs(arCol - c); // 궁수는 행 N(바로 아래)로 가정
                if (dist > D) continue;

                if (dist < bestDist || (dist == bestDist && c < bestC)) {
                    bestDist = dist;
                    bestR = r;
                    bestC = c;
                }
            }
        }
        return (bestR == -1) ? null : new int[]{bestR, bestC};
    }

    static void moveDown(int[][] map) {
        for (int r = N - 1; r >= 1; r--) {
            for (int c = 0; c < M; c++) {
                map[r][c] = map[r - 1][c];
            }
        }
        Arrays.fill(map[0], 0);
    }

    static int[][] copyBoard(int[][] src) {
        int[][] dst = new int[N][M];
        for (int i = 0; i < N; i++) dst[i] = Arrays.copyOf(src[i], M);
        return dst;
    }
}
