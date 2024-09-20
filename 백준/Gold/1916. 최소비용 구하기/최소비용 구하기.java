import java.util.*;
import java.io.*;

class Main {
	static class bus implements Comparable<bus> {
		int to;
		int W;

		public bus(int to, int w) {
			super();
			this.to = to;
			W = w;
		}

		@Override
		public int compareTo(bus o) {
			// TODO Auto-generated method stub
			return this.W - o.W;
		}

		@Override
		public String toString() {
			return "bus [to=" + to + ", W=" + W + "]";
		}

	}

	static int N;
	static int M;
	static List<bus>[] bus;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		N = Integer.parseInt(br.readLine());
		M = Integer.parseInt(br.readLine());

		bus = new ArrayList[N + 1];
		for (int i = 0; i <= N; i++) {
			bus[i] = new ArrayList<>();
		}
		StringTokenizer st;
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());

			int from = Integer.parseInt(st.nextToken());
			int to = Integer.parseInt(st.nextToken());
			int W = Integer.parseInt(st.nextToken());

			bus[from].add(new bus(to, W));
		}

		int[] dist = new int[N + 1];
		boolean[] visited = new boolean[N + 1];

		st = new StringTokenizer(br.readLine());

		int start = Integer.parseInt(st.nextToken());
		int dest = Integer.parseInt(st.nextToken());

		Arrays.fill(dist, Integer.MAX_VALUE);

		dist[start] = 0;

		PriorityQueue<bus> pq = new PriorityQueue<>();

		pq.add(new bus(start, 0));
//		visited[start] = true;

		while (!pq.isEmpty()) {
			bus currbus = pq.poll();
			int curr = currbus.to;
			int W = currbus.W;

			if (visited[curr])
				continue;
			visited[curr] = true;

			for (bus bus1 : bus[curr]) {
				int nextTo = bus1.to;
				int nextdist = dist[curr] + bus1.W;

				if (nextdist < dist[nextTo]) {
					dist[nextTo] = nextdist;
					pq.add(new bus(nextTo,nextdist));
				}

				
			}

		}

		System.out.println(dist[dest]);

	}
}