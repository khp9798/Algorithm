import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine());

		// 표의 크기
		int n = Integer.parseInt(st.nextToken());

		// 합을 구해야 하는 횟수
		int m = Integer.parseInt(st.nextToken());

		// 문제는 1,1이 시작으로 가정하기 때문에 n+1, n+1로 해줘야함.
		int[][] arr = new int[n + 1][n + 1];

		// 배열 값 받기
		for (int i = 1; i <= n; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 1; j <= n; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		// 구간 합 배열
		int[][] D = new int[n + 1][n + 1];

		// 구간 합 계산하기
		for (int i = 1; i <= n; i++) {
			for (int j = 1; j <= n; j++) {
				D[i][j] = D[i - 1][j] + D[i][j - 1] - D[i - 1][j - 1] + arr[i][j];
			}
		}

		StringBuilder sb = new StringBuilder();
		// 합을 구해야 하는 구간이 M 주어짐.
		for (int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine());

			int x1 = Integer.parseInt(st.nextToken());
			int y1 = Integer.parseInt(st.nextToken());

			int x2 = Integer.parseInt(st.nextToken());
			int y2 = Integer.parseInt(st.nextToken());

			sb.append(D[x2][y2] - D[x2][y1 - 1] - D[x1 - 1][y2] + D[x1 - 1][y1 - 1]).append("\n");
		}
		
		System.out.println(sb.toString());

	}

}
