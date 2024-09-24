import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(br.readLine());

		int[] dp = new int[100001];

		int MAX = Integer.MAX_VALUE;

		dp[0] = MAX;
		dp[1] = MAX;
		dp[2] = 1;
		dp[3] = MAX;
		dp[4] = 2;
		dp[5] = 1;

		for (int i = 6; i <= N; i++) {
			dp[i] = Math.min(dp[i - 2], dp[i - 5]) + 1;
		}

		System.out.println(dp[N] == MAX ? -1 : dp[N]);
	}
}