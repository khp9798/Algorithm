

import java.util.Scanner;

public class Main {

	static int N;
	static int M;


	static int[] res;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		N = sc.nextInt();
		M = sc.nextInt();
		
		res = new int[M];

		sunyeol(1, 0);

	}

	private static void sunyeol(int start, int depth) {
		if (depth == M) {
			for (int i = 0; i < M; i++) {
				System.out.print(res[i] + " ");
			}

			System.out.println();
			return;
		}

		if (start > N) {
			return;
		}

		for (int i = start; i < N + 1; i++) {

			res[depth] = i;
			sunyeol(i, depth + 1);

		}

	}

}
