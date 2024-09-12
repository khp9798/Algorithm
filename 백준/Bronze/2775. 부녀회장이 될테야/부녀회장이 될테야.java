
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class Main {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(br.readLine());
		
		for(int t=0; t<T; t++) {
			
			int K = Integer.parseInt(br.readLine());
			
			int N = Integer.parseInt(br.readLine());
			
			
			
			int[][] dp = new int[15][15];
			
			
			for(int i=0; i<dp.length; i++) {
				dp[0][i] = i;
			}
			
			for(int i=1; i<=14; i++) {
				for(int j=1; j<=14; j++) {
					dp[i][j] = dp[i][j-1]+dp[i-1][j];
				}
			}
			
			System.out.println(dp[K][N]);
		}

	}

}