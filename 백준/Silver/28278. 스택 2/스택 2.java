import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	static int[] stack = new int[1000000];

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		// 연산 개수
		int N = Integer.parseInt(br.readLine());

		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());

			int command = Integer.parseInt(st.nextToken());

			switch (command) {
			case 1: {
				int num = Integer.parseInt(st.nextToken());
				push(num);
				break;
			}
			case 2: {
				System.out.println(pop());
				break;
			}
			case 3: {
				System.out.println(size());
				break;
			}
			case 4: {
				System.out.println(isEmpty());
				break;
			}
			case 5: {
				System.out.println(peek());
				break;
			}
			}
		}

	}

	static int top = 0;

	static void push(int num) {
		stack[++top] = num;
	}

	static int pop() {
		if(top==0) {
			return -1;
		}
		int popItem = stack[top--];

		return popItem;
	}

	static int size() {
		
			return top;
		
	}

	static int isEmpty() {
		if (size() == 0) {
			return 1;
		} else {
			return 0;
		}
	}

	static int peek() {
		if(top==0) {
			return -1;
		}
		return stack[top];
	}

}
