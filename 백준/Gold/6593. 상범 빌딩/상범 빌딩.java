
import java.util.*;
import java.io.*;

public class Main {

	static char[][][] building;
	static int[][][] dist;
	static int[] dh = { -1, 1 };
	static int[] dr = { -1, 1, 0, 0 };
	static int[] dc = { 0, 0, -1, 1 };

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		while (true) {
			StringTokenizer st = new StringTokenizer(br.readLine());

			int L = Integer.parseInt(st.nextToken());
			int R = Integer.parseInt(st.nextToken());
			int C = Integer.parseInt(st.nextToken());

			if (L == 0 && R == 0 && C == 0)
				return;

			building = new char[L][R][C];
			dist = new int[L][R][C];
			Queue<int[]> q = new LinkedList<>();

			int[] endPoint = new int[3];

			for (int h = 0; h < L; h++) {
				for (int r = 0; r < R; r++) {
					String str = br.readLine();
					for (int c = 0; c < C; c++) {
						building[h][r][c] = str.charAt(c);
						dist[h][r][c] = -1;
						if (building[h][r][c] == 'S') {
							q.add(new int[] { h, r, c });
							dist[h][r][c] = 0;
						}
						if (building[h][r][c] == 'E') {
							endPoint[0] = h;
							endPoint[1] = r;
							endPoint[2] = c;
						}
					}
				}
				br.readLine();
			}

			int seconds = -1;
			while (!q.isEmpty()) {
				int[] hrc = q.poll();

				int h = hrc[0];
				int r = hrc[1];
				int c = hrc[2];

				if (Arrays.equals(hrc, endPoint)) {
					seconds = dist[h][r][c];
					break;
				}

				for (int d = 0; d < 2; d++) {
					int nh = h + dh[d];

					if (nh < 0 || nh >= L)
						continue;
					if (dist[nh][r][c] >= 0 || building[nh][r][c] == '#')
						continue;

					dist[nh][r][c] = dist[h][r][c] + 1;
					q.add(new int[] { nh, r, c });
				}

				for (int d = 0; d < 4; d++) {
					int nr = r + dr[d];
					int nc = c + dc[d];

					if (nr < 0 || nc < 0 || nr >= R || nc >= C)
						continue;
					if (dist[h][nr][nc] >= 0 || building[h][nr][nc] == '#')
						continue;

					dist[h][nr][nc] = dist[h][r][c] + 1;
					q.add(new int[] { h, nr, nc });
				}
			}

			System.out.println(seconds != -1 ? "Escaped in " + seconds + " minute(s)." : "Trapped!");

		}
	}

}
