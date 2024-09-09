import java.util.Arrays;
import java.util.Scanner;

public class Solution {

	static int D;
	static int W;
	static int K;

	static int[][] map;
	static int[][] copymap;

	static int res;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int T = sc.nextInt();

		for (int t = 1; t <= T; t++) {
			D = sc.nextInt();

			W = sc.nextInt();

			K = sc.nextInt();

			map = new int[D][W];
			copymap = new int[D][W];

			for (int r = 0; r < D; r++) {
				for (int c = 0; c < W; c++) {
					map[r][c] = sc.nextInt();
					copymap[r][c] = map[r][c];
				}
			}

			res = Integer.MAX_VALUE;
			medicine(0, 0);

			System.out.println("#" + t + " " + res);
		}

	}

	static void medicine(int r, int cnt) {
		if (r == D) {
			if (check()) {
				if (res < cnt) {
					return;
				}
				res = Math.min(res, cnt);
			}
			return;
		}

		// 아무것도 안넣을 때
		medicine(r + 1, cnt);

		// A약 넣을 때
		Arrays.fill(map[r], 0);
		medicine(r + 1, cnt + 1);
		map[r] = copymap[r].clone();

		// B약 넣을 때
		Arrays.fill(map[r], 1);
		medicine(r + 1, cnt + 1);
		map[r] = copymap[r].clone();
	}

	private static boolean check() {

		boolean Check = false;
		out: for (int c = 0; c < W; c++) {
			int count = 1;
			Check = false;
			for (int r = 0; r < D - 1; r++) {
				if (count >= K) {
					Check = true;
					continue out;
				}
				if (map[r][c] == map[r + 1][c]) {
					
					count++;
					if (count >= K) {
						Check = true;
						continue out;
					}

				} else {
					count = 1;
				}
			}
			if (!Check)
				break;

		}

		return Check;

	}

}
