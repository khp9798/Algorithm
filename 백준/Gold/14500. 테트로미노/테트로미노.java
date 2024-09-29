import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    
    static int N;
    static int M;
    
    static int [][] map;
    static boolean [][] visited;
    
    static List<int []> four = new ArrayList<>();
    
    static int [] dr = {-1,1,0,0};
    static int [] dc = {0,0,-1,1};
    
    static int res=Integer.MIN_VALUE;
    
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        
        map = new int[N][M];
        visited = new boolean[N][M];
        
        for(int r=0; r<N; r++) {
            st = new StringTokenizer(br.readLine());
            for( int c=0; c<M; c++) {
                map[r][c] = Integer.parseInt(st.nextToken());
            }
        }
        
        // 모든 좌표에서 DFS 및 ㅗ 모양 체크
        for (int r = 0; r < N; r++) {
            for (int c = 0; c < M; c++) {
                dfsMap(r, c, 1, map[r][c]);
                checkTShape(r, c); // ㅗ 모양은 DFS로 처리할 수 없으므로 별도 처리
            }
        }
        
        System.out.println(res);
    }

    // 인접한 칸을 DFS로 탐색하며 4칸을 찾는 방식으로 변경
    private static void dfsMap(int r, int c, int depth, int sum) {
        if (depth == 4) {
            res = Math.max(res, sum); // 4칸을 모두 선택하면 결과 업데이트
            return;
        }

        visited[r][c] = true;

        // 4방향 탐색
        for (int d = 0; d < 4; d++) {
            int nr = r + dr[d];
            int nc = c + dc[d];

            if (nr < 0 || nc < 0 || nr >= N || nc >= M) continue;
            if (!visited[nr][nc]) {
                dfsMap(nr, nc, depth + 1, sum + map[nr][nc]);
            }
        }

        visited[r][c] = false; // 백트래킹
    }

    // ㅗ 모양 테트로미노를 처리하는 함수
    private static void checkTShape(int r, int c) {
        // ㅗ 모양 4가지 경우를 각각 체크
        if (r >= 1 && r < N - 1 && c >= 1) {
            // ㅗ 모양
            int sum = map[r][c] + map[r-1][c] + map[r+1][c] + map[r][c-1];
            res = Math.max(res, sum);
        }
        if (r >= 1 && r < N - 1 && c < M - 1) {
            // ㅜ 모양
            int sum = map[r][c] + map[r-1][c] + map[r+1][c] + map[r][c+1];
            res = Math.max(res, sum);
        }
        if (r >= 1 && c >= 1 && c < M - 1) {
            // ㅏ 모양
            int sum = map[r][c] + map[r-1][c] + map[r][c-1] + map[r][c+1];
            res = Math.max(res, sum);
        }
        if (r < N - 1 && c >= 1 && c < M - 1) {
            // ㅓ 모양
            int sum = map[r][c] + map[r+1][c] + map[r][c-1] + map[r][c+1];
            res = Math.max(res, sum);
        }
    }
}
