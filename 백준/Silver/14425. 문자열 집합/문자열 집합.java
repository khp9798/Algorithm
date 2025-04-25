import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine());

		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());

		Map<String, Integer> wordCount = new HashMap<>();

		for (int i = 0; i < n; i++) {
			wordCount.put(br.readLine(), 0);
		}

		int res = 0;
		for (int i = 0; i < m; i++) {
			String key = br.readLine();
			if (wordCount.containsKey(key)) {
				res++;
			}
		}

		System.out.println(res);
	}

}
