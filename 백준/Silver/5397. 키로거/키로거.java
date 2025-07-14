import java.io.*;
import java.util.*;

class Main {

    /*
     * 길이가 L인 문자열
     * 
     * - : 백스페이스, 커서의 앞에 글자가 존재하면 그 글자를 지운다 => pop
     * < or > : 화살표, 커서의 위치를 움직일 수 있다면(!isEmpty라면) 왼쪽 또는 오른쪽으로 1만큼 움직인다.
     * 
     * 만약 커서의 위치가 줄의 마지막이 아니라면, 커서 및 커서 오른쪽에 있는 모든 문자는 오른쪽으로 한 칸 이동
     */
    public static void main(String[] args) throws IOException {
        // 코드 작성
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            int T = Integer.parseInt(br.readLine());

            StringBuilder sb = new StringBuilder();

            while (T-- > 0) {
                String logger = br.readLine();

                // 커서 기준 왼쪽 오른쪽
                Deque<Character> left = new ArrayDeque<>();
                Deque<Character> right = new ArrayDeque<>();

                for (int i = 0; i < logger.length(); i++) {
                    char c = logger.charAt(i);

                    // 백스페이스 일 때
                    if (c == '-') {
                        if (!left.isEmpty()) {
                            left.pollLast();
                        }
                    }

                    // 화살표 <
                    else if (c == '<') {
                        if (!left.isEmpty()) {
                            right.addFirst(left.pollLast());
                        }
                    }

                    // 화살표 >
                    else if (c == '>') {
                        if (!right.isEmpty()) {
                            left.addLast(right.pollFirst());
                        }
                    }

                    else {
                        left.addLast(c);
                    }

                }

                while (!left.isEmpty()) {
                    sb.append(left.pollFirst());
                }
                while (!right.isEmpty()) {
                    sb.append(right.pollFirst());
                }

                sb.append("\n");
            }

            System.out.println(sb);
        }
    }
}