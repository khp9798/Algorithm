
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {

	static int K;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int T = sc.nextInt();

		for (int t = 1; t <= T; t++) {
			// 옷의 개수
			K = sc.nextInt();
			Map<String, Integer> map = new HashMap<>();
			for (int i = 0; i < K; i++) {
				sc.next();

				String kind = sc.next();
				if (map.containsKey(kind)) {
					map.put(kind, map.get(kind) + 1);
				} else {
					map.put(kind, 1);
				}
			}

			int result = 1;
			for (int value : map.values()) {
				result *= (value + 1);
			}

			
			System.out.println(result-1);
		}

	}

}
