import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine().trim(); // 방 번호

        int[] cnt = new int[10];
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            cnt[c - '0']++;
        }

        // 6과 9는 서로 대체 가능
        int sixNine = (cnt[6] + cnt[9] + 1) / 2; // 올림
        cnt[6] = sixNine;
        cnt[9] = 0; // 더이상 단독으로 보지 않음

        int ans = 0;
        for (int i = 0; i < 9; i++) { // 0~8까지, 9는 0으로 만들었음
            ans = Math.max(ans, cnt[i]);
        }
        System.out.println(ans);
    }
}
