

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	static int[][] city;
	static int[][] visited;
	static int N;

	static int[] dr = { -1, 1, 0, 0 };
	static int[] dc = { 0, 0, -1, 1 };

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		N = Integer.parseInt(br.readLine());

		city = new int[N][N];
		visited = new int[N][N];

		int max = Integer.MIN_VALUE;
		for (int r = 0; r < N; r++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int c = 0; c < N; c++) {
				city[r][c] = Integer.parseInt(st.nextToken());
				if (max < city[r][c]) {
					max = city[r][c];
				}
				visited[r][c] = -1;
			}
		}

		
		int maxcnt = Integer.MIN_VALUE;
		for (int i = 0; i <= max; i++) {
			int cnt = 0;
			for (int r = 0; r < N; r++) {
				for (int c = 0; c < N; c++) {
					if (visited[r][c] != i && city[r][c] > i) {
						dfs(r, c, i);
						cnt++;
					}
				}
			}
			if (maxcnt < cnt) {
				maxcnt = cnt;
			}
		}

		System.out.println(maxcnt);

	}

	// r,c 시작 지점 i 높이 이하의 지역들은 물에 잠김
	private static void dfs(int r, int c, int i) {
		// 물에 안잠겼으니 방문했다는 표시
		visited[r][c] = i;

		for (int d = 0; d < 4; d++) {
			int nr = r + dr[d];
			int nc = c + dc[d];

			if (0 <= nr && nr < N && 0 <= nc && nc < N && visited[nr][nc] != i && city[nr][nc] > i) {
				dfs(nr, nc, i);
			}
		}

	}

}
