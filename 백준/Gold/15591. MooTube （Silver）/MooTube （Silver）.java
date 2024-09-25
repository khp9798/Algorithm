import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

class Main {
	static class Edge {
		int p;
		int q;
		int r;

		public Edge(int p, int q, int r) {
			super();
			this.p = p;
			this.q = q;
			this.r = r;
		}

		@Override
		public String toString() {
			return "Edge [p=" + p + ", q=" + q + ", r=" + r + "]";
		}

	}

	static int N;
	static int Q;

	static List<Edge>[] edges;

	static int k;
	static int v;

	static boolean[] visited;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());

		Q = Integer.parseInt(st.nextToken());

		edges = new ArrayList[N + 1];

		for (int i = 1; i <= N; i++) {
			edges[i] = new ArrayList<>();
		}

		for (int i = 0; i < N - 1; i++) {
			st = new StringTokenizer(br.readLine());

			int p = Integer.parseInt(st.nextToken());
			int q = Integer.parseInt(st.nextToken());
			int r = Integer.parseInt(st.nextToken());

			edges[p].add(new Edge(p, q, r));
			edges[q].add(new Edge(q, p, r));
		}

		for (int i = 0; i < Q; i++) {
			st = new StringTokenizer(br.readLine());

			k = Integer.parseInt(st.nextToken());
			v = Integer.parseInt(st.nextToken());

			System.out.println(bfs(k, v));

		}

	}

	private static int bfs(int K, int start) {
		visited = new boolean[N + 1];
		int[] dist = new int[N + 1];
		Arrays.fill(dist, Integer.MAX_VALUE);
		Queue<Edge> q = new LinkedList<>();
		q.addAll(edges[start]);
		visited[start] = true;

		while (!q.isEmpty()) {
			Edge e1 = q.poll();

			int curr = e1.p;
			int next = e1.q;
			int nextusado = e1.r;

			if (visited[next])
				continue;
			visited[next] = true;

			dist[next] = Math.min(nextusado, dist[curr]);

			q.addAll(edges[next]);

		}

//		System.out.println(Arrays.toString(dist));

		int count = 0;
		for (int i = 1; i <= N; i++) {
			if (dist[i] != Integer.MAX_VALUE && dist[i] >= k) {
				count++;
			}
		}

		return count;
	}
}