import java.io.*;
import java.util.*;

class Main {
    public static void main(String[] args) throws IOException {
        // 코드 작성
        try(BufferedReader br = new BufferedReader(new InputStreamReader(System.in))){
            int n = Integer.parseInt(br.readLine());

            int [] S = new int[n];

            int [] dp = new int[n];

            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int i=0; i<n; i++){
                S[i] = Integer.parseInt(st.nextToken());
            }


            dp[0] = S[0];

            int max = dp[0];
            for(int i=1; i<n; i++){
                dp[i] = Math.max(dp[i-1]+S[i], S[i]);

                max = Math.max(dp[i],max);
            }

            System.out.println(max);
        }
    }
}