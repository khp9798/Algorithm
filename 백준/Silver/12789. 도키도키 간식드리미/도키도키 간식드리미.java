
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		Stack<Integer> stack = new Stack<>();
		
		int N = Integer.parseInt(br.readLine());
		
		int cnt = 1;
		
		boolean res = true;
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i=0; i<N; i++) {
			stack.add(Integer.parseInt(st.nextToken()));
			
			while(!stack.isEmpty()) {
				if(stack.peek()==cnt) {
					stack.pop();
					cnt++;
				}else {
					break;
				}
			}
		}
		
		
		while(!stack.isEmpty()) {
			if(stack.peek()==cnt) {
				stack.pop();
				cnt++;
			}else {
				res = false;
				break;
			}
		}
		
		System.out.println(res? "Nice" : "Sad");
	}

}
