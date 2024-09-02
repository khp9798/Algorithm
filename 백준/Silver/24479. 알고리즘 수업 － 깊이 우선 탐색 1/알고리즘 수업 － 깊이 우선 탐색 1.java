import java.util.*;

public class Main {

    static int N, M, R;
    static List<Integer>[] graph;
    static int[] visitOrder;
    static int order;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        N = sc.nextInt();
        M = sc.nextInt();
        R = sc.nextInt();

        graph = new ArrayList[N + 1];
        visitOrder = new int[N + 1];
        order = 1;

        for (int i = 1; i <= N; i++) {
            graph[i] = new ArrayList<>();
        }

        for (int i = 0; i < M; i++) {
            int u = sc.nextInt();
            int v = sc.nextInt();
            graph[u].add(v);
            graph[v].add(u);
        }

        // 인접 리스트 오름차순 정렬
        for (int i = 1; i <= N; i++) {
            Collections.sort(graph[i]);
        }

        dfs(R);

        for (int i = 1; i <= N; i++) {
            System.out.println(visitOrder[i]);
        }
    }

    static void dfs(int node) {
        visitOrder[node] = order++;

        for (int next : graph[node]) {
            if (visitOrder[next] == 0) {
                dfs(next);
            }
        }
    }
}
