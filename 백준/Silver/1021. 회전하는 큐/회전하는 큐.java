import java.io.*;
import java.util.*;

class Main {

    static class Node {
        int idx, value;

        Node(int idx, int value) {
            this.idx = idx;
            this.value = value;
        }

        @Override
        public String toString() {
            return "(" + idx + ", " + value + ")";
        }
    }

    public static void main(String[] args) throws IOException {
        // 코드 작성
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            int n = Integer.parseInt(st.nextToken());

            int m = Integer.parseInt(st.nextToken());

            Deque<Node> deq = new ArrayDeque<>();

            for (int i = 1; i <= n; i++) {
                deq.addLast(new Node(i, i));
            }

            st = new StringTokenizer(br.readLine());

            int[] arr = new int[m];

            for (int i = 0; i < m; i++) {
                arr[i] = Integer.parseInt(st.nextToken());
            }

            int answer = 0;

            for (int target : arr) {
                int idx = 0;

                for (Node node : deq) {
                    if (node.value == target)
                        break;
                    idx++;
                }

                int half = deq.size() / 2;

                if (idx <= half) {
                    // 2번 연산
                    while (deq.peekFirst().value != target) {
                        deq.addLast(deq.pollFirst());
                        answer++;
                    }
                } else {
                    // 3번 연산
                    while (deq.peekFirst().value != target) {
                        deq.addFirst(deq.pollLast());
                        answer++;
                    }

                }

                deq.pollFirst(); // 1번 연산
            }

            System.out.println(answer);
        }
    }
}