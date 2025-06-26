import java.io.*;
import java.util.*;

public class Main {

    static class Num {
        int idx;
        int value;

        Num(int idx, int value) {
            this.idx = idx;
            this.value = value;
        };
    }

    public static void main(String[] args) throws IOException {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            int N = Integer.parseInt(st.nextToken());

            int L = Integer.parseInt(st.nextToken());

            int[] num = new int[N];

            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < N; i++) {
                num[i] = Integer.parseInt(st.nextToken());
            }

            Deque<Num> deq = new ArrayDeque<>();

            StringBuilder sb = new StringBuilder();

            for (int i = 0; i < N; i++) {

                while (!deq.isEmpty() && deq.peekLast().value > num[i]) {
                    deq.pollLast();
                }

                deq.offer(new Num(i, num[i]));

                if (deq.peekFirst().idx < i - L + 1) {
                    deq.pollFirst();
                }

                sb.append(deq.peekFirst().value).append(" ");
            }

            System.out.println(sb);

        }
    }
}
