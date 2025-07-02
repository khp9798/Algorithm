
import java.io.*;
import java.util.*;

class Main {

    static class City implements Comparable<City> {

        int to, cost;

        City(int to, int cost) {
            this.to = to;
            this.cost = cost;
        }

        @Override
        public int compareTo(City o) {
            return this.cost - o.cost;
        }

    }

    public static void main(String[] args) throws IOException {
        // 코드 작성
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {

            int n = Integer.parseInt(br.readLine());

            int m = Integer.parseInt(br.readLine());

            List<City>[] graph = new ArrayList[n + 1];

            for (int i = 1; i <= n; i++) {
                graph[i] = new ArrayList<>();
            }

            StringTokenizer st;
            for (int i = 0; i < m; i++) {
                st = new StringTokenizer(br.readLine());

                int sc = Integer.parseInt(st.nextToken());

                int ec = Integer.parseInt(st.nextToken());

                int cost = Integer.parseInt(st.nextToken());

                graph[sc].add(new City(ec, cost));
            }

            st = new StringTokenizer(br.readLine());

            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());

            int[] dist = new int[n + 1];

            int INF = Integer.MAX_VALUE;

            Arrays.fill(dist, INF);

            dist[start] = 0;

            PriorityQueue<City> pq = new PriorityQueue<>();

            pq.offer(new City(start, 0));

            boolean[] gone = new boolean[n + 1];
            while (!pq.isEmpty()) {
                City cur = pq.poll();
                if (gone[cur.to]) {
                    continue;
                }
                gone[cur.to] = true;

                for (City c : graph[cur.to]) {
                    if (dist[c.to] > dist[cur.to] + c.cost) {
                        dist[c.to] = dist[cur.to] + c.cost;
                        pq.offer(new City(c.to, dist[c.to]));
                    }
                }
            }

            System.out.println(dist[end]);
        }
    }

}
