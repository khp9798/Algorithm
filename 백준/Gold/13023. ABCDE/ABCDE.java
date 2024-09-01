import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {

    static int N, M;
    static ArrayList<Integer>[] adj;
    static boolean[] visited;
    static boolean found;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        adj = new ArrayList[N];
        visited = new boolean[N];

        for (int i = 0; i < N; i++) {
            adj[i] = new ArrayList<>();
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            adj[a].add(b);
            adj[b].add(a);
        }

        found = false;

        for (int i = 0; i < N; i++) {
            visited[i] = true;
            dfs(i, 1);
            visited[i] = false;
            if (found) break;
        }

        System.out.println(found ? 1 : 0);
    }

    private static void dfs(int node, int depth) {
        if (depth == 5) {  // 깊이 5에 도달했다는 것은 A-B-C-D-E를 찾았다는 의미
            found = true;
            return;
        }

        for (int next : adj[node]) {
            if (!visited[next]) {
                visited[next] = true;
                dfs(next, depth + 1);
                visited[next] = false;
                if (found) return;  // 이미 찾았으면 더 이상 재귀할 필요 없음
            }
        }
    }
}
