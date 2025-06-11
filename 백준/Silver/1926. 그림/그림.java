
import java.util.*;
import java.io.*;

public class Main {

	static int[][] board;
	static boolean[][] vis;
	static int[] dr = { -1, 1, 0, 0 };
	static int[] dc = { 0, 0, -1, 1 };
	static int n, m;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine());
		// 가로 세로 크기
		n = Integer.parseInt(st.nextToken());

		m = Integer.parseInt(st.nextToken());

		board = new int[n][m];
		vis = new boolean[n][m];

		for (int r = 0; r < n; r++) {
			st = new StringTokenizer(br.readLine());
			for (int c = 0; c < m; c++) {
				board[r][c] = Integer.parseInt(st.nextToken());
			}
		}

		int count = 0;
		int area = 0;
		for (int r = 0; r < n; r++) {
			for (int c = 0; c < m; c++) {
				if (!vis[r][c] && board[r][c] == 1) {
					count++;
					area = Math.max(bfs(r, c), area);
				}
			}
		}

		System.out.println(count);
		System.out.println(area);

	}

	static int bfs(int r, int c) {
		Queue<int[]> q = new LinkedList<>();
		vis[r][c] = true;
		q.add(new int[] { r, c });

		int area = 0;

		while (!q.isEmpty()) {
			int[] rc = q.poll();
			int curR = rc[0];
			int curC = rc[1];

			area++;

			for (int d = 0; d < 4; d++) {
				int nr = curR + dr[d];
				int nc = curC + dc[d];

				if (nr < 0 || nc < 0 || nr >= n || nc >= m)
					continue;
				if (vis[nr][nc] || board[nr][nc] != 1)
					continue;

				vis[nr][nc] = true;
				q.add(new int[] { nr, nc });
			}
		}

		return area;
	}
}
