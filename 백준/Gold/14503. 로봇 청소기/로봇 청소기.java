import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {

	static int N;
	static int M;

	static class Point {
		int r;
		int c;
		int d;

		public Point(int r, int c, int d) {
			super();
			this.r = r;
			this.c = c;
			this.d = d;
		}

		@Override
		public String toString() {
			return "Point [r=" + r + ", c=" + c + ", d=" + d + "]";
		}

	}

	static int[][] map;
	static boolean[][] visited;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		N = sc.nextInt();
		M = sc.nextInt();

		map = new int[N][M];
		visited = new boolean[N][M];

		Point start = new Point(sc.nextInt(), sc.nextInt(), sc.nextInt());

		for (int r = 0; r < N; r++) {
			for (int c = 0; c < M; c++) {
				map[r][c] = sc.nextInt();
			}
		}

		dfs(start.r, start.c, start.d);

//		System.out.println(Arrays.deepToString(visited))

		System.out.println(res);
	}

	static int[] dr = { -1, 0, 1, 0 };
	static int[] dc = { 0, 1, 0, -1 };

	static int res=1;

	private static void dfs(int r, int c, int d) {
		map[r][c]=-1;

		for (int dir = 1; dir <= 4; dir++) {
			d = (d+3)%4;
			int nd = d;
			int nr = r + dr[nd];
			int nc = c + dc[nd];

			if (map[nr][nc] == 0) {
				dfs(nr, nc, nd);
				res++;
				return;
			}
		}
		
		
		
		int br = r+dr[(d+2)%4];
		int bc = c+dc[(d+2)%4];
		if(map[br][bc]!=1) {
			dfs(br,bc,d);
		}

	}

}
