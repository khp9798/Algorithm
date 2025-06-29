
import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            int T = Integer.parseInt(br.readLine());

            StringBuilder sb = new StringBuilder();
            task:
            while (T-- > 0) {
                //수행할 함수
                char[] p = br.readLine().toCharArray();

                //배열에 들어있는 수
                int n = Integer.parseInt(br.readLine());

                //배열에 들어있는 정수 정보
                String str = br.readLine();

                //괄호 제거 
                String newStr = str.substring(1, str.length() - 1);

                Deque<Integer> deque = new ArrayDeque<>();

                if (n > 0) {
                    //숫자들 분리
                    StringTokenizer st = new StringTokenizer(newStr, ",");
                    while (st.hasMoreTokens()) {
                        deque.offerLast(Integer.parseInt(st.nextToken()));
                    }
                }

                boolean rev = false;
                for (char command : p) {
                    if (command == 'R') {
                        rev = !rev;
                    } else {
                        if (deque.isEmpty()) {
                            sb.append("error").append("\n");
                            continue task;
                        } else {
                            if (rev) {
                                deque.pollLast();
                            } else {
                                deque.pollFirst();
                            }
                        }
                    }
                }

                if (deque.isEmpty()) {
                    sb.append("[]\n");
                } else {
                    sb.append('[');
                    while (!deque.isEmpty()) {
                        sb.append(rev ? deque.pollLast() : deque.pollFirst());
                        sb.append(deque.isEmpty() ? ']' : ',');
                    }
                    sb.append("\n");
                }

            }

            System.out.println(sb);
        }
    }

}
