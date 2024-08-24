
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		
		Stack<Character> stack = new Stack<>();
		
		
		String str = br.readLine();
		
		
		while(!str.equals(".")) {
			
			boolean res = true;
			for(int i=0; i<str.length(); i++) {
				char c = str.charAt(i);
				
				if(c=='(' || c=='[') {
					stack.add(c);
				}else if(c==')') {
					if( stack.isEmpty() || stack.peek()!='(') {
						res = false;
						break;
					}else {
						stack.pop();
					}
				}else if(c==']') {
					if(stack.isEmpty() || stack.peek()!='[') {
						res = false;
						break;
					}else {
						stack.pop();
					}
				}
			}
			
			if(!stack.isEmpty()) res = false;
			System.out.println(res ? "yes" : "no");
			
			while(!stack.isEmpty()) {
				stack.pop();
			}
			
			str = br.readLine();
		}
		
		

	}

}
