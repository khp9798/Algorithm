
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Solution {

	static int N;
	static int M;
	static int L;

	static int[] dr = { -1, 1, 0, 0 };
	static int[] dc = { 0, 0, -1, 1 };

	static int[][] map;
	static boolean[][] visited;
	static int res;

	static class criminal {
		int r;
		int c;
		int time;

		@Override
		public String toString() {
			return "criminal [r=" + r + ", c=" + c + ", time=" + time + "]";
		}

		public criminal(int r, int c, int time) {
			super();
			this.r = r;
			this.c = c;
			this.time = time;
		}

	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();

		for (int t = 1; t <= T; t++) {
			N = sc.nextInt();
			M = sc.nextInt();

			map = new int[N][M];
			visited = new boolean[N][M];

			int startR = sc.nextInt();
			int startC = sc.nextInt();

			L = sc.nextInt();

			for (int r = 0; r < N; r++) {
				for (int c = 0; c < M; c++) {
					map[r][c] = sc.nextInt();
				}
			}

			res = 0;
			bfs(startR, startC, 0);

			System.out.println("#"+t+" "+res);

		}

	}

	static void bfs(int startR, int startC, int time) {
		Queue<criminal> q = new LinkedList<>();
		q.add(new criminal(startR, startC, time));
		visited[startR][startC] = true;

		while (!q.isEmpty()) {
			criminal crim = q.poll();

			if (crim.time == L)
				break;
			res++;
//			System.out.println(crim);

			switch (map[crim.r][crim.c]) {
			case 1: {
				for (int d = 0; d < 4; d++) {
					int nr = crim.r + dr[d];
					int nc = crim.c + dc[d];
					if (nr < 0 || nr >= N || nc < 0 || nc >= M) continue; // 경계 확인

					if (visited[nr][nc]) continue;

					if (d == 0 && (map[nr][nc] == 1 || map[nr][nc] == 2 || map[nr][nc] == 5 || map[nr][nc] == 6)) {
						visited[nr][nc] = true;
						q.add(new criminal(nr, nc, crim.time + 1));
					} else if (d == 1 && (map[nr][nc] == 1 || map[nr][nc] == 2|| map[nr][nc] == 4 || map[nr][nc] == 7)) {
						visited[nr][nc] = true;
						q.add(new criminal(nr, nc, crim.time + 1));
					} else if (d == 2 && (map[nr][nc] == 1 || map[nr][nc] == 3|| map[nr][nc] == 4 || map[nr][nc] == 5)) {
						visited[nr][nc] = true;
						q.add(new criminal(nr, nc, crim.time + 1));
					} else if (d == 3 && (map[nr][nc] == 1 || map[nr][nc] == 3 || map[nr][nc] == 6 || map[nr][nc] == 7)) {
						visited[nr][nc] = true;
						q.add(new criminal(nr, nc, crim.time + 1));
					}
				}
				break;
			}
			case 2: {
				for (int d = 0; d < 2; d++) {
					int nr = crim.r + dr[d];
					int nc = crim.c + dc[d];
					if (nr < 0 || nr >= N || nc < 0 || nc >= M) continue; // 경계 확인

					if (visited[nr][nc]) continue;

					if (d == 0 && (map[nr][nc] == 1 || map[nr][nc] == 2 || map[nr][nc] == 5 || map[nr][nc] == 6)) {
						visited[nr][nc] = true;
						q.add(new criminal(nr, nc, crim.time + 1));
					} else if (d == 1 && (map[nr][nc] == 1 || map[nr][nc] == 2|| map[nr][nc] == 4 || map[nr][nc] == 7)) {
						visited[nr][nc] = true;
						q.add(new criminal(nr, nc, crim.time + 1));
					}

				}
				break;
			}
			case 3: {
				for (int d = 2; d < 4; d++) {
					int nr = crim.r + dr[d];
					int nc = crim.c + dc[d];
					if (nr < 0 || nr >= N || nc < 0 || nc >= M) continue; // 경계 확인

					if (visited[nr][nc]) continue;

					else if (d == 2 && (map[nr][nc] == 1 || map[nr][nc] == 3|| map[nr][nc] == 4 || map[nr][nc] == 5)) {
						visited[nr][nc] = true;
						q.add(new criminal(nr, nc, crim.time + 1));
					} else if (d == 3 && (map[nr][nc] == 1 || map[nr][nc] == 3 || map[nr][nc] == 6 || map[nr][nc] == 7)) {
						visited[nr][nc] = true;
						q.add(new criminal(nr, nc, crim.time + 1));
					}

				}
				break;
			}
			case 4: {
				for (int d = 0; d < 4; d++) {
					int nr = crim.r + dr[d];
					int nc = crim.c + dc[d];
					if (nr < 0 || nr >= N || nc < 0 || nc >= M) continue; // 경계 확인

					if (visited[nr][nc]) continue;

					if (d == 0 && (map[nr][nc] == 1 || map[nr][nc] == 2 || map[nr][nc] == 5 || map[nr][nc] == 6)) {
						visited[nr][nc] = true;
						q.add(new criminal(nr, nc, crim.time + 1));
					} else if (d == 3 && (map[nr][nc] == 1 || map[nr][nc] == 3 || map[nr][nc] == 6 || map[nr][nc] == 7)) {
						visited[nr][nc] = true;
						q.add(new criminal(nr, nc, crim.time + 1));
					}
				}

				break;
			}
			case 5: {
				for (int d = 0; d < 4; d++) {
					int nr = crim.r + dr[d];
					int nc = crim.c + dc[d];
					if (nr < 0 || nr >= N || nc < 0 || nc >= M) continue; // 경계 확인

					if (visited[nr][nc]) continue;

					else if (d == 1 && (map[nr][nc] == 1 || map[nr][nc] == 2|| map[nr][nc] == 4 || map[nr][nc] == 7)) {
						visited[nr][nc] = true;
						q.add(new criminal(nr, nc, crim.time + 1));
					} else if (d == 3 && (map[nr][nc] == 1 || map[nr][nc] == 3 || map[nr][nc] == 6 || map[nr][nc] == 7)) {
						visited[nr][nc] = true;
						q.add(new criminal(nr, nc, crim.time + 1));
					}
				}
				break;
			}
			case 6: {
				for (int d = 0; d < 4; d++) {
					int nr = crim.r + dr[d];
					int nc = crim.c + dc[d];
					if (nr < 0 || nr >= N || nc < 0 || nc >= M) continue; // 경계 확인

					if (visited[nr][nc]) continue;

					else if (d == 1 && (map[nr][nc] == 1 || map[nr][nc] == 2|| map[nr][nc] == 4 || map[nr][nc] == 7)) {
						visited[nr][nc] = true;
						q.add(new criminal(nr, nc, crim.time + 1));
					} else if (d == 2 && (map[nr][nc] == 1 || map[nr][nc] == 3|| map[nr][nc] == 4 || map[nr][nc] == 5)) {
						visited[nr][nc] = true;
						q.add(new criminal(nr, nc, crim.time + 1));
					} 
				}
				break;
			}
			case 7:
				for (int d = 0; d < 4; d++) {

					int nr = crim.r + dr[d];
					int nc = crim.c + dc[d];
					if (nr < 0 || nr >= N || nc < 0 || nc >= M) continue; // 경계 확인

					if (visited[nr][nc]) continue;
					if (d == 0 && (map[nr][nc] == 1 || map[nr][nc] == 2 || map[nr][nc] == 5 || map[nr][nc] == 6)) {
						visited[nr][nc] = true;
						q.add(new criminal(nr, nc, crim.time + 1));
					}else if (d == 2 && (map[nr][nc] == 1 || map[nr][nc] == 3|| map[nr][nc] == 4 || map[nr][nc] == 5)) {
						visited[nr][nc] = true;
						q.add(new criminal(nr, nc, crim.time + 1));
					} 
				}
				break;
			}
		}

	}

}
