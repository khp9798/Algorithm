

import java.util.Scanner;

public class Main {

	static int N;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		N = sc.nextInt();

		System.out.println(facto(N));
	}

	static long res = 1;

	static int facto(int i) {
		if (i <= 1) {
			return i;
		}

		return facto(i - 1) + facto(i - 2);

	}

}
