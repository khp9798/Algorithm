
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int n = sc.nextInt();
		int cnt = 0;
		for (int t = 0; t < n; t++) {
			int num = sc.nextInt();

			boolean sosu = true;

			if (num > 1) {
				for (int i = 2; i < num; i++) {
					if (num % i == 0) {
						sosu = false;
					}
				}
			} else {
				sosu = false;
			}

			cnt = sosu ? cnt + 1 : cnt;

		}

		System.out.println(cnt);
	}

}
