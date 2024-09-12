
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;

class Main {

	

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int T = sc.nextInt();
		
		for(int t=1; t<=T; t++) {
			int [] dp = new int [12];
			dp[0]=0;
			dp[1]=1;
			dp[2]=2;
			dp[3]=4;
			
			for(int i=4; i<=11; i++) {
				dp[i] = dp[i-1]+dp[i-2]+dp[i-3];
			}
			System.out.println(dp[sc.nextInt()]);
		}

	}
	
	

}