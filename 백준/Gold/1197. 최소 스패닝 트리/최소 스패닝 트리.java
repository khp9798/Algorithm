import java.io.*;
import java.util.*;

class Main {

    static int v, e;

    static class Edge implements Comparable<Edge> {
        int a;
        int b;
        int cost;

        Edge(int a, int b, int cost) {
            this.a = a;
            this.b = b;
            this.cost = cost;
        }

        @Override
        public int compareTo(Edge o) {
            return this.cost - o.cost;
        }
    }

    static List<Edge> edges;

    static int[] p;

    public static void main(String[] args) throws IOException {
        // 코드 작성
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            v = Integer.parseInt(st.nextToken());
            e = Integer.parseInt(st.nextToken());

            edges = new ArrayList<>();

            for (int i = 0; i < e; i++) {
                st = new StringTokenizer(br.readLine());
                int a = Integer.parseInt(st.nextToken());
                int b = Integer.parseInt(st.nextToken());
                int c = Integer.parseInt(st.nextToken());

                edges.add(new Edge(a, b, c));
            }

            Collections.sort(edges);

            p = new int[v + 1];
            for (int i = 1; i <= v; i++) {
                p[i] = i;
            }

            long total = 0;

            for (Edge e : edges) {
                if (find(e.a) != find(e.b)) {
                    union(e.a, e.b);
                    total += e.cost;
                }
            }

            System.out.println(total);
        }
    }

    static int find(int x) {
        if (p[x] == x)
            return p[x];
        return p[x] = find(p[x]);
    }

    static void union(int x, int y) {
        int rx = find(x);
        int ry = find(y);
        if (rx != ry) {
            p[ry] = rx;
        }
    }
}