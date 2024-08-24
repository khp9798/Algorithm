

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {

	public static void main(String[] args) throws NumberFormatException, IOException {
		Stack<Character> stack = new Stack<>();

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int T = Integer.parseInt(br.readLine());

		for (int t = 0; t < T; t++) {
			String str = br.readLine();
			String res = "";

			for (int i = 0; i < str.length(); i++) {
				char c = str.charAt(i);

				switch (c) {
				case '(': {
					stack.add(c);
					break;
				}
				case ')': {
					if (stack.isEmpty()) {
						res = "NO";
					} else if (!stack.isEmpty() && stack.peek() == '(') {
						stack.pop();
					} else {
						res = "NO";
					}
					break;
				}
				}

				

			}
			
			if (!stack.isEmpty()) {
				while (!stack.isEmpty()) {
					stack.pop();
				}
				res = "NO";
			} else if(res.equals("")){
				res = "YES";
			}
			
			System.out.println(res);

		}

	}

}
