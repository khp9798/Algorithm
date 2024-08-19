

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	// a부터 z까지 26
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(br.readLine());

		StringTokenizer st;

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());

			int n = Integer.parseInt(st.nextToken());

			String str = st.nextToken();

			String answer = "";

			for (int j = 0; j < str.length(); j++) {
				for(int k=0; k<n; k++) {
					answer+=str.charAt(j);
				}
			}
			
			System.out.println(answer);
		}

	}

}
