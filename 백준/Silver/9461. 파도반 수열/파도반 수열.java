import java.io.*;
import java.util.*;

class Main {
    public static void main(String[] args) throws IOException {
        // 코드 작성
        try(BufferedReader br = new BufferedReader(new InputStreamReader(System.in))){
            long[] dp = new long[100];

            dp[0] = 1;
            dp[1] = 1;
            dp[2] = 1;
            dp[3] = 2;
            dp[4] = 2;
            
            for(int i=5; i<100; i++){
                dp[i] = dp[i-5] + dp[i-1];
            }

            int test = Integer.parseInt(br.readLine());

            for(int t = 0; t<test; t++){
                int n = Integer.parseInt(br.readLine());

                System.out.println(dp[n-1]);
            }
        }
    }
}