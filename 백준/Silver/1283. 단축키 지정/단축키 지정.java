import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        Set<Character> usedKeys = new HashSet<>();  // 대문자로 저장

        while (n-- > 0) {
            String line = br.readLine();
            String[] words = line.split(" ", -1);   // 공백 유지(split limit)
            int assignIndex = -1;

            // 1) 각 단어의 첫 글자로 할당 시도
            int cursor = 0;  // 현재 단어 첫 글자의 인덱스
            for (String w : words) {
                if (!w.isEmpty()) {
                    char c = w.charAt(0);
                    char up = Character.toUpperCase(c);
                    if (!usedKeys.contains(up)) {
                        usedKeys.add(up);
                        assignIndex = cursor;
                        break;
                    }
                }
                cursor += w.length() + 1;  // 단어 길이 + 뒤의 공백
            }

            // 2) 실패 시, 라인 전체 문자로 할당 시도
            if (assignIndex < 0) {
                for (int i = 0; i < line.length(); i++) {
                    char c = line.charAt(i);
                    if (c == ' ') continue;
                    char up = Character.toUpperCase(c);
                    if (!usedKeys.contains(up)) {
                        usedKeys.add(up);
                        assignIndex = i;
                        break;
                    }
                }
            }

            // 3) 결과 문자열 만들기
            if (assignIndex < 0) {
                // 할당 실패: 그대로 출력
                System.out.println(line);
            } else {
                StringBuilder sb = new StringBuilder();
                // 할당 전 부분
                sb.append(line, 0, assignIndex);
                // [핫키] 삽입
                sb.append('[')
                  .append(line.charAt(assignIndex))
                  .append(']');
                // 할당 후 부분
                sb.append(line.substring(assignIndex + 1));
                System.out.println(sb);
            }
        }
    }
}
