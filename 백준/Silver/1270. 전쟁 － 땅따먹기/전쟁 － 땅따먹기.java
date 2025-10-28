import java.io.*;
import java.util.*;

public class Main {

    // 매우 빠른 입력용
    static class FastScanner {
        private final InputStream in;
        private final byte[] buffer = new byte[1 << 16];
        private int ptr = 0, len = 0;

        FastScanner(InputStream is) { this.in = is; }

        private int read() throws IOException {
            if (ptr >= len) {
                len = in.read(buffer);
                ptr = 0;
                if (len <= 0) return -1;
            }
            return buffer[ptr++];
        }

        long nextLong() throws IOException {
            int c;
            do {
                c = read();
                if (c == -1) return Long.MIN_VALUE; // 입력 끝 보호
            } while (c <= ' ');

            int sign = 1;
            if (c == '-') {
                sign = -1;
                c = read();
            }

            long val = 0;
            while (c > ' ') {
                val = val * 10 + (c - '0');
                c = read();
            }
            return val * sign;
        }
    }

    public static void main(String[] args) throws Exception {
        FastScanner fs = new FastScanner(System.in);
        StringBuilder sb = new StringBuilder();

        int T = (int) fs.nextLong();
        for (int tc = 0; tc < T; tc++) {
            int n = (int) fs.nextLong();
            int half = n / 2;

            // 적당한 초기 용량: load factor 0.75 감안
            HashMap<Long, Integer> cnt = new HashMap<>(Math.max(16, (int)(n / 0.75f) + 1));

            boolean found = false;
            long majority = 0;

            for (int i = 0; i < n; i++) {
                long x = fs.nextLong();
                if (!found) {
                    int c = cnt.getOrDefault(x, 0) + 1;
                    cnt.put(x, c);
                    if (c > half) {
                        found = true;
                        majority = x;
                        // 이후 값들은 읽기만 하고 카운트 생략 (아래 if로 처리)
                    }
                }
                // found == true 인 경우는 위에서 그냥 값을 “소모만” 함
            }

            if (found) sb.append(majority).append('\n');
            else sb.append("SYJKGW").append('\n');
        }

        System.out.print(sb.toString());
    }
}
