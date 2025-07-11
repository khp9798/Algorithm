import java.io.*;
import java.util.*;

class Main {
    public static void main(String[] args) throws IOException {
        // 코드 작성
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            String[] info = br.readLine().split(" ");

            int n = Integer.parseInt(info[0]);

            int m = Integer.parseInt(info[1]);

            HashMap<Integer, String> dogam = new HashMap<>();
            HashMap<String, Integer> dogam2 = new HashMap<>();

            for (int i = 1; i <= n; i++) {
                String poketmon = br.readLine();
                dogam.put(i, poketmon);
                dogam2.put(poketmon, i);
            }

            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < m; i++) {
                String find = br.readLine();

                if (dogam2.containsKey(find)) {
                    sb.append(dogam2.get(find)).append("\n");
                } else {
                    sb.append(dogam.get(Integer.parseInt(find))).append("\n");
                }
            }

            System.out.println(sb);
        }
    }
}