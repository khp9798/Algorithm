import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String target = br.readLine(); // 찾을 숫자 문자열
        int index = 0; // target의 현재 비교 위치
        int num = 1;

        while (index < target.length()) {
            String cur = String.valueOf(num); // 현재 숫자 num을 문자열로 바꿈
            for (int i = 0; i < cur.length(); i++) {
                if (index < target.length() && cur.charAt(i) == target.charAt(index)) {
                    index++;
                }
            }
            num++;
        }

        // num - 1이 정답
        System.out.println(num - 1);
    }
}
