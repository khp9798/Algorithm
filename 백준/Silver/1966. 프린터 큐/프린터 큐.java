import java.io.*;
import java.util.*;

class Main {

    static class Paper {
        int idx, value;

        Paper(int idx, int value) {
            this.idx = idx;
            this.value = value;
        }

        @Override
        public String toString() {
            return "(" + this.idx + ", " + this.value + ")";
        }
    }

    public static void main(String[] args) throws IOException {
        // 코드 작성
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            int T = Integer.parseInt(br.readLine());

            StringTokenizer st;

            StringBuilder sb = new StringBuilder();

            while (T-- > 0) {
                st = new StringTokenizer(br.readLine());

                int n = Integer.parseInt(st.nextToken());

                int m = Integer.parseInt(st.nextToken());

                Deque<Paper> deq = new ArrayDeque<>();
                List<Integer> arr = new ArrayList<>();

                st = new StringTokenizer(br.readLine());
                for (int i = 0; i < n; i++) {
                    int important = Integer.parseInt(st.nextToken());
                    arr.add(important);
                    deq.addLast(new Paper(i, important));
                }

                Collections.sort(arr, Comparator.reverseOrder());

                int index = 0;
                for (int i = 0; i < arr.size(); i++) {
                    while (deq.peekFirst().value != arr.get(i)) {
                        deq.addLast(deq.pollFirst());
                    }

                    Paper p = deq.pollFirst();
                    index++;

                    if (p.idx == m) {
                        sb.append(index).append("\n");
                        break;
                    }
                }

            }

            System.out.println(sb);
        }
    }
}