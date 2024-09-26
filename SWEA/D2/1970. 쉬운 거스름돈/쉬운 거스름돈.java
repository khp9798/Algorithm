import java.util.Arrays;
import java.util.Scanner;
 
class Solution{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
         
        int T= sc.nextInt();
         
        int [] coins = new int[] {1,10,50,100,500,1000,5000,10000,50000};
         
        for(int t=1; t<=T; t++) {
            int N = sc.nextInt();
            System.out.println("#"+t);
             
             
            int [] count = new int[coins.length];
             
            int [] p = new int[N+1];
            int [] dp = new int[N+1];
            Arrays.fill(dp, Integer.MAX_VALUE);
            dp[0] = 0;
             
            for(int i = 0; i<coins.length; i++) {
                for(int j=coins[i]; j<=N; j++) {
                    if(dp[j-coins[i]] != Integer.MAX_VALUE) {
                        dp[j] = Math.min(dp[j], dp[j-coins[i]]+1);
                        if (dp[j] == dp[j-coins[i]]+1) {
                            p[j] = j-coins[i];
                        }
                    }
                }
            }
             
//            System.out.println(Arrays.toString(dp));
             
            while(N>0) {
                int money = N - p[N];
                for(int i=0; i<coins.length; i++) {
                    if(coins[i]==money) count[i]++;
                }
                N -= money;
            }
             
             
            for(int i=count.length-1; i>=1; i--) {
                System.out.print(count[i]+" ");
            }
             
            System.out.println();
        }
    }
}