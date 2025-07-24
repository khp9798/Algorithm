import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine().trim();
        int n = s.length();

        int k = 0;
        for (char c : s.toCharArray()) {
            if (c == 'a') k++;
        }

        if (k == 0 || k == n) {
            System.out.println(0);
            return;
        }

        String doubled = s + s;
        int windowSize = k;

        int bCount = 0;
        for (int i = 0; i < windowSize; i++) {
            if (doubled.charAt(i) == 'b') {
                bCount++;
            }
        }

        int answer = bCount;

        for (int i = windowSize; i < doubled.length(); i++) {
            if (doubled.charAt(i) == 'b') {
                bCount++;
            }
            if (doubled.charAt(i - windowSize) == 'b') {
                bCount--;
            }
            if (bCount < answer) {
                answer = bCount;
            }
        }

        System.out.println(answer);
    }
}
