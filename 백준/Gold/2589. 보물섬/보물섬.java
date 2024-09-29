import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {

	static class Node {
		int r;
		int c;
		int dist;

		public Node(int r, int c, int dist) {
			super();
			this.r = r;
			this.c = c;
			this.dist = dist;
		}

		@Override
		public String toString() {
			return "Node [r=" + r + ", c=" + c + ", dist=" + dist + "]";
		}

	}

	static int N;
	static int M;

	static char[][] map;
	static boolean[][] visited;
	static int[][] dist;

	static int[] dr = { -1, 1, 0, 0 };
	static int[] dc = { 0, 0, -1, 1 };
	
	static int max = Integer.MIN_VALUE;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		N = sc.nextInt();
		M = sc.nextInt();

		map = new char[N][M];

		for (int r = 0; r < N; r++) {
			String str = sc.next();
			for (int c = 0; c < M; c++) {
				map[r][c] = str.charAt(c);
			}
		}

		for (int r = 0; r < N; r++) {
			for (int c = 0; c < M; c++) {
				if (map[r][c] == 'L') {
					bfs(r, c);
				}
			}
		}
		
		System.out.println(max);
	}

	private static void bfs(int r, int c) {
		visited = new boolean[N][M];
		dist = new int[N][M];

		Queue<Node> q = new LinkedList<>();
		q.add(new Node(r, c, 0));
		visited[r][c] = true;

		while (!q.isEmpty()) {
			Node n = q.poll();

			dist[n.r][n.c] = n.dist;

			for (int d = 0; d < 4; d++) {
				int nr = n.r + dr[d];
				int nc = n.c + dc[d];

				if (nr < 0 || nc < 0 || nr >= N || nc >= M)
					continue;

				if (visited[nr][nc] || map[nr][nc] == 'W')
					continue;

				visited[nr][nc] = true;
				q.add(new Node(nr, nc, n.dist + 1));
			}
		}

		
		
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				max = Math.max(max, dist[i][j]);
			}
		}

	}

}
