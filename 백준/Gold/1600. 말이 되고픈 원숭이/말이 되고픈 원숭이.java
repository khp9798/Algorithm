import java.io.*;
import java.util.*;

public class Main {

	static int[][] board;
	static boolean[][][] vis;

	static int k; // 말 동선으로 갈 수 있는 횟수
	static int w;
	static int h;

	// 말 무빙
	static int[] horseR = { -2, -2, 2, 2, -1, -1, 1, 1 };
	static int[] horseC = { -1, 1, -1, 1, -2, 2, -2, 2 };

	// 그냥 무빙
	static int[] dr = { -1, 1, 0, 0 };
	static int[] dc = { 0, 0, -1, 1 };

	static Queue<int[]> q = new LinkedList<>();

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		k = Integer.parseInt(br.readLine());

		StringTokenizer st = new StringTokenizer(br.readLine());

		w = Integer.parseInt(st.nextToken());
		h = Integer.parseInt(st.nextToken());

		board = new int[h][w];

		vis = new boolean[h][w][k+1];

		for (int r = 0; r < h; r++) {
			st = new StringTokenizer(br.readLine());
			for (int c = 0; c < w; c++) {
				board[r][c] = Integer.parseInt(st.nextToken());
			}
		}

		System.out.println(bfs(0, 0));

	}

	static int bfs(int startR, int startC) {
		vis[startR][startC][k] = true;
		q.add(new int[] { startR, startC, 0, k });

		while (!q.isEmpty()) {
			int[] monkey = q.poll();
			int r = monkey[0];
			int c = monkey[1];
			int count = monkey[2];
			int horseMovingCount = monkey[3];

			if (r == h - 1 && c == w - 1)
				return count;

			if (horseMovingCount > 0) {
				Moving(r, c, count, horseMovingCount, 8, horseR, horseC);
				Moving(r, c, count, horseMovingCount, 4, dr, dc);
			} else {
				Moving(r, c, count, horseMovingCount, 4, dr, dc);
			}
		}

		return -1;
	}

	static void Moving(int r, int c, int count, int horseMovingCount, int mode, int[] dr, int[] dc) {
		for (int d = 0; d < mode; d++) {
			int nr = r + dr[d];
			int nc = c + dc[d];
			int remainK = mode == 8 ? horseMovingCount - 1 : horseMovingCount;

			if (nr < 0 || nc < 0 || nr >= h || nc >= w)
				continue;
			if (vis[nr][nc][remainK] || board[nr][nc] == 1)
				continue;

			vis[nr][nc][remainK] = true;
			q.add(new int[] { nr, nc, count + 1, remainK });
		}
	}

}
