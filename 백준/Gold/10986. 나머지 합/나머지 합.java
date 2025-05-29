import java.util.*;
import java.io.*;

public class Main {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine());

		long answer = 0;

		// 수의 개수
		int n = Integer.parseInt(st.nextToken());

		// 나누는 수
		int m = Integer.parseInt(st.nextToken());

		// 수 입력 받기
		st = new StringTokenizer(br.readLine());

		// 구간 합 배열
		long[] sum = new long[n];

		sum[0] = Integer.parseInt(st.nextToken());
		for (int i = 1; i < n; i++) {
			sum[i] = sum[i - 1] + Integer.parseInt(st.nextToken());
		}

		//나머지 값이 같은게 있는지 카운트 배열로 확인 
		int[] C = new int[m];

		// 구간 합을 M으로 나눈 나머지 값으로 바꾼다.
		// 거기서 0으로 나누어 떨어지는 것부터 센다.
		for (int i = 0; i < n; i++) {
			int remain = (int) (sum[i] % m);
			if (remain == 0) {
				answer++;
			}

			// 두 구간 합의 나머지 값이 같으면 그 사이 구간 합을 m으로 나눴을 때 0이 된다.
			C[remain]++;
		}

		// 합이 m으로 나누어 떨어지는 쌍을 구하는 것이기 때문에 나머지 값이 같은 경우의 수 중 2개를 고르는 경우를 구하면 된다.
		for (int i = 0; i < m; i++) {
			if (C[i] > 1) {
				answer += (long) C[i] * (C[i] - 1) / 2;
			}
		}

		System.out.println(answer);

	}

}
