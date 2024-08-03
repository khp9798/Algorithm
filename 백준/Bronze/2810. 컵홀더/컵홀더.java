import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int N = sc.nextInt();

		String str1 = sc.next();

		String seat = "*";
		seat += str1;

		StringBuffer seat1 = new StringBuffer(seat);

		int cnt = 0;

		for (int i = 0; i < seat1.length(); i++) {
			if (seat1.charAt(i) == 'S') {
				seat1.insert(i + 1, '*');

			}
			if (seat1.charAt(i) == 'L') {
				if (seat1.charAt(i + 1) == 'L') {
					seat1.insert(i + 2, '*');

				}
			}
		}

		for (int i = 0; i < seat1.length(); i++) {
			if (seat1.charAt(i) != '*') {
				if (seat1.charAt(i - 1) == '*') {

					cnt++;
				} else if (seat1.charAt(i + 1) == '*') {
					seat1.deleteCharAt(i + 1);
					cnt++;
				}

			}
		}

		System.out.println(cnt);

	}
}
