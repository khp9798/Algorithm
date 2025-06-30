import java.io.*;
import java.util.*;

class Main {

    // 수빈점
    static int n;

    // 동생점
    static int k;

    static int[] dist = new int[100001];

    public static void main(String[] args) throws IOException {
        // 코드 작성
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            String[] info = br.readLine().split(" ");

            n = Integer.parseInt(info[0]);

            k = Integer.parseInt(info[1]);

            Arrays.fill(dist, Integer.MAX_VALUE);

            bfs(n);
        }

    }

    static void bfs(int start) {
        Queue<Integer> q = new ArrayDeque<>();
        dist[start] = 0;
        q.offer(start);

        int seconds = Integer.MAX_VALUE;

        while (!q.isEmpty()) {
            int curr = q.poll();

            if (curr == k) {
                break;
            }

            int[] cases = new int[] { curr - 1, curr + 1, 2 * curr };

            for (int c : cases) {
                if (c < 0 || c >= 100001)
                    continue;
                if (dist[c] != Integer.MAX_VALUE)
                    continue;

                q.offer(c);
                dist[c] = dist[curr] + 1;
            }
        }

        System.out.print(dist[k]);
    }
}