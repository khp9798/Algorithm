
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Main {

	static int[] arr = new int[10000];
	static int top = -1;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(br.readLine());
		
		for(int i=0; i<N; i++) {
			StringTokenizer st= new StringTokenizer(br.readLine());
			String command = st.nextToken();
			switch (command) {
			case "push":
				int num = Integer.parseInt(st.nextToken());
				push(num);
				break;
			case "pop":
				System.out.println(pop());
				break;
			case "size":
				System.out.println(size());
				break;
			case "empty":
				System.out.println(empty());
				break;
			case "top":
				System.out.println(top());
				break;
			}

		}

	}

	static void push(int num) {
		arr[++top] = num;
	}

	static int pop() {
		if (top == -1) {
			return -1;
		}
		return arr[top--];
	}

	static int size() {
		return top + 1;
	}

	static int empty() {
		if (top == -1) {
			return 1;
		}
		return 0;
	}

	static int top() {
		if (top == -1) {
			return -1;
		}
		return arr[top];
	}

}