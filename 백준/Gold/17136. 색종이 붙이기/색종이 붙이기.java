import java.util.Scanner;

public class Main {

	static int[][] map = new int[10][10];
	static int[] cnt = new int[6];
	static int res = Integer.MAX_VALUE;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		for (int i = 0; i < 10; i++) {
			for (int j = 0; j < 10; j++) {
				map[i][j] = sc.nextInt();
			}
		}

		dfs(0, 0);

		System.out.println(res == Integer.MAX_VALUE ? -1 : res);
	}

	static void dfs(int r, int c) {
		if (r >= 10) {  // 행의 끝까지 탐색했을 경우
			res = Math.min(res, cnt[1] + cnt[2] + cnt[3] + cnt[4] + cnt[5]);
			return;
		}

		if (c >= 10) {  // 열의 끝에 도달하면 다음 행으로 이동
			dfs(r + 1, 0);
			return;
		}

		if (map[r][c] == 1) {  // 현재 위치가 1인 경우 색종이를 붙일 수 있는지 확인
			for (int size = 5; size >= 1; size--) {
				if (cnt[size] < 5 && check(r, c, size)) {
					paper(r, c, size, 0);
					cnt[size]++;
					dfs(r, c + 1);
					paper(r, c, size, 1);
					cnt[size]--;
				}
			}
		} else {  // 현재 위치가 1이 아니면 다음 칸으로 이동
			dfs(r, c + 1);
		}
	}

	static boolean check(int r, int c, int size) {
		for (int i = 0; i < size; i++) {
			for (int j = 0; j < size; j++) {
				if (r + i >= 10 || c + j >= 10 || map[r + i][c + j] != 1) {
					return false;
				}
			}
		}
		return true;
	}

	static void paper(int r, int c, int size, int num) {
		for (int i = 0; i < size; i++) {
			for (int j = 0; j < size; j++) {
				map[r + i][c + j] = num;
			}
		}
	}
}
