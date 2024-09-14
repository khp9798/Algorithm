import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Main {

	static int N;
	static int[] arr = new int[10000];

	static int front = -1;
	static int back = -1;

	static void push(int num) {
		arr[++back] = num;
		if(front==-1) {
			front=0;
		}
	}
	
	
	static int pop() {
		if(size()==0) {
			return -1;
		}
		return arr[front++];
	}
	
	static int size() {
		if(back-front+1<0 || front==-1) {
			return 0;
		}
		return back-front+1;
	}

	static int empty() {
		if(size()==0) {
			return 1;
		}
		return 0;
	}
	
	
	static int front() {
		if(size()==0) {
			return -1;
		}
		
		return arr[front];
	}
	
	static int back() {
		if(size()==0) {
			return -1;
		}
		
		return arr[back];
	}
	
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		N = Integer.parseInt(br.readLine());

		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
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
			case "front":
				System.out.println(front());
				break;
			case "back":
				System.out.println(back());
				break;
			}
		}
	}

}