import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int n = Integer.parseInt(br.readLine());

		String a = "666";
		int cnt = 0;
		int d = 666;
		while (cnt != n) {

			String str = d + "";

			if (str.contains(a)) {
				cnt++;
			}

			d++;

		}

		System.out.println(d-1);
	}

}
