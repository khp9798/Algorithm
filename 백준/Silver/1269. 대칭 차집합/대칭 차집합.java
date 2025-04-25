import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine());

		int a = Integer.parseInt(st.nextToken());

		int b = Integer.parseInt(st.nextToken());

		Map<Integer, Integer> A = new HashMap<>();
		Map<Integer, Integer> B = new HashMap<>();

		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < a; i++) {
			A.put(Integer.parseInt(st.nextToken()), 0);
		}

		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < b; i++) {
			B.put(Integer.parseInt(st.nextToken()), 0);
		}

		int res = A.size() + B.size();

		for (Map.Entry<Integer, Integer> entry : A.entrySet()) {
			if (B.containsKey(entry.getKey())) {
				res -= 2;
			}
		}

		System.out.println(res);
	}

}
