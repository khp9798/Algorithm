

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

	static char[][] arr;
	static boolean[][] visited1;
	static boolean[][] visited2;
	static int cnt1 = 0;
	static int cnt2 = 0;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(br.readLine());

		arr = new char[N][N];
		visited1 = new boolean[N][N];
		visited2 = new boolean[N][N];

		for (int r = 0; r < N; r++) {
			arr[r] = br.readLine().toCharArray();
		}

		for (int r = 0; r < N; r++) {
			for (int c = 0; c < N; c++) {
				if (!visited1[r][c]) {
					dfs1(r, c, arr[r][c]);
					cnt1++;
				}
				if (!visited2[r][c]) {
					dfs2(r, c, arr[r][c]);
					cnt2++;
				}
			}
		}

		System.out.println(cnt1+" "+cnt2);
	}

	static int[] dr = { -1, 1, 0, 0 };
	static int[] dc = { 0, 0, -1, 1 };

	static void dfs1(int r, int c, char color) {
		visited1[r][c] = true;

		for (int d = 0; d < 4; d++) {
			int nr = r + dr[d];
			int nc = c + dc[d];

			if (0 <= nr && nr < arr.length && 0 <= nc && nc < arr.length && arr[nr][nc] == color && !visited1[nr][nc]) {
				dfs1(nr, nc, arr[nr][nc]);
			}
		}
	}

	static void dfs2(int r, int c, char color) {
		visited2[r][c] = true;

		for (int d = 0; d < 4; d++) {
			int nr = r + dr[d];
			int nc = c + dc[d];

			if (0 <= nr && nr < arr.length && 0 <= nc && nc < arr.length  && !visited2[nr][nc]) {
				if((color=='R' || color=='G')&& (arr[nr][nc] == 'R' || arr[nr][nc] == 'G')) {
					dfs2(nr, nc, arr[nr][nc]);					
				}else if (arr[nr][nc] == color){
					dfs2(nr,nc,arr[nr][nc]);
				}
			}
		}
	}

}
