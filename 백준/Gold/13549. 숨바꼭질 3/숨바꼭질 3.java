

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {

	static boolean[] visited = new boolean[100001];

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine());

		int N = Integer.parseInt(st.nextToken());

		int K = Integer.parseInt(st.nextToken());

		bfs(N, K, 0);

		System.out.println(res);
	}

	static class subin implements Comparable<subin> {
		int x;
		int sec;

		public subin(int x, int sec) {
			super();
			this.x = x;
			this.sec = sec;
		}

		@Override
		public int compareTo(subin o) {
			// TODO Auto-generated method stub
			return (this.sec < o.sec ? -1 : 1);
		}

	}

	static int res = -1;

	static void bfs(int start, int end, int a) {
		PriorityQueue<subin> queue = new PriorityQueue<>();
		queue.add(new subin(start, a));
		visited[start] = true;

		while (!queue.isEmpty()) {
			subin s = queue.poll();

			int x = s.x;
			int sec = s.sec;

			visited[x] = true;

			if (x == end) {
				res = sec;

				return;
			}

			int case1 = x - 1;
			int case2 = x + 1;
			int case3 = x * 2;

			if (0 <= case1 && !visited[case1]) {

				queue.add(new subin(case1, sec + 1));
			}
			if (case2 <= 100000 && !visited[case2]) {

				queue.add(new subin(case2, sec + 1));
			}
			if (case3 <= 100000 && !visited[case3]) {

				queue.add(new subin(case3, sec));
			}
		}
	}
}
