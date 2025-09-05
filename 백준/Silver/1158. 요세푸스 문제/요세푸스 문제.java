import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        List<Integer> arr = new ArrayList<>(n);
        for (int i = 1; i <= n; i++) arr.add(i);

        StringBuilder sb = new StringBuilder();
        sb.append('<');

        int idx = 0; // 현재 제거할 위치의 시작 인덱스
        while (!arr.isEmpty()) {
            idx = (idx + k - 1) % arr.size(); // k번째로 이동
            int removed = arr.remove(idx);    // 해당 위치 제거
            sb.append(removed);
            if (!arr.isEmpty()) sb.append(", ");
        }
        sb.append('>');

        System.out.println(sb);
    }
}
