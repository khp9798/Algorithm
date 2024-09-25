import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		
		int [] dp = new int[K+1];
		int [] coin = new int[N];
		
		
		for(int i=0; i<N; i++) {
			coin[i] = Integer.parseInt(br.readLine());
		}
		
		//0원을 만드는 경우의 수는 아무 동전도 쓰지 않는 1가지 밖에 없다.
		dp[0] = 1;
		
		for (int co : coin) {
			for(int i=co; i<K+1; i++) {
				dp[i] = dp[i] + dp[i-co];
			}
		}
		
		System.out.println(dp[K]);
		
	}

}
