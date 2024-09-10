import java.util.Arrays;
import java.util.Scanner;

class Main {

	static int L;
	static int C;

	static boolean[] select;
	static String[] c;
	static StringBuilder sb = new StringBuilder();

	static String aeiou = "aeiou";

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		L = sc.nextInt();

		C = sc.nextInt();

		c = new String[C];
		select = new boolean[C];

		for (int i = 0; i < C; i++) {
			c[i] = sc.next();
		}

		Arrays.sort(c);

		dfs(0, 0, 0, 0);

		System.out.println(sb.toString());
	}

	private static void dfs(int idx, int depth, int count1, int count2) {
		if (depth == L) {
			if(count1>=1 && count2>=2) {
				for (int i = 0; i < C; i++) {
					if (select[i]) {

						sb.append(c[i]);

					}
				}
				sb.append("\n");
			}
			

			return;
		}

		for (int i = idx; i < C; i++) {
			if (!select[i]) {
				select[i] = true;
				if (aeiou.contains(c[i])) {
					dfs(i, depth + 1, count1 + 1, count2);
				} else {
					dfs(i, depth + 1, count1, count2 + 1);

				}
				select[i] = false;
			}
		}
	}

}