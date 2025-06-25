import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            int N = Integer.parseInt(br.readLine());


            PriorityQueue<Integer> pq = new PriorityQueue<>();

            for (int i = 0; i < N; i++) {
                pq.offer(Integer.parseInt(br.readLine()));
            }

            long answer = 0;
            while (pq.size() > 1) {

                int num1 = pq.poll();
                int num2 = pq.poll();

                answer += num1 + num2;

                pq.offer(num1 + num2);
            }

            System.out.println(answer);

        }

    }
}
