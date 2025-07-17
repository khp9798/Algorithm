import java.io.*;
import java.util.*;

class Main {
    public static void main(String[] args) throws IOException {
        // 코드 작성
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            int n = Integer.parseInt(st.nextToken());

            int m = Integer.parseInt(st.nextToken());

            int[] trains = new int[n];

            for (int i = 0; i < m; i++) {
                st = new StringTokenizer(br.readLine());

                int command = Integer.parseInt(st.nextToken());

                int trainIdx = Integer.parseInt(st.nextToken()) - 1;

                switch (command) {
                    case 1: // 탑승
                        int x = Integer.parseInt(st.nextToken()) - 1;
                        trains[trainIdx] |= (1 << x);
                        break;
                    case 2: // 하차
                        int y = Integer.parseInt(st.nextToken()) - 1;
                        trains[trainIdx] &= ~(1 << y);
                        break;
                    case 3: // 앞으로 이동
                        trains[trainIdx] = (trains[trainIdx] << 1) & ((1 << 20) - 1);
                        break;
                    case 4: // 뒤로 이동
                        trains[trainIdx] = trains[trainIdx] >>> 1;
                        break;
                }

            }

            Set<Integer> set = new HashSet<>();
            for (int i = 0; i < n; i++) {
                set.add(trains[i]);
            }

            System.out.println(set.size());
        }
    }
}