import java.util.Arrays;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in)
;
		int N = sc.nextInt();
		int K = sc.nextInt();
		
		int [] dp = new int[K+1];
		
		int [] coins = new int[N];
		
		for(int i=0; i<N; i++) {
			coins[i] = sc.nextInt();
		}
		
		Arrays.fill(dp, Integer.MAX_VALUE);
		dp[0]=0;
		
		for (int coin : coins) {
			for(int i=coin; i<=K; i++) {
				if(dp[i-coin]!=Integer.MAX_VALUE) {
					dp[i] = Math.min(dp[i], dp[i-coin])+1;
				}
			}
		}
		
		
		System.out.println(dp[K]);
	}

}
