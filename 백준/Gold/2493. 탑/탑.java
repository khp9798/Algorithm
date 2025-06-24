import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        // 1) 입력 처리: try-with-resources로 자동 close
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            int n = Integer.parseInt(br.readLine());
            int[] heights = new int[n];
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            for (int i = 0; i < n; i++) {
                heights[i] = Integer.parseInt(st.nextToken());
            }

            // 2) 결과 배열과 스택(Deque) 초기화
            int[] answer = new int[n];
            Deque<Integer> stack = new ArrayDeque<>();

            // 3) 핵심 로직: 스택에 인덱스 저장
            for (int i = 0; i < n; i++) {
                // 나보다 낮은 타워는 다 pop
                while (!stack.isEmpty() && heights[stack.peek()] < heights[i]) {
                    stack.pop();
                }
                // 스택이 비었으면 0, 아니면 인덱스+1
                answer[i] = stack.isEmpty() ? 0 : stack.peek() + 1;
                stack.push(i);
            }

            // 4) 출력: StringBuilder로 한 번에
            StringBuilder sb = new StringBuilder();
            for (int x : answer) {
                sb.append(x).append(' ');
            }
            System.out.print(sb);
        }
    }
}
