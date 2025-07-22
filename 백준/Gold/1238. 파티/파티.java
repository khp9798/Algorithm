import java.io.*;
import java.util.*;

public class Main {
    static final int INF = Integer.MAX_VALUE;
    static class Node implements Comparable<Node> {
        int v, w;
        Node(int v, int w) { this.v = v; this.w = w; }
        public int compareTo(Node o) { return this.w - o.w; }
    }

    // Dijkstra: 시작점 src에서 모든 정점까지 최단 거리 배열 반환
    static int[] dijkstra(int n, int src, List<Node>[] adj) {
        int[] dist = new int[n+1];
        Arrays.fill(dist, INF);
        PriorityQueue<Node> pq = new PriorityQueue<>();
        dist[src] = 0;
        pq.add(new Node(src, 0));

        while (!pq.isEmpty()) {
            Node cur = pq.poll();
            if (cur.w > dist[cur.v]) continue;  // 이미 더 짧은 경로가 발견된 경우 스킵

            for (Node nxt : adj[cur.v]) {
                int nd = cur.w + nxt.w;
                if (nd < dist[nxt.v]) {
                    dist[nxt.v] = nd;
                    pq.add(new Node(nxt.v, nd));
                }
            }
        }
        return dist;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());  // 마을 수
        int m = Integer.parseInt(st.nextToken());  // 도로 수
        int x = Integer.parseInt(st.nextToken());  // 파티 마을

        List<Node>[] graph       = new ArrayList[n+1];
        List<Node>[] revGraph    = new ArrayList[n+1];
        for (int i = 1; i <= n; i++) {
            graph[i]    = new ArrayList<>();
            revGraph[i] = new ArrayList<>();
        }

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());
            graph[u].add(new Node(v, w));      // u → v
            revGraph[v].add(new Node(u, w));   // v → u (역방향)
        }

        // x → i, i → x 최단 거리 배열
        int[] distFromX = dijkstra(n, x, graph);
        int[] distToX   = dijkstra(n, x, revGraph);

        // 최대 왕복 시간 계산
        int answer = 0;
        for (int i = 1; i <= n; i++) {
            // 불가능한 경로는 건너뜀
            if (distToX[i] == INF || distFromX[i] == INF) continue;
            answer = Math.max(answer, distToX[i] + distFromX[i]);
        }

        System.out.println(answer);
    }
}
