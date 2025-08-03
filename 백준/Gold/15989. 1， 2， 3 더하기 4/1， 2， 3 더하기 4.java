import java.io.*;

class Main {
    public static void main(String[] args) throws IOException {
        // 코드 작성
        try(BufferedReader br = new BufferedReader(new InputStreamReader(System.in))){
            int t = Integer.parseInt(br.readLine());

            int[] dp = new int[10001];

            dp[0] = 1;

            for (int i = 1; i <= 3; i++) {
                for (int j = i; j <= 10000; j++) {
                    dp[j] += dp[j - i];
                }
            }

            while(t-->0){

                int n = Integer.parseInt(br.readLine());

                System.out.println(dp[n]);
            }
        }
    }
}