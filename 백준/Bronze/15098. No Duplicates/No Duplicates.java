import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine());

		Map<String, Integer> map = new HashMap<>();
		boolean res = true;
		while (st.hasMoreTokens()) {
			String word = st.nextToken();

			if (map.containsKey(word)) {
				res = false;
				break;
			} else {
				map.put(word, 1);
			}
		}

		System.out.println(res ? "yes" : "no");
	}

}
