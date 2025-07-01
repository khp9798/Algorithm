import java.io.*;
import java.util.*;

public class Main {
    static int n, m, k;
    static int[] map;
    // 1차원으로 flatten: idx = r*m+c
    static boolean[] visited; 
    // bfs 큐용 원시 배열
    static int[] qr, qc, qb, qd, ql;
    static int front, rear;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());
        map = new int[n*m];
        for (int i = 0; i < n; i++) {
            String line = br.readLine();
            for (int j = 0; j < m; j++) {
                map[i*m + j] = line.charAt(j) - '0';
            }
        }
        // 최대 상태 수 = n*m*(k+1)*2
        int S = n*m*(k+1)*2;
        visited = new boolean[S];

        qr = new int[S]; qc = new int[S]; qb = new int[S];
        qd = new int[S]; ql = new int[S];
        front = rear = 0;

        // (0,0,k, 낮=0, len=1)
        enqueue(0, 0, k, 0, 1);
        visited[index(0,0,k,0)] = true;

        int[] dr = {-1,1,0,0}, dc = {0,0,-1,1};
        while (front < rear) {
            int r = qr[front], c = qc[front], b = qb[front];
            int d = qd[front], len = ql[front++];
            if (r==n-1 && c==m-1) {
                System.out.println(len);
                return;
            }
            int nextD = d^1;

            int base = r*m + c;
            // 4방향
            for (int i = 0; i < 4; i++) {
                int nr = r + dr[i], nc = c + dc[i];
                if (nr<0||nc<0||nr>=n||nc>=m) continue;
                int cell = map[nr*m + nc];
                if (cell == 0) {
                    int idx = index(nr,nc,b,nextD);
                    if (!visited[idx]) {
                        visited[idx] = true;
                        enqueue(nr,nc,b,nextD,len+1);
                    }
                } else {
                    // 벽일 때
                    if (d==0 && b>0) {
                        int idx = index(nr,nc,b-1,nextD);
                        if (!visited[idx]) {
                            visited[idx] = true;
                            enqueue(nr,nc,b-1,nextD,len+1);
                        }
                    } else if (d==1) {
                        // 밤에 벽 앞에서만 대기
                        int idx = index(r,c,b,nextD);
                        if (!visited[idx]) {
                            visited[idx] = true;
                            enqueue(r,c,b,nextD,len+1);
                        }
                    }
                }
            }
        }

        // 도달 못 하면
        System.out.println(-1);
    }

    // 상태(flatten) 인덱스 계산
    static int index(int r, int c, int b, int day) {
        return (((r*m + c)*(k+1) + b)<<1) | day;
    }

    // primitive 큐에 넣기
    static void enqueue(int r, int c, int b, int d, int len) {
        qr[rear] = r;
        qc[rear] = c;
        qb[rear] = b;
        qd[rear] = d;
        ql[rear++] = len;
    }
}
