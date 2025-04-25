import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int n = Integer.parseInt(br.readLine());

		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < n; i++) {

			String s = br.readLine();

			String b = "";

			for (int j = 0; j < s.length(); j++) {
				if (j == 0 && 'a' <= s.charAt(0) && s.charAt(0) <= 'z') {
					b += (char) (s.charAt(j) + 'A' - 'a');
				} else {
					b += s.charAt(j);
				}

			}

			sb.append(b).append("\n");
		}

		System.out.print(sb.toString());

	}

}
