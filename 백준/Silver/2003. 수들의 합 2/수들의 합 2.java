
import java.io.*;
import java.util.*;

class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        int[] arr = new int[n];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        //i부터 j까지의 합이 m이랑 같은 경우의 수를 구하는 문제
        //합이 m보다 작으면 j값을 올리고
        //합이 m보다 크면 i값을 올려라
        int answer = 0;

        int i = 0;
        int j = 0;
        int sum = arr[0];

        while (i < n) {

            //sum이 m보다 크거나 같으면 i를 올린다.
            if (sum >= m) {
                //m이랑 합이 같으면 경우의 수를 늘려라
                if (sum == m) {
                    answer++;
                }
                sum -= arr[i];
                i++;
            } //합이 m보다 작으면 j값을 올린다
            else {
                j++;
                if (j == n) {
                    break;
                }
                if (j < n) {
                    sum += arr[j];
                }
            }
        }

        System.out.println(answer);

        br.close();

    }
}
