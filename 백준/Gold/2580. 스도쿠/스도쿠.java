import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	static int[][] board = new int[9][9];

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st;

		for (int r = 0; r < 9; r++) {
			st = new StringTokenizer(br.readLine());
			for (int c = 0; c < 9; c++) {
				board[r][c] = Integer.parseInt(st.nextToken());
			}
		}

		sdoku(0, 0);

		for (int r = 0; r < 9; r++) {
			for (int c = 0; c < 9; c++) {
				System.out.print(board[r][c] + " ");
			}
			System.out.println();
		}
	}

	static boolean sdoku(int r, int c) {
		if (r == 9)
			return true;
		if (c == 9) {

			return sdoku(r + 1, 0);
		}
		if (board[r][c] != 0) {
			
			return sdoku(r, c + 1);
		}

		for (int num = 1; num <= 9; num++) {
			if (check(r, c, num)) {
				board[r][c] = num;

				if(sdoku(r, c + 1)) {
					return true;
				}

				board[r][c] = 0;
			}
		}
		
		return false;
	}

	static boolean check(int r, int c, int num) {
		for (int i = 0; i < 9; i++) {
			if (board[i][c] == num) {
				return false;
			} else if (board[r][i] == num) {
				return false;
			}
		}

		// 0,1,2 3,4,5 6,7,8

		int startR = r / 3 * 3;
		int startC = c / 3 * 3;

		for (int i = startR; i < startR + 3; i++) {
			for (int j = startC; j < startC + 3; j++) {
				if (board[i][j] == num) {
					return false;
				}
			}
		}
		return true;
	}
}