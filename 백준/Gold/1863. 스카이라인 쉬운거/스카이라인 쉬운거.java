import java.io.*;
import java.util.*;

class Main {
    public static void main(String[] args) throws IOException {
        // 코드 작성
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            int n = Integer.parseInt(br.readLine());

            Stack<Integer> stack = new Stack<>();

            int answer = 0;

            StringTokenizer st;
            for(int i=0; i<n; i++){
                st = new StringTokenizer(br.readLine());

                st.nextToken();
                int y = Integer.parseInt(st.nextToken());

                while(!stack.isEmpty() && stack.peek() > y ){
                    stack.pop();
                }

                if (y > 0 && (stack.isEmpty() || stack.peek() < y)) {
                    stack.push(y);
                    answer++;
                }

                if(!stack.isEmpty() && stack.peek() == y) continue;
            }

            System.out.println(answer);
        }
    }
}