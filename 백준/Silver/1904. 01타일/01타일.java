import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        final int MOD = 15746;

        if (N == 1) {
            System.out.println(1);
            return;
        }
        // f(1)=1, f(2)=2 로 초기화
        int prev = 1, curr = 2, next = 0;

        for (int i = 3; i <= N; i++) {
            next = (prev + curr) % MOD;
            prev = curr;
            curr = next;
        }

        System.out.println(curr);
    }
}
