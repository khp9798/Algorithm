import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class Main {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(br.readLine());

		int[] score = new int[N + 1];

		for (int i = 1; i <= N; i++) {
			score[i] = Integer.parseInt(br.readLine());
		}

		int[] dp = new int[N+1];

		dp[1] = score[1];

        if(N>=2){
            dp[2] = score[1] + score[2];
        }
		

		for (int i = 3; i <= N; i++) {

			dp[i] = Math.max(dp[i - 3] + score[i - 1]  + score[i] , dp[i - 2]  + score[i]);

		}

		System.out.println(dp[N]);

	}

}