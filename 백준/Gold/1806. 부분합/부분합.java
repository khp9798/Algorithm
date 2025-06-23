
import java.io.*;
import java.util.*;

class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken()), s = Integer.parseInt(st.nextToken());

        int[] arr = new int[n];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int left = 0, right = 0, sum = arr[0];
        int length = Integer.MAX_VALUE;

        while (left < n) {
            if (sum >= s) {
                length = Math.min(length, right - left + 1);
                sum -= arr[left++];
            } else {
                if (right + 1 == n) {
                    break;
                }
                sum += arr[++right];
            }
        }

        System.out.println(length == Integer.MAX_VALUE ? 0 : length);

    }
}
