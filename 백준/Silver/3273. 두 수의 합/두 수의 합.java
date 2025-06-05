import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int n = Integer.parseInt(br.readLine());

		StringTokenizer st = new StringTokenizer(br.readLine());

		int[] num = new int[n];

		for (int i = 0; i < n; i++) {
			num[i] = Integer.parseInt(st.nextToken());
		}

		Arrays.sort(num);

		int x = Integer.parseInt(br.readLine());

		int start = 0;
		int end = n - 1;

		int answer = 0;

		while (start < end) {
			int sum = num[start] + num[end];
			if (sum == x) {
				answer++;
				start++;
				end--;
			} else if (sum > x) {
				end--;
			} else {
				start++;
			}

		}

		System.out.println(answer);

	}

}
