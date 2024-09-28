import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

	static int N;
	static int M;
	static int[][] map;
	static int[][] copymap;

	static boolean[][] visited;

	static int[] dr = { -1, 1, 0, 0 };
	static int[] dc = { 0, 0, -1, 1 };

	static int count;
	static int time;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		map = new int[N][M];
		copymap = new int[N][M];

		for (int r = 0; r < N; r++) {
			st = new StringTokenizer(br.readLine());
			for (int c = 0; c < M; c++) {
				map[r][c] = Integer.parseInt(st.nextToken());
			}
		}

		time = 0;
		while (!bfsAir()) {
			Copy(copymap, map);

			for (int r = 0; r < N; r++) {
				for (int c = 0; c < M; c++) {
					if (map[r][c] == 1 && !visited[r][c]) {
						dfsMelt(r, c);
					}
				}
			}

			time++;
			Copy(map, copymap);
			
//			for (int r = 0; r < N; r++) {
//				for (int c = 0; c < M; c++) {
//					System.out.print(map[r][c]+" ");
//				}
//				System.out.println();
//			}
//			System.out.println();
		}

	}

	static void Copy(int[][] copymap, int[][] map) {
		for (int r = 0; r < N; r++) {
			for (int c = 0; c < M; c++) {
				copymap[r][c] = map[r][c];
			}
		}

	}

	private static void dfsMelt(int r, int c) {
		visited[r][c] = true;

		for (int d = 0; d < 4; d++) {
			int nr = r + dr[d];
			int nc = c + dc[d];

			if (map[nr][nc] == 0 && visited[nr][nc]) {
				copymap[r][c] = 0;
			}

			else if (map[nr][nc] == 1 && !visited[nr][nc]) {
				dfsMelt(nr, nc);
			}

		}

	}

	// 바깥 공기 true로 만들기
	static boolean bfsAir() {
		visited = new boolean[N][M];
		Queue<int[]> q = new LinkedList<>();
		q.add(new int[] { 0, 0 });

		int count1 = 0;
		while (!q.isEmpty()) {
			int[] rc = q.poll();

			int r = rc[0];
			int c = rc[1];

			if (visited[r][c])
				continue;
			count1++;
			visited[r][c] = true;

			for (int d = 0; d < 4; d++) {
				int nr = r + dr[d];
				int nc = c + dc[d];

				if (nr < 0 || nc < 0 || nr >= N || nc >= M)
					continue;

				if (visited[nr][nc] || map[nr][nc] == 1)
					continue;

				q.add(new int[] { nr, nc });
			}
		}

		if (count1 == N * M) {
			System.out.println(time);
			System.out.println(count);
			return true;
		} else {
			count=0;
			for(int r=0; r<N; r++) {
				for(int c=0; c<M; c++) {
					if(map[r][c]==1) {
						count++;
					}
				}
			}
			return false;
		}
	}

}
