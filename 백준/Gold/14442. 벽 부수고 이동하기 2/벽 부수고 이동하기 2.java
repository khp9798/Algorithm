

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

	static int N;
	static int M;
	static int K;

	static int[][] map;
	static boolean[][][] visited;

	static int[] dr = { -1, 1, 0, 0 };
	static int[] dc = { 0, 0, -1, 1 };

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());

		map = new int[N][M];

		visited = new boolean[N][M][K + 1];

		for (int r = 0; r < N; r++) {
			String str = br.readLine();
			for (int c = 0; c < M; c++) {
				map[r][c] = str.charAt(c) - '0';
			}
		}

		bfs(0, 0, 1, K);

		System.out.println(res == 0 ? -1 : res);
	}

	static int res;

	private static void bfs(int row, int col, int dist1, int crush) {
		Queue<int[]> q = new LinkedList<>();
		q.add(new int[] { row, col, dist1, crush });
		visited[row][col][crush] = true;

		while (!q.isEmpty()) {
			int[] xy = q.poll();

			int r = xy[0];
			int c = xy[1];
			int length = xy[2];
			int cnt = xy[3];



			if (r == N - 1 && c == M - 1) {
				res = length;
				return;
			}

			for (int d = 0; d < 4; d++) {
				int nr = r + dr[d];
				int nc = c + dc[d];

				if (nr < 0 || nc < 0 || nr >= N || nc >= M)
					continue;

				if (map[nr][nc] == 1 && cnt > 0) {
					if (!visited[nr][nc][cnt - 1]) {
						visited[nr][nc][cnt - 1] = true;
						q.add(new int[] { nr, nc, length + 1, cnt - 1 });
					} else {
						continue;
					}
				} else if (map[nr][nc] == 0) {
					if (visited[nr][nc][cnt])
						continue;
					visited[nr][nc][cnt] = true;
					q.add(new int[] { nr, nc, length + 1, cnt });
				}

			}
		}
	}

}
