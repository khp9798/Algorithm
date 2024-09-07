
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;

public class Solution {

	static class Point {
		int r;
		int c;
		int cnt;
		int length;

		public Point(int r, int c, int cnt, int length) {
			super();
			this.r = r;
			this.c = c;
			this.cnt = cnt;
			this.length = length;
		}

		@Override
		public String toString() {
			return "Point [r=" + r + ", c=" + c + ", cnt=" + cnt + ", length=" + length + "]";
		}

	}

	static int[] dr = { -1, 1, 0, 0 };
	static int[] dc = { 0, 0, -1, 1 };

	static int N;
	static int K;

	static int[][] map;
	static boolean[][][] visited;

	static int max;

	static int res;

	static List<Point> startP;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();

		for (int t = 1; t <= T; t++) {
			N = sc.nextInt();
			K = sc.nextInt();

			map = new int[N][N];
			visited = new boolean[N][N][2];

			max = Integer.MIN_VALUE;
			for (int r = 0; r < N; r++) {
				for (int c = 0; c < N; c++) {
					map[r][c] = sc.nextInt();
					max = Math.max(max, map[r][c]);
				}
			}

			startP = new ArrayList<>();
			for (int r = 0; r < N; r++) {
				for (int c = 0; c < N; c++) {
					if (map[r][c] == max) {
						startP.add(new Point(r, c, 0, 1));
					}
				}
			}

			res = Integer.MIN_VALUE;
			for (int i = 0; i < startP.size(); i++) {
				Point start = startP.get(i);
				visited[start.r][start.c][0] = true;
				dfs(start.r, start.c, start.cnt, start.length);
				visited[start.r][start.c][0] = false;

			}

			System.out.println("#" + t + " " + res);

		}
		sc.close();

	}

	private static void dfs(int r, int c, int cnt, int length) {

		if (length > res) {
			res = length;
		}

		for (int d = 0; d < 4; d++) {
			int nr = r + dr[d];
			int nc = c + dc[d];

			if (0 <= nr && nr < N && 0 <= nc && nc < N) {
				if (map[nr][nc] < map[r][c] && !visited[nr][nc][0]) {
					visited[nr][nc][0] = true;
					dfs(nr, nc, cnt, length + 1);
					visited[nr][nc][0] = false;
				} else if (map[nr][nc] >= map[r][c] && !visited[nr][nc][0] && cnt == 0) {

					for (int i = 1; i <= K; i++) {
						if (map[nr][nc] - map[r][c] < i) {
							visited[nr][nc][1] = true;
							map[nr][nc] -= i;
							dfs(nr, nc, cnt + 1, length + 1);
							visited[nr][nc][1] = false;
							map[nr][nc] +=i;
						}
					}

				}

			}
		}

	}

}
