import java.io.*;
import java.util.*;

class Main {
    public static void main(String[] args) throws IOException {
        // 코드 작성
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            // ()인 괄호열의 값은 2
            // []인 괄호열의 값은 3

            String info = br.readLine();

            Stack<Object> st = new Stack<>();

            for (int i = 0; i < info.length(); i++) {
                char c = info.charAt(i);

                switch (c) {
                    case '(':
                        st.push(c);
                        break;
                    case '[':
                        st.push(c);
                        break;
                    case ')':
                        if (!st.isEmpty() && st.peek() instanceof Character
                                && (Character) st.peek() == '(') {
                            st.pop();
                            st.push(2);
                        }

                        else if (!st.isEmpty() && st.peek() instanceof Integer) {
                            int sum = 0;
                            while (!st.isEmpty() && st.peek() instanceof Integer) {
                                sum += (Integer) st.pop();
                            }

                            if (st.isEmpty() || st.peek() instanceof Integer || (Character) st.peek() != '(') {
                                System.out.println(0);
                                return;
                            }

                            st.pop();
                            st.push(2 * sum);
                        }

                        else {
                            System.out.println(0);
                            return;
                        }
                        break;
                    case ']':
                        if (!st.isEmpty() && st.peek() instanceof Character
                                && (Character) st.peek() == '[') {
                            st.pop();
                            st.push(3);
                        }

                        else if (!st.isEmpty() && st.peek() instanceof Integer) {
                            int sum = 0;
                            while (!st.isEmpty() && st.peek() instanceof Integer) {
                                sum += (Integer) st.pop();
                            }

                            if (st.isEmpty() || st.peek() instanceof Integer || (Character) st.peek() != '[') {
                                System.out.println(0);
                                return;
                            }

                            st.pop();
                            st.push(3 * sum);

                        }

                        else {
                            System.out.println(0);
                            return;
                        }
                        break;
                }

            }

            int res = 0;

            while (!st.isEmpty()) {
                if (!(st.peek() instanceof Integer)) {
                    System.out.println(0);
                    return;
                }
                res += (Integer) st.pop();
            }
            System.out.println(res);
        }
    }
}