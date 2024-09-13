import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int N = Integer.parseInt(br.readLine());
        int[][] cost = new int[N][3];
        int[][] dp = new int[N][3];
        
        // 비용 입력받기
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            cost[i][0] = Integer.parseInt(st.nextToken());
            cost[i][1] = Integer.parseInt(st.nextToken());
            cost[i][2] = Integer.parseInt(st.nextToken());
        }
        
        dp[0][0] = cost[0][0];
        dp[0][1] = cost[0][1];
        dp[0][2] = cost[0][2];
        
        // 두 번째 집부터 N번째 집까지 최소 비용 계산
        for (int i = 1; i < N; i++) {
            dp[i][0] = Math.min(dp[i - 1][1], dp[i - 1][2]) + cost[i][0]; // i번째 집을 빨간색으로 칠할 때
            dp[i][1] = Math.min(dp[i - 1][0], dp[i - 1][2]) + cost[i][1]; // i번째 집을 초록색으로 칠할 때
            dp[i][2] = Math.min(dp[i - 1][0], dp[i - 1][1]) + cost[i][2]; // i번째 집을 파란색으로 칠할 때
        }
        
        
        int result = Math.min(dp[N - 1][0], Math.min(dp[N - 1][1], dp[N - 1][2]));
        System.out.println(result);
    }
}
