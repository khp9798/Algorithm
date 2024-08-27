import java.math.BigInteger;
import java.util.Scanner;

public class Main {

	static int max = 1000;
	static BigInteger [][] dp = new BigInteger[max+1][max+1];
	
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int T = sc.nextInt();
		
		comb_dp();
		BigInteger res = new BigInteger("1000000007");
		for(int t=0; t<T; t++) {
			int N = sc.nextInt();
			
			int K = sc.nextInt();

			
			
			
			System.out.println(dp[N][K].mod(res));
		}
		
	}


	static void comb_dp() {
		for(int i=0; i<dp.length; i++) {
			dp[i][0] = BigInteger.ONE;
			dp[i][i] = BigInteger.ONE;
		}
		
		
		for(int i=1; i<=max; i++) {
			for(int j=1; j<i; j++) {
				dp[i][j] = dp[i-1][j-1].add(dp[i-1][j]);
			}
		}
		
	}

}
