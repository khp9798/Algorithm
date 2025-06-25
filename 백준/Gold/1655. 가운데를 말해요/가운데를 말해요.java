import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {

            PriorityQueue<Integer> left = new PriorityQueue<>(Comparator.reverseOrder());
            PriorityQueue<Integer> right = new PriorityQueue<>();

            int N = Integer.parseInt(br.readLine());

            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < N; i++) {
                int num = Integer.parseInt(br.readLine());
                left.offer(num);

                right.offer(left.poll());

                if (left.size() < right.size()) {
                    left.offer(right.poll());
                }

                sb.append(left.peek()).append("\n");
            }

            System.out.println(sb);
        }

    }

}
