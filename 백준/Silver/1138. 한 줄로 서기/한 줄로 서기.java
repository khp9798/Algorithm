import java.io.*;
import java.util.*;

class Main {
    public static void main(String[] args) throws IOException {
        // 코드 작성
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            int n = Integer.parseInt(br.readLine());

            int[] tallerThanMe = new int[n];

            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int i = 0; i < n; i++) {
                tallerThanMe[i] = Integer.parseInt(st.nextToken());
            }

            List<Integer> lineInfo = new ArrayList<>();

            for (int i = n - 1; i >= 0; i--) {
                int height = i + 1;
                int count = tallerThanMe[i];

                lineInfo.add(count, height);
            }

            for (int h : lineInfo) {
                System.out.print(h + " ");
            }
        }
    }
}