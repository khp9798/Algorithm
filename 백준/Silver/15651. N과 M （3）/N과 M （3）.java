

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.Scanner;

public class Main {

	static int N;
	static int M;

	static int[] res;
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

	public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner(System.in);
		
		N = sc.nextInt();
		M = sc.nextInt();
		
		res = new int[M];

		sunyeol(1, 0);
		
		bw.flush();
		bw.close();

	}

	private static void sunyeol(int start, int depth) throws IOException {
		if (depth == M) {
			for (int i = 0; i < M; i++) {
				bw.write(res[i] + " ");
			}

			bw.write("\n");
			return;
		}


		for (int i = 1; i < N + 1; i++) {

			res[depth] = i;
			sunyeol(i, depth + 1);

		}

	}

}
