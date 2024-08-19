

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());

		int[] bag = new int[N + 1];

		for (int i = 1; i < N + 1; i++) {
			bag[i] = i;
		}

		int M = Integer.parseInt(st.nextToken());

		for (int k = 0; k < M; k++) {
			st = new StringTokenizer(br.readLine());

			int i = Integer.parseInt(st.nextToken());

			int j = Integer.parseInt(st.nextToken());

			for (int a = 0; a <= (j - i) / 2; a++) {
				int tmp = bag[i + a];
				bag[i + a] = bag[j - a];
				bag[j - a] = tmp;
			}

		}

		for (int i = 1; i < N + 1; i++) {
			System.out.print(bag[i] + " ");
		}

	}

}
