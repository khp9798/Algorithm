

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

	static int n;
	static boolean[][] visited;
	static int destinationR;
	static int destinationC;

	// 나이트가 움직일 수 있는 경우의 수
	static int[] dr = { -2, -2, -1, 1, -1, 1, 2, 2 };
	static int[] dc = { -1, 1, -2, -2, 2, 2, -1, 1 };

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int T = Integer.parseInt(br.readLine());

		for (int t = 0; t < T; t++) {
			n = Integer.parseInt(br.readLine());

			visited = new boolean[n][n];

			StringTokenizer st = new StringTokenizer(br.readLine());

			int startR = Integer.parseInt(st.nextToken());
			int startC = Integer.parseInt(st.nextToken());

			st = new StringTokenizer(br.readLine());
			destinationR = Integer.parseInt(st.nextToken());
			destinationC = Integer.parseInt(st.nextToken());

			bfs(startR, startC);

			System.out.println(res);

			res = 0;
		}

	}

	static class Knight {
		int r;
		int c;
		int cnt;

		public Knight(int r, int c, int cnt) {
			super();
			this.r = r;
			this.c = c;
			this.cnt = cnt;
		}

	}

	static int res = 0;

	static void bfs(int r, int c) {
		Queue<Knight> queue = new LinkedList<>();
		queue.add(new Knight(r, c, 0));
		visited[r][c] = true;

		while (!queue.isEmpty()) {
			Knight k = queue.poll();

			int row = k.r;
			int col = k.c;

			int count = k.cnt;

			if (row == destinationR && col == destinationC) {
				res = count;
				return;
			}

			for (int d = 0; d < dr.length; d++) {
				int nr = row + dr[d];
				int nc = col + dc[d];

				if (0 <= nr && nr < n && 0 <= nc && nc < n && !visited[nr][nc]) {
					visited[nr][nc] = true;
					queue.add(new Knight(nr, nc, count + 1));
				}
			}
		}

	}

}
