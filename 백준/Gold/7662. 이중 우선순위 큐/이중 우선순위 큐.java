import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {

        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {

            int T = Integer.parseInt(br.readLine());

            StringBuilder sb = new StringBuilder();

            while (T-- > 0) {
                int k = Integer.parseInt(br.readLine());

                TreeMap<Integer, Integer> treeMap = new TreeMap<>();

                for (int i = 0; i < k; i++) {
                    String[] cmd = br.readLine().split(" ");

                    int num = Integer.parseInt(cmd[1]);

                    if (cmd[0].equals("I")) {
                        treeMap.merge(num, 1, Integer::sum);
                    } else if (!treeMap.isEmpty()) {
                        int key = (num == -1 ? treeMap.firstKey() : treeMap.lastKey());
                        treeMap.compute(key, (t, cnt) -> cnt == 1 ? null : cnt - 1);
                    }
                }

                if (treeMap.isEmpty()) {
                    sb.append("EMPTY").append("\n");
                } else {
                    sb.append(treeMap.lastKey()).append(" ").append(treeMap.firstKey()).append("\n");
                }
            }

            System.out.println(sb);
        }

    }
}
