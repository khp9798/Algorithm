import java.io.*;
import java.util.*;

class Main {
    public static void main(String[] args) throws IOException {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            int n = Integer.parseInt(br.readLine());

            PriorityQueue<Integer> pq = new PriorityQueue<>(Comparator.reverseOrder());

            StringBuilder sb = new StringBuilder();
            while (n-- > 0) {
                int num = Integer.parseInt(br.readLine());

                if (num > 0)
                    pq.add(num);
                else
                    sb.append(pq.isEmpty() ? 0 : pq.poll()).append("\n");
            }

            System.out.println(sb);
        }

    }
}