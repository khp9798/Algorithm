import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

class Main {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int T = Integer.parseInt(br.readLine());

		Stack<Character> stack = new Stack<>();
		StringBuilder sb = new StringBuilder();
		
		for (int t = 0; t < T; t++) {
			String str = br.readLine()+" ";

			for (int i = 0; i < str.length(); i++) {
				char c = str.charAt(i);
				if (c == ' ') {
					while (!stack.isEmpty()) {
//						System.out.print(stack.pop());
						sb.append(stack.pop());
					}
//					System.out.print(" ");
					sb.append(" ");
				} else {
					stack.push(c);
				}

			}
			System.out.println(sb);
			sb.setLength(0);
		}
	}
}