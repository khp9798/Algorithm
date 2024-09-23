import java.io.*;
import java.util.Arrays;

public class Main {

	static int[] dp;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(br.readLine());

		dp = new int[100001];

		Arrays.fill(dp, Integer.MAX_VALUE);

		dp[2] = 1;
		dp[4] = 2;
		dp[5] = 1;
		
		
		for(int i=6; i<=N; i++) {
			dp[i] = Math.min(dp[i-5], dp[i-2])+1;
		}
		
		
		System.out.println(dp[N] == Integer.MAX_VALUE ? -1 : dp[N]);
	}

}
