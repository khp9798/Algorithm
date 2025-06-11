

import java.util.*;
import java.io.*;

public class Main {

	static int n, m;
	static int[][] bucket;
	static boolean[][] vis;
	static int[] dr = { -1, 1, 0, 0 };
	static int[] dc = { 0, 0, -1, 1 };
	static Queue<int[]> q = new LinkedList<>();

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine());

		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());

		bucket = new int[m][n];
		vis = new boolean[m][n];

		for (int r = 0; r < m; r++) {
			st = new StringTokenizer(br.readLine());
			for (int c = 0; c < n; c++) {
				bucket[r][c] = Integer.parseInt(st.nextToken());
				if (bucket[r][c] == 1) {
					vis[r][c] = true;
					q.add(new int[] { r, c, 0 });
				}
			}
		}

		System.out.println(bfs());

	}

	static int bfs() {
		int day = -1;
		while (!q.isEmpty()) {
			int[] rc = q.poll();

			int curR = rc[0];
			int curC = rc[1];

			day = Math.max(day, rc[2]);

			for (int d = 0; d < 4; d++) {
				int nr = curR + dr[d];
				int nc = curC + dc[d];

				if (nr < 0 || nc < 0 || nr >= m || nc >= n)
					continue;
				if (vis[nr][nc] || bucket[nr][nc] == -1)
					continue;

				vis[nr][nc] = true;
				q.add(new int[] { nr, nc, rc[2] + 1 });
			}
		}

		if (check())
			return day;
		return -1;
	}

	static boolean check() {
		for (int r = 0; r < m; r++) {
			for (int c = 0; c < n; c++) {
				if (bucket[r][c] != -1 && !vis[r][c])
					return false;
			}
		}

		return true;
	}
}
