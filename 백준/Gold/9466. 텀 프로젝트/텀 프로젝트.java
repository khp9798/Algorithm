
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int[] choice;
    static boolean[] visited, done;
    static int teamCount;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        StringTokenizer st;

        while (T-- > 0) {
            int n = Integer.parseInt(br.readLine());
            choice = new int[n + 1];
            visited = new boolean[n + 1];
            done    = new boolean[n + 1];
            teamCount = 0;

            st = new StringTokenizer(br.readLine());
            for (int i = 1; i <= n; i++) {
                choice[i] = Integer.parseInt(st.nextToken());
            }

            for (int i = 1; i <= n; i++) {
                if (!visited[i]) dfs(i);
            }

            // 팀을 이루지 못한 학생 수 = 전체 n - 팀에 속한 학생 수
            System.out.println(n - teamCount);
        }
    }

    static void dfs(int u) {
        visited[u] = true;
        int v = choice[u];

        if (!visited[v]) {
            dfs(v);
        } else if (!done[v]) {
            // 사이클이 시작된 지점 v부터 u까지 돌아가며 팀원 수를 센다
            for (int x = v; x != u; x = choice[x]) {
                teamCount++;
            }
            teamCount++;  // u 자신
        }

        done[u] = true;  // 이 노드는 더 이상 사이클 검사할 필요 없음
    }
}
