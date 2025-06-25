import java.io.*;
import java.util.*;

public class Main {

    static class Dia {
        int weight;
        int price;

        Dia(int weight, int price) {
            this.weight = weight;
            this.price = price;
        }

    }

    public static void main(String[] args) throws IOException {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            int n = Integer.parseInt(st.nextToken());

            int k = Integer.parseInt(st.nextToken());

            Dia[] dias = new Dia[n];

            for (int i = 0; i < n; i++) {
                st = new StringTokenizer(br.readLine());

                int m = Integer.parseInt(st.nextToken());
                int v = Integer.parseInt(st.nextToken());
                dias[i] = new Dia(m, v);
            }

            Arrays.sort(dias, (a, b) -> a.weight - b.weight);

            long answer = 0;

            int[] bags = new int[k];

            for (int i = 0; i < k; i++) {
                bags[i] = Integer.parseInt(br.readLine());
            }

            Arrays.sort(bags);

            int idx = 0;

            PriorityQueue<Integer> pq = new PriorityQueue<>(Comparator.reverseOrder());
            for (int i = 0; i < k; i++) {

                while (idx < n && dias[idx].weight <= bags[i]) {
                    pq.offer(dias[idx].price);
                    idx++;
                }

                if (!pq.isEmpty()) {
                    answer += pq.poll();
                }
            }

            System.out.println(answer);
        }

    }
}
