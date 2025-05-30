import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		// 재료의 개수
		int n = Integer.parseInt(br.readLine());

		// 갑옷을 만드는데 필요한 수
		int m = Integer.parseInt(br.readLine());

		// 재료 고유 번호
		int[] num = new int[n];

		StringTokenizer st = new StringTokenizer(br.readLine());

		for (int i = 0; i < n; i++) {
			num[i] = Integer.parseInt(st.nextToken());
		}

		// 투포인터 알고리즘을 위한 정렬을 진행
		Arrays.sort(num);

		int startidx = 0;
		int endidx = n - 1;
		int answer = 0;

		while (startidx < endidx) {
			int sum = num[startidx] + num[endidx];
			if (sum < m) {
				startidx++;
			} else if (sum > m) {
				endidx--;
			} else {
				answer++;
				startidx++;
				endidx--;
			}
		}

		System.out.println(answer);

	}

}
