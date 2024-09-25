import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(br.readLine());
		
		
		for(int t=1; t<=T; t++) {
			int N = Integer.parseInt(br.readLine());
			
			StringTokenizer st = new StringTokenizer(br.readLine());
			
			int [] coins = new int[N];
			for(int i=0; i<N; i++) {
				coins[i] = Integer.parseInt(st.nextToken());
			}
			
			int M = Integer.parseInt(br.readLine());
			int [] dp = new int[M+1];
			
			dp[0]=1;
			
			for (int coin : coins) {
				for(int i = coin; i<=M; i++) {
					dp[i] += dp[i-coin];
				}
			}
			
			System.out.println(dp[M]);
			
			
		}
		

	}

}
