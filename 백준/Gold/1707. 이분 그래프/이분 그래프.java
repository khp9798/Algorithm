import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

class Main {

    static int V;
    static int E;
    static boolean[] visited;
    static List<Integer>[] edges;

    static int[] colors;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());

        for (int t = 1; t <= T; t++) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            V = Integer.parseInt(st.nextToken());

            E = Integer.parseInt(st.nextToken());

            edges = new ArrayList[V + 1];

            for (int i = 1; i <= V; i++) {
                edges[i] = new ArrayList<>();
            }

            for (int i = 0; i < E; i++) {
                st = new StringTokenizer(br.readLine());

                int A = Integer.parseInt(st.nextToken());
                int B = Integer.parseInt(st.nextToken());

                edges[A].add(B);
                edges[B].add(A);
            }

            colors = new int[V + 1];
            visited = new boolean[V + 1];
            boolean isBipartite = true;

            for (int i = 1; i <= V; i++) {
                if (!visited[i]) {
                    if (!bfs(i, 1)) {
                        isBipartite = false;
                        break;
                    }
                }
            }

            System.out.println(isBipartite ? "YES" : "NO");
        }
    }

    private static boolean bfs(int idx, int color) {
        Queue<Node> q = new LinkedList<>();
        q.add(new Node(idx, color));
        visited[idx] = true;
        colors[idx] = color;

        while (!q.isEmpty()) {
            Node node = q.poll();
            int num = node.num;
            int color2 = node.color;

            for (int neighbor : edges[num]) {
                if (!visited[neighbor]) {
                    visited[neighbor] = true;
                    colors[neighbor] = 3 - color2;
                    q.add(new Node(neighbor, 3 - color2));
                } else if (colors[neighbor] == color2) {
                    return false; // 색이 동일하면 bipartite가 아님
                }
            }
        }

        return true;
    }

    static class Node {
        int num;
        int color;

        public Node(int num, int color) {
            this.num = num;
            this.color = color;
        }
    }
}
