

import java.util.Scanner;

public class Solution {

	// . : 평지 (전차 이동 가능)
	// * : 벽돌 (포탄 한번을 깰 수 있음)
	// # : 강철 (포탄으로 못깸)
	// _ : 물 (전차 이동 불가)

	// 전차가 보는 방향
	// ^ : 위쪽을 바라봄
	// v : 아래쪽을 바라봄
	// < : 왼쪽을 바라봄
	// > : 오른쪽을 바라봄

	static int H;
	static int W;
	static char[][] map;

	static class Tank {
		int r;
		int c;
		int direction;

		public Tank(int r, int c, int direction) {
			super();
			this.r = r;
			this.c = c;
			this.direction = direction;
		}

	}

	static Tank start;

	static char[] demoji = { '^', 'v', '<', '>' };

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		// 테스트 케이스 수
		int T = sc.nextInt();

		for (int tc = 1; tc <= T; tc++) {
			// 맵의 높이
			H = sc.nextInt();

			// 맵의 너비
			W = sc.nextInt();

			// 맵
			map = new char[H][W];

			// 맵 내용 입력 받기
			for (int r = 0; r < H; r++) {
				map[r] = sc.next().toCharArray();
			}

			// 스타트 포인트 찾기
			for (int r = 0; r < H; r++) {
				for (int c = 0; c < W; c++) {
					for (int i = 0; i < demoji.length; i++) {
						if (map[r][c] == demoji[i]) {
							start = new Tank(r, c, i);
							y = r;
							x = c;
							emoji = i;
						}
					}
				}
			}

			// 명령어 개수
			int commandCount = sc.nextInt();

			String commands = sc.next();
			for (int i = 0; i < commandCount; i++) {
				char command = commands.charAt(i);

				doCommand(new Tank(y, x, emoji), command);
			}

			System.out.print("#" + tc + " ");
			for (int r = 0; r < H; r++) {
				for (int c = 0; c < W; c++) {
					System.out.print(map[r][c]);
				}
				System.out.println();
			}

		} // tc

	}// main

	static int[] dr = { -1, 1, 0, 0 };
	static int[] dc = { 0, 0, -1, 1 };

	static int y = 0;
	static int x = 0;
	static int emoji = 0;

	static void doCommand(Tank start, char c) {
		int startr = start.r;
		int startc = start.c;
		int direction = start.direction;

		if (c == 'S') {
			Shoot(startr, startc, direction);

		} else if (c == 'U') {
			int d = 0;
			int nr = startr + dr[d];
			int nc = startc + dc[d];
			// 막혀있으면 바라보는 방향만 바꿔줌
			map[startr][startc] = demoji[d];
			emoji = d;

			if (nr < 0 || nr >= H || nc < 0 || nc >= W)
				return;

			if (map[nr][nc] == '.') {
				map[nr][nc] = map[startr][startc];
				map[startr][startc] = '.';
				y = nr;
				x = nc;
				emoji = d;
			}

		} else if (c == 'D') {

			int d = 1;
			int nr = startr + dr[d];
			int nc = startc + dc[d];
			// 막혀있으면 바라보는 방향만 바꿔줌
			map[startr][startc] = demoji[d];
			emoji = d;

			if (nr < 0 || nr >= H || nc < 0 || nc >= W)
				return;

			if (map[nr][nc] == '.') {
				map[nr][nc] = map[startr][startc];
				map[startr][startc] = '.';
				y = nr;
				x = nc;
				emoji = d;
			}

		} else if (c == 'L') {
			int d = 2;
			int nr = startr + dr[d];
			int nc = startc + dc[d];

			// 막혀있으면 바라보는 방향만 바꿔줌

			map[startr][startc] = demoji[d];
			emoji = d;
			
			if (nr < 0 || nr >= H || nc < 0 || nc >= W)
				return;

			if (map[nr][nc] == '.') {
				map[nr][nc] = map[startr][startc];
				map[startr][startc] = '.';
				y = nr;
				x = nc;
				emoji = d;
			}

		} else {
			int d = 3;
			int nr = startr + dr[d];
			int nc = startc + dc[d];
			// 막혀있으면 바라보는 방향만 바꿔줌
			map[startr][startc] = demoji[d];
			emoji = d;
			
			if (nr < 0 || nr >= H || nc < 0 || nc >= W)
				return;

			if (map[nr][nc] == '.') {
				map[nr][nc] = map[startr][startc];
				map[startr][startc] = '.';
				y = nr;
				x = nc;
				emoji = d;
			}

		}
	}

	static void Shoot(int r, int c, int d) {
		if (d == 0) {
			for (int i = r - 1; i >= 0; i--) {
				if (map[i][c] == '*') {
					map[i][c] = '.';
					return;
				}
				if (map[i][c] == '#') {
					return;
				}
			}
		} else if (d == 1) {
			for (int i = r + 1; i < H; i++) {
				if (map[i][c] == '*') {
					map[i][c] = '.';
					return;
				}
				if (map[i][c] == '#') {
					return;
				}
			}
		} else if (d == 2) {
			for (int i = c - 1; i >= 0; i--) {
				if (map[r][i] == '*') {
					map[r][i] = '.';
					return;
				}
				if (map[r][i] == '#') {
					return;
				}
			}
		} else {
			for (int i = c + 1; i < W; i++) {
				if (map[r][i] == '*') {
					map[r][i] = '.';
					return;
				}
				if (map[r][i] == '#') {
					return;
				}
			}
		}
	}
}
