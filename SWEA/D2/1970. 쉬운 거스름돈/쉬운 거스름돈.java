import java.util.Arrays;
import java.util.Scanner;

class Solution{
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int T= sc.nextInt();
		
		for(int t=1; t<=T; t++) {
			System.out.println("#"+t);
			int N = sc.nextInt();
			
			N /= 10;
			
			int [] dp = new int[N+1];
			Arrays.fill(dp, Integer.MAX_VALUE);
			dp[0]=0;
			
			int [] coins = {1,5,10,50,100,500,1000,5000};
			int [] p = new int[N+1];
			
			for (int coin : coins) {
				for(int i=coin; i<=N; i++) {
					if(dp[i-coin]!=Integer.MAX_VALUE) {
						dp[i] = Math.min(dp[i], dp[i-coin]+1);
						p[i] = coin;
					}
				}
			}
			
//			System.out.println(Arrays.toString(p));
			int [] count=new int[coins.length];
			
			
			while(N>0) {
				for(int j=0; j<coins.length; j++) {
					if(p[N]==coins[j]) {
						count[j]++;
					}
				}
				N -= p[N];
			}
				
			
			
			
			for(int i=count.length-1; i>=0; i--) {
				System.out.print(count[i]+" ");
			}
			System.out.println();
			
		}
	}
}