
import java.io.*;
import java.util.*;

class Main {

    static class Node implements Comparable<Node> {

        int to, cost;

        Node(int to, int cost) {
            this.to = to;
            this.cost = cost;
        }

        @Override
        public int compareTo(Node o) {
            return this.cost - o.cost;
        }
    }

    static int n, e;

    static PriorityQueue<Node> pq = new PriorityQueue<>();

    static int[] dist;

    static boolean[] done;

    static List<Node>[] graph;

    static final int INF = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        // 코드 작성
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            n = Integer.parseInt(st.nextToken());
            e = Integer.parseInt(st.nextToken());

            graph = new ArrayList[n + 1];

            for (int i = 1; i <= n; i++) {
                graph[i] = new ArrayList<>();
            }

            for (int i = 0; i < e; i++) {
                st = new StringTokenizer(br.readLine());

                int a = Integer.parseInt(st.nextToken());
                int b = Integer.parseInt(st.nextToken());
                int c = Integer.parseInt(st.nextToken());

                graph[a].add(new Node(b, c));
                graph[b].add(new Node(a, c));
            }

            st = new StringTokenizer(br.readLine());

            int v1 = Integer.parseInt(st.nextToken());
            int v2 = Integer.parseInt(st.nextToken());

            // 다익스트라 3회 실행
            int[] d1 = dijkstra(1);
            int[] dv1 = dijkstra(v1);
            int[] dv2 = dijkstra(v2);

            // 두 경로 계산
            long path1 = Long.MAX_VALUE;
            long path2 = Long.MAX_VALUE;
            if (d1[v1] != INF && dv1[v2] != INF && dv2[n] != INF) {
                path1 = (long) d1[v1] + dv1[v2] + dv2[n];
            }
            if (d1[v2] != INF && dv2[v1] != INF && dv1[n] != INF) {
                path2 = (long) d1[v2] + dv2[v1] + dv1[n];
            }

            long ans = Math.min(path1, path2);
            System.out.println(ans == Long.MAX_VALUE ? -1 : ans);
        }
    }

    static int[] dijkstra(int start) {
        dist = new int[n + 1];

        done = new boolean[n + 1];

        Arrays.fill(dist, Integer.MAX_VALUE);
        Arrays.fill(done, false);
        pq.clear();

        dist[start] = 0;
        pq.offer(new Node(start, 0));

        while (!pq.isEmpty()) {
            Node cur = pq.poll();
            int u = cur.to;
            if (done[u]) {
                continue;
            }
            done[u] = true;

            for (Node next : graph[u]) {
                if (dist[next.to] > dist[u] + next.cost) {
                    dist[next.to] = dist[u] + next.cost;
                    pq.offer(new Node(next.to, dist[next.to]));
                }
            }
        }

        return dist;

    }
}
