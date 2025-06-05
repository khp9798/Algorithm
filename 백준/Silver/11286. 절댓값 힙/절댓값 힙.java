import java.util.*;

public class Main {

	public static void main(String[] args) {

		PriorityQueue<Integer> pq = new PriorityQueue<>((x, y) -> {

			if (Math.abs(x) < Math.abs(y)) {
				return -1;
			} else if (Math.abs(x) == Math.abs(y)) {
				return x - y;
			} else {
				return 1;
			}
		});

		Scanner sc = new Scanner(System.in);

		int n = sc.nextInt();

		StringBuilder sb = new StringBuilder();

		for (int i = 0; i < n; i++) {
			int num = sc.nextInt();

			if (num != 0) {
				pq.add(num);
			} else {
				if (pq.isEmpty()) {
					sb.append(0).append("\n");
				} else {
					sb.append(pq.poll() + "\n");
				}

			}
		}

		System.out.println(sb.toString());
	}

}
