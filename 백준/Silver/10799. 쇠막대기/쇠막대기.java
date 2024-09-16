import java.io.*;
import java.util.*;

class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		String str = br.readLine();

		Stack<Character> st = new Stack();

		int count = 0;

		for (int i = 0; i < str.length(); i++) {
			char c = str.charAt(i);

			switch (c) {
			case '(':
				st.add(c);
				break;
			case ')':
				st.pop();
				if (str.charAt(i - 1) == '(') {
					count += st.size();
				} else {
					count++;
				}
				break;

			}
		}
		
		System.out.println(count);
	}
}