import java.io.*;

public class Main {
    public static void main(String[] agrs) throws IOException {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            String text = br.readLine(); // 길이 N
            String pat = br.readLine(); // 길이 M

            int N = text.length();
            int M = pat.length();

            // 1) π 배열 구성 (M 길이)
            int[] pi = new int[M];
            for (int i = 1, j = 0; i < M; i++) {
                while (j > 0 && pat.charAt(i) != pat.charAt(j)) {
                    j = pi[j - 1];
                }
                if (pat.charAt(i) == pat.charAt(j)) {
                    pi[i] = ++j;
                }
            }

            // 2) 텍스트 순회
            boolean found = false;
            for (int i = 0, j = 0; i < N; i++) {
                // 불일치 시 j를 이전 일치 길이로 되돌림
                while (j > 0 && text.charAt(i) != pat.charAt(j)) {
                    j = pi[j - 1];
                }
                // 일치하면 j 증가
                if (text.charAt(i) == pat.charAt(j)) {
                    j++;
                    // 패턴 끝까지 일치했다면
                    if (j == M) {
                        found = true;
                        break;
                    }
                }
            }

            // 3) 결과 출력
            System.out.println(found ? 1 : 0);

        }
    }
}
