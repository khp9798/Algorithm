import java.io.*;
import java.util.*;

class Main {

    // 정점의 개수
    static int n;

    // 간선의 개수
    static int m;

    // 간선정보
    static ArrayList<Integer>[] edge;

    static boolean[] visited;

    public static void main(String[] args) throws IOException {
        // 코드 작성
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            n = Integer.parseInt(st.nextToken());

            m = Integer.parseInt(st.nextToken());

            edge = new ArrayList[n];

            for (int i = 0; i < n; i++) {
                edge[i] = new ArrayList<Integer>();
            }

            for (int i = 0; i < m; i++) {
                st = new StringTokenizer(br.readLine());

                int a = Integer.parseInt(st.nextToken())-1;

                int b = Integer.parseInt(st.nextToken())-1;

                edge[a].add(b);

                edge[b].add(a);
            }

            visited = new boolean[n];

            int count = 0;

            for (int i = 0; i < n; i++) {
                if (!visited[i]) {
                    dfs(i);
                    count++;
                }
            }

            System.out.println(count);
        }
    }

    static void dfs(int v) {
        visited[v] = true;

        for (int i : edge[v]) {
            if (!visited[i]) {
                dfs(i);
            }
        }
    }
}