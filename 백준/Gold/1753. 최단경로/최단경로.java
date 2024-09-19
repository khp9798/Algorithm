import java.io.*;
import java.util.*;

class Main {

    static int V;
    static int E;
    static int K;

    static class Edge implements Comparable<Edge> {
        int to;
        int W;

        public Edge(int to, int w) {
            this.to = to;
            this.W = w;
        }

        @Override
        public int compareTo(Edge o) {
            return this.W - o.W;  // 가중치를 기준으로 오름차순 정렬
        }
    }

    // 간선 정보를 저장할 리스트
    static List<List<Edge>> edges = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        V = Integer.parseInt(st.nextToken());  // 노드 수
        E = Integer.parseInt(st.nextToken());  // 간선 수
        K = Integer.parseInt(br.readLine());   // 시작 노드

        // 그래프 초기화
        for (int i = 0; i <= V; i++) {
            edges.add(new ArrayList<>());
        }

        // 간선 정보 입력
        for (int i = 0; i < E; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            int W = Integer.parseInt(st.nextToken());
            edges.get(start).add(new Edge(end, W));
        }

        // 최단 거리 배열 및 방문 여부 배열
        int[] dist = new int[V + 1];
        boolean[] visited = new boolean[V + 1];

        Arrays.fill(dist, Integer.MAX_VALUE);  // 초기값을 무한대로 설정
        dist[K] = 0;  // 시작 노드의 거리는 0

        // 우선순위 큐 선언 (최소 가중치 기준으로 탐색)
        PriorityQueue<Edge> pq = new PriorityQueue<>();
        pq.add(new Edge(K, 0));

        // 다익스트라 알고리즘
        while (!pq.isEmpty()) {
            Edge current = pq.poll();
            int currNode = current.to;

            // 이미 방문한 노드이면 무시
            if (visited[currNode]) continue;
            visited[currNode] = true;

            // 현재 노드에서 연결된 노드들의 거리 갱신
            for (Edge edge : edges.get(currNode)) {
                int nextNode = edge.to;
                int nextDist = dist[currNode] + edge.W;

                // 새로운 거리가 기존 거리보다 작으면 갱신하고 우선순위 큐에 추가
                if (nextDist < dist[nextNode]) {
                    dist[nextNode] = nextDist;
                    pq.add(new Edge(nextNode, nextDist));
                }
            }
        }

        // 결과 출력
        for (int i = 1; i <= V; i++) {
            if (dist[i] == Integer.MAX_VALUE) {
                System.out.println("INF");
            } else {
                System.out.println(dist[i]);
            }
        }
    }
}
