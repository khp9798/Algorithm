
import java.io.*;
import java.util.*;

class Main {

    static int v, e, k;

    static class Edge {

        int end, cost;

        Edge(int end, int cost) {
            this.end = end;
            this.cost = cost;
        }
    }

    static boolean[] visited;

    static class Node implements Comparable<Node> {

        int to, cost;

        Node(int to, int cost){
            this.to = to;
            this.cost = cost;
        }

        @Override
        public int compareTo(Node o) {
            return this.cost - o.cost;
        }
    }

    public static void main(String[] args) throws IOException {
        // 코드 작성
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            v = Integer.parseInt(st.nextToken());
            e = Integer.parseInt(st.nextToken());

            visited = new boolean[v + 1];

            k = Integer.parseInt(br.readLine());

            List<Edge>[] graph = new ArrayList[v + 1];

            for (int i = 1; i <= v; i++) {
                graph[i] = new ArrayList<>();
            }

            for (int i = 0; i < e; i++) {
                st = new StringTokenizer(br.readLine());

                int u = Integer.parseInt(st.nextToken());
                int v = Integer.parseInt(st.nextToken());
                int w = Integer.parseInt(st.nextToken());

                graph[u].add(new Edge(v, w));
            }

            final int INF = Integer.MAX_VALUE;
            
            int[] dist = new int[v + 1];

            Arrays.fill(dist, INF);

            dist[k] = 0;

            PriorityQueue<Node> pq = new PriorityQueue<>();
            pq.offer(new Node(k, 0));

            while (!pq.isEmpty()) {
                Node cur = pq.poll();
                if (visited[cur.to]) {
                    continue;
                }
                visited[cur.to] = true;

                for (Edge e : graph[cur.to]) {
                    if (dist[e.end] > cur.cost + e.cost) {
                        dist[e.end] = cur.cost + e.cost;
                        pq.offer(new Node(e.end, dist[e.end]));
                    }
                }
            }

            StringBuilder sb = new StringBuilder();
            for (int i = 1; i <= v; i++) {
                sb.append(dist[i] == INF ? "INF" : dist[i]).append('\n');
            }
            System.out.print(sb);

        }
    }
}
