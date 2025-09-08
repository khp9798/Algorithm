import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    static int[] alpha = new int[26]; // 각 알파벳의 개수
    static int len;
    static int result = 0;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();
        len = s.length();

        // 알파벳 빈도 카운트
        for (char c : s.toCharArray()) {
            alpha[c - 'a']++;
        }

        dfs(0, ' '); // 시작은 아무 문자도 선택하지 않은 상태
        System.out.println(result);
    }

    static void dfs(int depth, char prev) {
        if (depth == len) { // 문자열 완성
            result++;
            return;
        }

        for (int i = 0; i < 26; i++) {
            if (alpha[i] > 0 && (char)(i + 'a') != prev) { // 남아있고, 이전 문자와 다르면
                alpha[i]--;
                dfs(depth + 1, (char)(i + 'a'));
                alpha[i]++; // 복구
            }
        }
    }
}
