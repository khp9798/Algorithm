import java.io.*;
import java.util.*;

class Main {

    static class Balloon {
        int num, paper;

        Balloon(int num, int paper) {
            this.num = num;
            this.paper = paper;
        }

        @Override
        public String toString() {
            return "(paper : " + this.paper + ")";
        }
    }

    public static void main(String[] args) throws IOException {
        // 코드 작성
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            int n = Integer.parseInt(br.readLine());

            Deque<Balloon> deq = new ArrayDeque<>();

            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int i = 1; i <= n; i++) {
                deq.offerLast(new Balloon(i, Integer.parseInt(st.nextToken())));
            }

            StringBuilder sb = new StringBuilder();
            // -면 앞으로 보내고
            // 양수면 뒤로 보내기

            boolean front = true;
            while (deq.size()>1) {

                Balloon bal = deq.pollFirst();
                int value = bal.paper;
                sb.append(bal.num).append(" ");

                if (value > 0) {
                    for (int i = 0; i < value - 1; i++) {
                        deq.offerLast(deq.pollFirst());
                    }
                } else {
                    for (int i = 0; i > value; i--) {
                        deq.offerFirst(deq.pollLast());
                    }
                }
            }

            sb.append(deq.pollFirst().num);
            System.out.println(sb);
        }
    }
}