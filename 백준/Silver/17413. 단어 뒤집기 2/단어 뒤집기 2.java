
import java.util.Scanner;
import java.util.Stack;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		String str = sc.nextLine();

		Stack<Character> stack = new Stack<>();
		
		
		String reverse = "";
		for(int i=0; i<str.length(); i++) {
			char c= str.charAt(i);
			
			if(c==' ') {
				while(!stack.isEmpty()) {
					reverse+=stack.pop();
				}
				reverse+=c;
			}
			else {
				if(c=='<') {
					while(!stack.isEmpty()) {
						reverse+=stack.pop();
					}
					int idx = i;
					while((str.charAt(idx)!='>')) {
						idx++;
					}
					for(int j=idx; j>=i; j--) {
						stack.push(str.charAt(j));
					}
					while(!stack.isEmpty()) {
						reverse+=stack.pop();
					}
					i=idx;
				}
				else {
					stack.push(c);					
				}
			}
		}
		
		while(!stack.isEmpty()) {
			reverse+=stack.pop();
		}
		
		System.out.println(reverse);

	}

}
