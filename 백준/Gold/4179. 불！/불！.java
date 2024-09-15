import java.io.*;
import java.util.*;

class Main {

	static int R;
	static int C;

	static char[][] map;
	static boolean[][] visited;
	static boolean[][] fired;

	static class jihun {
		int r;
		int c;
		int time;

		public jihun(int r, int c, int time) {
			super();
			this.r = r;
			this.c = c;
			this.time = time;
		}

		@Override
		public String toString() {
			return "jihun [r=" + r + ", c=" + c + ", time=" + time + "]";
		}
		
		

	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine());

		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());

		map = new char[R][C];
		visited = new boolean[R][C];
		fired = new boolean[R][C];

		for (int r = 0; r < R; r++) {
			map[r] = br.readLine().toCharArray();
		}

		for (int r = 0; r < R; r++) {
			for (int c = 0; c < C; c++) {
				if (map[r][c] == 'J') {
					bfs(r, c);
					break;
				}
			}
		}

		System.out.println(res != -1 ? res : "IMPOSSIBLE");

	}

	static int[] dr = { -1, 1, 0, 0 };
	static int[] dc = { 0, 0, -1, 1 };

	static int res = -1;

	private static void bfs(int r, int c) {
		Queue<jihun> q = new LinkedList<>();
		q.add(new jihun(r, c, 0));
		visited[r][c] = true;

		while (!q.isEmpty()) {
			fire();

//			for (int i = 0; i < R; i++) {
//				for (int j = 0; j < C; j++) {
//					System.out.print(map[i][j] + " ");
//				}
//				System.out.println();
//			}
//
//			System.out.println();
			
			int a = q.size();
			for(int i=0; i<a; i++) {
				jihun j = q.poll();

				for (int d = 0; d < 4; d++) {
					int nr = j.r + dr[d];
					int nc = j.c + dc[d];

					if (nr < 0 || nc < 0 || nr >= R || nc >= C) {
						res = j.time + 1;
						return;
					}
					else if (map[nr][nc] == '#')
						continue;
					else if (map[nr][nc] == 'F')
						continue;
					else if( visited[nr][nc]) continue;

					visited[nr][nc] = true;
					map[nr][nc] = 'j';
					q.add(new jihun(nr, nc, j.time + 1));
				}
			}
			
		}

	}

	private static void fire() {
		
		Queue<int[]> q = new LinkedList<>();
		for (int r = 0; r < R; r++) {
			for (int c = 0; c < C; c++) {
				if (map[r][c] == 'F' && !fired[r][c]) {
					fired[r][c] = true;
					q.add(new int[] { r, c });
				}
			}
		}

		while (!q.isEmpty()) {
			int[] arr = q.poll();

			for (int d = 0; d < 4; d++) {
				int nr = arr[0] + dr[d];
				int nc = arr[1] + dc[d];

				if (nr < 0 || nc < 0 || nr >= R || nc >= C)
					continue;
				else if (fired[nr][nc])
					continue;
				else if (map[nr][nc] == '#')
					continue;
				else if (map[nr][nc] == 'F')
					continue;

				map[nr][nc] = 'F';
			}
		}

	}
}