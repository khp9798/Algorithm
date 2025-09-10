import java.io.*;
import java.util.*;

public class Main {
    static int n;
    static int[] s; // 1-indexed

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder out = new StringBuilder();

        n = Integer.parseInt(br.readLine().trim());
        s = new int[n + 1];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= n; i++) s[i] = Integer.parseInt(st.nextToken());

        int m = Integer.parseInt(br.readLine().trim());
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int gender = Integer.parseInt(st.nextToken());
            int k = Integer.parseInt(st.nextToken());

            if (gender == 1) { // 남학생
                for (int idx = k; idx <= n; idx += k) toggle(idx);
            } else { // 여학생
                int l = k, r = k;
                while (l - 1 >= 1 && r + 1 <= n && s[l - 1] == s[r + 1]) {
                    l--; r++;
                }
                for (int idx = l; idx <= r; idx++) toggle(idx);
            }
        }

        // 출력: 한 줄에 20개씩
        for (int i = 1; i <= n; i++) {
            out.append(s[i]).append(' ');
            if (i % 20 == 0) out.append('\n');
        }
        System.out.print(out.toString().trim());
    }

    static void toggle(int i) { s[i] = 1 - s[i]; }
}
