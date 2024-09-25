import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int N = sc.nextInt();

		int[] dp = new int[N + 1];
		int[] path = new int[N + 1];

		Arrays.fill(dp, Integer.MAX_VALUE);
		dp[1] = 0;

		for (int i = 2; i <= N; i++) {
			dp[i] = dp[i - 1] + 1;
			path[i] = i - 1;

			if (i % 3 == 0) {
				dp[i] = Math.min(dp[i], dp[i / 3] + 1);
				if (dp[i] == dp[i / 3] + 1)
					path[i] = i / 3;
			}
			if (i % 2 == 0) {
				dp[i] = Math.min(dp[i], dp[i / 2] + 1);
				if (dp[i] == dp[i / 2] + 1)
					path[i] = i / 2;
			}

		}

//		System.out.println(Arrays.toString(dp));
		System.out.println(dp[N]);
		
		List<Integer> res = new ArrayList<>();
		while(N>0) {
			res.add(N);
			N = path[N];
		}

		
		for (Integer integer : res) {
			System.out.print(integer+" ");
		};
	}

}
