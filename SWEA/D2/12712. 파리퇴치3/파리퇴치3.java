import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {

	// 상하좌우
	static int[] dr1 = { -1, 1, 0, 0 };
	static int[] dc1 = { 0, 0, -1, 1 };

	// 대각선
	static int[] dr2 = { -1, -1, 1, 1 };
	static int[] dc2 = { -1, 1, -1, 1 };

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int T = Integer.parseInt(br.readLine());

		StringTokenizer st;
		for (int t = 1; t <= T; t++) {
			st = new StringTokenizer(br.readLine());

			int N = Integer.parseInt(st.nextToken());

			int[][] map = new int[N][N];

			int M = Integer.parseInt(st.nextToken());

			for (int r = 0; r < N; r++) {
				st = new StringTokenizer(br.readLine());
				for (int c = 0; c < N; c++) {
					map[r][c] = Integer.parseInt(st.nextToken());
				}
			}

			int max = Integer.MIN_VALUE;
			for (int r = 0; r < N; r++) {
				for (int c = 0; c < N; c++) {
					int sum1 = 0;
					sum1+=map[r][c];
					for (int d = 0; d < 4; d++) {
						int row = r;
						int col = c;
						for (int i = 0; i < M - 1; i++) {
							int nr = row + dr1[d];
							int nc = col + dc1[d];
							if (0 <= nr && nr < N && 0 <= nc && nc < N) {
								row = nr;
								col = nc;
								sum1+=map[row][col];
							}
						}
					}
					if(max<sum1) {
						max = sum1;
					}
					
					int sum2 = 0;
					sum2+=map[r][c];
					for (int d = 0; d < 4; d++) {
						int row = r;
						int col = c;
						for (int i = 0; i < M - 1; i++) {
							int nr = row + dr2[d];
							int nc = col + dc2[d];
							if (0 <= nr && nr < N && 0 <= nc && nc < N) {
								row = nr;
								col = nc;
								sum2+=map[row][col];
							}
						}
					}
					if(max<sum2) {
						max = sum2;
					}
				}
			}
			
			System.out.println("#"+t+" "+max);
		}

	}

}
