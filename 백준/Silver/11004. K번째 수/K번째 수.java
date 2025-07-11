import java.io.*;
import java.util.*;

class Main {
    public static void main(String[] args) throws IOException {
        // 코드 작성
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            int n = Integer.parseInt(st.nextToken());

            int k = Integer.parseInt(st.nextToken());

            List<Integer> arr = new ArrayList<>();

            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < n; i++) {
                arr.add(Integer.parseInt(st.nextToken()));
            }

            Collections.sort(arr);

            System.out.println(arr.get(k-1));
        }
    }
}