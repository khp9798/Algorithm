
import java.util.Scanner;

class Main {

	static int[][] dp = new int[41][2];

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int T = sc.nextInt();

		for (int t = 0; t < T; t++) {

			int N = sc.nextInt();

			dp[0][0] = 1;
			dp[0][1] = 0;

			dp[1][0] = 0;
			dp[1][1] = 1;

			for (int i = 2; i <= N; i++) {
				dp[i][0] = dp[i - 1][0] + dp[i - 2][0];
				dp[i][1] = dp[i - 1][1] + dp[i - 2][1];
			}

			System.out.println(dp[N][0] + " " + dp[N][1]);
		}

	}

}