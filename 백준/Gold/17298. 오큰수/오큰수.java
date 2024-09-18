import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];
        int[] result = new int[n];
        Stack<Integer> stack = new Stack<>();

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        // 뒤에서부터 탐색
        for (int i = n - 1; i >= 0; i--) {
            // 스택에서 현재 arr[i]보다 작거나 같은 값은 모두 제거
            while (!stack.isEmpty() && stack.peek() <= arr[i]) {
                stack.pop();
            }
            // 스택이 비어있으면 오큰수가 없으므로 -1 저장
            if (stack.isEmpty()) {
                result[i] = -1;
            } else {
                // 스택의 top이 오큰수가 됨
                result[i] = stack.peek();
            }
            // 현재 값 스택에 추가
            stack.push(arr[i]);
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) {
            sb.append(result[i]).append(" ");
        }
        System.out.println(sb.toString());
    }
}
