

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

	static int[] dr = { -1, 1, 0, 0, -1, -1, 1, 1 };
	static int[] dc = { 0, 0, -1, 1, -1, 1, -1, 1 };

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(br.readLine());

		// 처음 주어지는 지뢰 정보가 있는 맵
		char[][] map1 = new char[N][N];

		for (int r = 0; r < N; r++) {
			String str = br.readLine();
			for (int c = 0; c < N; c++) {
				map1[r][c] = str.charAt(c);
			}
		}

		// 답으로 제출할 인접한 지뢰 개수 정보가 있는 맵
		char[][] res = new char[N][N];

		// map1을 탐색하며 지뢰가 인접한 곳에 지뢰갯수를 res 배열에 저장
		for (int r = 0; r < N; r++) {
			for (int c = 0; c < N; c++) {
				if (map1[r][c] == '.') {
					int sum = 0;
					String str = "";
					for (int d = 0; d < dr.length; d++) {
						int nr = r + dr[d];
						int nc = c + dc[d];

						if (0 <= nr && nr < N && 0 <= nc && nc < N && map1[nr][nc] != '.') {
							sum += map1[nr][nc] - '0';

						}
					}
					if (sum >= 10) {
						res[r][c] = 'M';
					} else {
						str += sum;
						res[r][c] = str.charAt(0);
					}
				} else {
					res[r][c] = '*';
				}
			}
		}

		// 출력
		for (int r = 0; r < N; r++) {
			for (int c = 0; c < N; c++) {

				System.out.print(res[r][c]);
			}
			System.out.println();
		}

	}

	
}
