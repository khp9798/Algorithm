import java.util.Arrays;
import java.util.Scanner;

public class Solution {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int T= sc.nextInt();
		
		for(int t=1; t<=T; t++) {
			System.out.print("#"+t+" ");
			
			int [] dp = new int[13];
			
			int [] cost = new int[4];
			
			for(int i=0; i<4; i++) {
				cost[i] = sc.nextInt();
			}
			
			int [] plan = new int[13];
			
			for(int i=1; i<=12; i++) {
				plan[i] = sc.nextInt();
			}
			
			
			for(int i=1; i<=12; i++) {
				dp[i] = dp[i-1]+plan[i]*cost[0];

				dp[i] = Math.min(dp[i-1]+cost[1], dp[i]);
				
				if(i>=3) {
					dp[i] = Math.min(dp[i-3]+cost[2], dp[i]);					
				}
				
				if(i>=12) {
					dp[i] = Math.min(dp[i-12]+cost[3], dp[i]);
				}
			}
			
			System.out.println(dp[12]);
		}
	}

}
