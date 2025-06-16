import java.util.*;

public class Main {

	// 1~n-1번 원판들을 1->2로 옮긴다.
	// n번 원판을 1 -> 3으로 옮긴다
	// 1~n-1번 원판들을 2->3으로 옮긴다.

	// 원판 1개를 옮길 수 있다.
	// 원판 n개를 옮기면 n+1개 또한 옮길 수 있다.

	static StringBuilder sb = new StringBuilder();
	static int count=0;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int n = sc.nextInt();

		move(1, 3, n);
		System.out.println(count);
		System.out.println(sb.toString());
	}

	static void move(int start, int end, int n) {
		if (n == 0)
			return;

		count++;
		move(start,6-start-end,n-1);
		sb.append(start + " " + end + "\n");
		move(6 - start - end, end, n - 1);
	}
}
