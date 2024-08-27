import java.util.Scanner;
import java.math.BigInteger;

public class Main {

	static int N;
	static int M;
	static int max = 100;
	static BigInteger [][] dp = new BigInteger[max+1][max+1];

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		N = sc.nextInt();
		M = sc.nextInt();

		// nCm
		comb_dp();
		System.out.println(dp[N][M]);
		sc.close(); // Scanner 닫기
	}
	
	static void comb_dp() {
		// 초기화 부분에서 BigInteger.ONE으로 초기화
		for(int i = 0; i <= max; i++) {
			dp[i][0] = BigInteger.ONE;
			dp[i][i] = BigInteger.ONE;
		}
		
		for(int i = 1; i <= max; i++) {
			for(int j = 1; j < i; j++) {
				// BigInteger의 더하기 연산은 add() 메서드를 사용해야 함
				dp[i][j] = dp[i-1][j-1].add(dp[i-1][j]);
			}
		}
	}
}
