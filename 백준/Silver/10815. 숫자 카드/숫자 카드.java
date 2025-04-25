import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int n = Integer.parseInt(br.readLine());

		Map<Integer, Integer> count = new HashMap<>();

		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < n; i++) {
			count.put(Integer.parseInt(st.nextToken()), 0);
		}

		int m = Integer.parseInt(br.readLine());

		st = new StringTokenizer(br.readLine());

		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < m; i++) {
			if (count.containsKey(Integer.parseInt(st.nextToken())))
				sb.append("1").append(" ");
			else
				sb.append("0").append(" ");
		}

		System.out.println(sb.toString());
	}

}
