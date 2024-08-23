
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	static int[][] map;

	static int[] dr = { 0, 1, 1 };
	static int[] dc = { 1, 0, 1 };

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(br.readLine());

		map = new int[N][N];

		for (int r = 0; r < N; r++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int c = 0; c < N; c++) {
				map[r][c] = Integer.parseInt(st.nextToken());
			}
		}

		dfs(0, 1, 0);

		System.out.println(cnt);
	}

	static int cnt = 0;

	static void dfs(int r, int c, int d) {
		if (r == map.length - 1 && c == map.length - 1) {
			cnt++;
			return;
		}

        //진행방향이 가로 일 때
		if (d == 0) {
			int nr1 = r + dr[0];
			int nc1 = c + dc[0];

			if (0 <= nr1 && nr1 < map.length && 0 <= nc1 && nc1 < map.length && map[nr1][nc1] != 1) {
				dfs(nr1, nc1, d);
			}

		}

        //세로일 때
		else if (d == 1) {
			int nr1 = r + dr[d];
			int nc1 = c + dc[d];

			if (0 <= nr1 && nr1 < map.length && 0 <= nc1 && nc1 < map.length && map[nr1][nc1] != 1) {
				dfs(nr1, nc1, d);
			}

		}

        //대각선일 때
		else {
			int nr1 = r + dr[0];
			int nc1 = c + dc[0];

			if (0 <= nr1 && nr1 < map.length && 0 <= nc1 && nc1 < map.length && map[nr1][nc1] != 1) {
				dfs(nr1, nc1, 0);
			}

			int nr3 = r + dr[1];
			int nc3 = c + dc[1];

			if (0 <= nr3 && nr3 < map.length && 0 <= nc3 && nc3 < map.length && map[nr3][nc3] != 1) {
				dfs(nr3, nc3, 1);
			}
		}

		int nr2 = r + dr[2];
		int nc2 = c + dc[2];
    
        //진행방향이 어떻든 대각선은 갈 수 있음.
		if (0 <= nr2 && nr2 < map.length && 0 <= nc2 && nc2 < map.length && map[nr2][nc2] != 1
				&& map[r + dr[0]][c + dc[0]] != 1 && map[r + dr[1]][c + dc[1]] != 1) {
			dfs(nr2, nc2, 2);
		}

	}
}
