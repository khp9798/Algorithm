import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        Deque<Integer> deq = new ArrayDeque<>();

        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            String command = st.nextToken();

            switch (command) {
                case "push_front":
                    deq.addFirst(Integer.parseInt(st.nextToken()));
                    break;
                case "push_back":
                    deq.addLast(Integer.parseInt(st.nextToken()));
                    break;
                case "pop_front":
                    sb.append(deq.isEmpty() ? -1 : deq.pollFirst()).append("\n");
                    break;
                case "pop_back":
                    sb.append(deq.isEmpty() ? -1 : deq.pollLast()).append("\n");
                    break;
                case "size":
                    sb.append(deq.size()).append("\n");
                    break;
                case "empty":
                    sb.append(deq.isEmpty() ? 1 : 0).append("\n");
                    break;
                case "front":
                    sb.append(deq.isEmpty() ? -1 : deq.peekFirst()).append("\n");
                    break;
                case "back":
                    sb.append(deq.isEmpty() ? -1 : deq.peekLast()).append("\n");
                    break;
                default:
                    break;
            }
        }

        System.out.println(sb);
    }
}