import java.util.Arrays;
import java.util.Scanner;

public class Main {

	static int[][] result;
	static int innings = 1;
	static int N;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		// 이닝 수
		N = sc.nextInt();

		result = new int[N + 1][10];

		for (int i = 1; i <= N; i++) {
			for (int j = 1; j <= 9; j++) {
				result[i][j] = sc.nextInt();
			}
		}

		visited = new boolean[10];

		dfs(1);
		
		System.out.println(res);

	}

	static boolean[] visited;
	static int[] order = new int[9];

	static void dfs(int cnt) {
		if (cnt == 9) {
//			System.out.println(Arrays.toString(order));
			score=0;
			innings = 1;
			idx=1;
			baseball();
			res = Math.max(score,res);
			return;
		}

		for (int i = 2; i <= 9; i++) {
			if (!visited[i]) {
				visited[i] = true;
				order[cnt] = i;
				dfs(cnt + 1);
				visited[i] = false;
			}
		}
	}

	static int idx;
	static int score;
	static int res = Integer.MIN_VALUE;

	static void baseball() {

		while (innings <= N) {
			int lu = 0;
			int outcnt = 0;
			boolean [] bases = new boolean[4];
			
			while (outcnt < 3) {
				int playerNum;

				if (idx > 9) {
					idx = 1;
					playerNum = order[idx];
				}
				if (idx > 4) {
					playerNum = order[idx - 1];
				} else if (idx == 4) {
					playerNum = 1;
				} else {
					playerNum = order[idx];
				}

				int hit = result[innings][playerNum]; // 현재 타자의 결과 (0: 아웃, 1: 1루타, 2: 2루타 등)

	            if (hit == 0) {
	                outcnt++; // 아웃일 경우 아웃 카운트 증가
	            } else if (hit == 4) { // 홈런일 경우
	                // 홈으로 들어오는 모든 주자 점수 추가
	                for (int i = 1; i <= 3; i++) {
	                    if (bases[i]) score++; // 1루, 2루, 3루에 있는 주자들 점수
	                    bases[i] = false; // 주자들은 홈으로 들어오므로 베이스는 비워짐
	                }
	                score++; // 타자 자신도 홈런으로 점수 추가
	            } else {
	                // 주자가 해당 루 수만큼 진루
	                for (int i = 3; i >= 1; i--) {
	                    if (bases[i]) {
	                        if (i + hit > 3) score++; // 홈으로 들어가면 점수 추가
	                        else bases[i + hit] = true; // 그 외의 경우 해당 루로 이동
	                        bases[i] = false; // 기존 루는 비워짐
	                    }
	                }
	                bases[hit] = true; // 타자는 해당 타격에 맞는 루로 이동
	            }
				

				idx++;
			}

			innings++;

		}

		
		return;

	}

}