import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {

    static int[] dr = {-1, 0, 1, 0};  // 상, 우, 하, 좌
    static int[] dc = {0, 1, 0, -1};
    static int N;
    static char[][] map;
    static int startX, startY, destX, destY;  // 출발지와 도착지 좌표

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());  // 테스트 케이스 수 입력

        for (int t = 1; t <= T; t++) {
            N = Integer.parseInt(br.readLine());  // 필드 크기 입력
            map = new char[N][N];

            for (int i = 0; i < N; i++) {
                String row = br.readLine();
                for (int j = 0; j < N; j++) {
                    map[i][j] = row.charAt(j);
                    if (map[i][j] == 'X') {  // 출발지
                        startX = i;
                        startY = j;
                    } else if (map[i][j] == 'Y') {  // 도착지
                        destX = i;
                        destY = j;
                    }
                }
            }

            int Q = Integer.parseInt(br.readLine());  // 커맨드 개수 입력
            StringBuilder result = new StringBuilder("#" + t + " ");

            for (int q = 0; q < Q; q++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                int C = Integer.parseInt(st.nextToken());  // 커맨드 길이
                String commands = st.nextToken();  // 커맨드 입력

                if (simulate(commands)) {
                    result.append("1 ");  // 도착지에 도달 가능
                } else {
                    result.append("0 ");  // 도착지에 도달 불가능
                }
            }
            System.out.println(result.toString().trim());
        }
    }

    // RC카의 움직임을 시뮬레이션하는 메서드
    static boolean simulate(String commands) {
        int x = startX, y = startY;  // 현재 위치
        int direction = 0;  // 0: 상, 1: 우, 2: 하, 3: 좌 (초기 방향: 상)

        for (char cmd : commands.toCharArray()) {
            if (cmd == 'A') {  // 앞으로 이동
                int nx = x + dr[direction];
                int ny = y + dc[direction];
                if (nx >= 0 && ny >= 0 && nx < N && ny < N && map[nx][ny] != 'T') {
                    x = nx;
                    y = ny;  // 이동 가능한 경우 이동
                }
            } else if (cmd == 'L') {  // 왼쪽으로 회전
                direction = (direction + 3) % 4;
            } else if (cmd == 'R') {  // 오른쪽으로 회전
                direction = (direction + 1) % 4;
            }
        }

        return x == destX && y == destY;  // 최종 위치가 목적지인지 확인
    }
}
