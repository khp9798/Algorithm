import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

class Main {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(br.readLine());

		Stack<Integer> stack = new Stack<>();
		StringBuilder sb = new StringBuilder();

//		System.out.println(stack.peek());

		int j = 1;
		for (int i = 0; i < N; i++) {
			int num = Integer.parseInt(br.readLine());

			
			while(true) {
				
				if (stack.isEmpty()) {
					stack.add(j++);
					sb.append("+\n");
				} else {
					if (stack.peek() == num) {
						stack.pop();
						sb.append("-\n");
						break;
					}
					else if (stack.peek() < num) {
						stack.add(j++);
						sb.append("+\n");
					}
					else {
						break;
					}
				}
			}
		}

		if (!stack.isEmpty()) {
			System.out.println("NO");
		} else {
			System.out.println(sb);
		}

	}
}