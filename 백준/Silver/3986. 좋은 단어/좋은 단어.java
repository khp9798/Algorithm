import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.Stack;

public class Main {

    // 단어가 "좋은 단어"인지 판단하는 메서드
    private static boolean isGoodWord(String word) {
        Stack<Character> stack = new Stack<>();

        for (char ch : word.toCharArray()) {
            if (!stack.isEmpty() && stack.peek() == ch) {
                stack.pop(); // 같은 문자 짝 → 제거
            } else {
                stack.push(ch); // 다른 문자 → 스택에 추가
            }
        }

        // 스택이 비었으면 모든 문자가 짝지어 제거됨
        return stack.isEmpty();
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int count = 0;

        for (int i = 0; i < n; i++) {
            String word = br.readLine();
            if (isGoodWord(word)) {
                count++;
            }
        }

        System.out.println(count);
    }
}
