import java.util.*;

class Solution {
    static class Node implements Comparable<Node> {
        int to, cost;
        Node(int to, int cost) {
            this.to = to;
            this.cost = cost;
        }
        @Override
        public int compareTo(Node o) {
            return this.cost - o.cost; // 비용이 작은 순으로
        }
    }

    static final int INF = 20000001; // 충분히 큰 값 (최대 요금 * 최대 노드 수)
    static List<Node>[] graph;

    // 다익스트라 함수
    static int[] dijkstra(int start, int n) {
        int[] dist = new int[n + 1];
        Arrays.fill(dist, INF);
        dist[start] = 0;

        PriorityQueue<Node> pq = new PriorityQueue<>();
        pq.offer(new Node(start, 0));

        while (!pq.isEmpty()) {
            Node cur = pq.poll();
            int now = cur.to;
            int nowCost = cur.cost;

            if (dist[now] < nowCost) continue;

            for (Node next : graph[now]) {
                int newCost = nowCost + next.cost;
                if (dist[next.to] > newCost) {
                    dist[next.to] = newCost;
                    pq.offer(new Node(next.to, newCost));
                }
            }
        }
        return dist;
    }

    public int solution(int n, int s, int a, int b, int[][] fares) {
        // 그래프 초기화
        graph = new ArrayList[n + 1];
        for (int i = 1; i <= n; i++) {
            graph[i] = new ArrayList<>();
        }

        for (int[] fare : fares) {
            int u = fare[0];
            int v = fare[1];
            int cost = fare[2];
            graph[u].add(new Node(v, cost));
            graph[v].add(new Node(u, cost));
        }

        // s, a, b 각각에서 다익스트라 실행
        int[] fromS = dijkstra(s, n);
        int[] fromA = dijkstra(a, n);
        int[] fromB = dijkstra(b, n);

        // 모든 분기점 k에 대해 최소 비용 계산
        int answer = INF;
        for (int k = 1; k <= n; k++) {
            if (fromS[k] == INF || fromA[k] == INF || fromB[k] == INF) continue;
            answer = Math.min(answer, fromS[k] + fromA[k] + fromB[k]);
        }

        return answer;
    }
}
