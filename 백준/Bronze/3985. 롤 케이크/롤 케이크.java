import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int L = sc.nextInt();

		int[] cake = new int[L];

		int N = sc.nextInt();

		int predictsum = 0;
		int predict = 0;
		int factsum = 0;
		int fact = 0;

		for (int i = 1; i <= N; i++) {
			int startidx = sc.nextInt();
			int endidx = sc.nextInt();

			int sum = endidx - startidx + 1;
			if (predictsum < sum) {
				predictsum = sum;
				predict = i;
			}

			int cnt = 0;
			for (int j = startidx - 1; j <= endidx - 1; j++) {
				if (cake[j] == 0) {
					cake[j] = i;
					cnt++;

				}
			}

			if (cnt > factsum) {
				factsum = cnt;
				fact = i;
			}

		}

		System.out.println(predict);
		System.out.println(fact);

	}

}
