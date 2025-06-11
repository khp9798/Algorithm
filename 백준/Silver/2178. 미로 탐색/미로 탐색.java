

import java.util.*;

public class Main {

	static int[][] miro;
	static boolean[][] vis;
	static int[] dr = { -1, 1, 0, 0 };
	static int[] dc = { 0, 0, -1, 1 };

	static int n, m;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		n = sc.nextInt();
		m = sc.nextInt();

		miro = new int[n][m];
		vis = new boolean[n][m];

		for (int r = 0; r < n; r++) {
			String str = sc.next();

			for (int c = 0; c < m; c++) {
				miro[r][c] = str.charAt(c) - '0';
			}
		}

		System.out.println(bfs(0, 0));

	}

	static int bfs(int r, int c) {
		Queue<int[]> q = new LinkedList<>();
		vis[r][c] = true;
		q.add(new int[] { r, c, 1 });

		while (!q.isEmpty()) {
			int[] rc = q.poll();

			int curR = rc[0];
			int curC = rc[1];

			if (curR == n - 1 && curC == m - 1)
				return rc[2];

			for (int d = 0; d < 4; d++) {
				int nr = curR + dr[d];
				int nc = curC + dc[d];

				if (nr < 0 || nc < 0 || nr >= n || nc >= m)
					continue;
				if (vis[nr][nc] || miro[nr][nc] == 0)
					continue;

				vis[nr][nc] = true;
				q.add(new int[] { nr, nc, rc[2] + 1 });
			}
		}

		return -1;
	}

}
