import java.util.*;
import java.io.*;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		// 수의 개수
		int n = Integer.parseInt(br.readLine());

		// 수 정보 배열
		int[] num = new int[n];

		StringTokenizer st = new StringTokenizer(br.readLine());

		for (int i = 0; i < n; i++) {
			num[i] = Integer.parseInt(st.nextToken());
		}

		Arrays.sort(num);

		int answer = 0;

		for (int i = 0; i < n; i++) {

			// 좋은 수인지 판단해야할 수
			long findNum = num[i];
			int startIdx = 0;
			int endIdx = n - 1;

			while (startIdx < endIdx) {
				if (startIdx == i) {
					startIdx++;
				} else if (endIdx == i) {
					endIdx--;
				} else if (num[startIdx] + num[endIdx] == findNum) {
					answer++;
					break;
				} else if (num[startIdx] + num[endIdx] > findNum) {
					endIdx--;
				} else {
					startIdx++;
				}
			}

		}

		System.out.println(answer);

	}

}
