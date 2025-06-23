
import java.io.*;
import java.util.*;

public class Main {

    static int[] count, arr;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        arr = new int[n];
        count = new int[100001];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int left = 0, right = 0;
        long answer = 0;

        while (left < n) {
            while(right<n && count[arr[right]] == 0){
                count[arr[right++]]++;
            }

            answer+=right-left;

            count[arr[left++]]--;
            
        }

        System.out.println(answer);
    }

    
}
