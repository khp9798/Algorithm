import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
            int n = Integer.parseInt(br.readLine());

            int[] num = new int[n];
            for (int i = 0; i < n; i++) {
                num[i] = Integer.parseInt(br.readLine());
            }

            Arrays.sort(num);

            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < n; i++) {
                sb.append(num[i]).append("\n");
            }
            bw.write(sb.toString());
            bw.flush();
        }
    }
}
