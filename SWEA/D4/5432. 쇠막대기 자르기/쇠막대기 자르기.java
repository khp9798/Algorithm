import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Solution {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		

		int T = Integer.parseInt(br.readLine());
		for (int t = 1; t <= T; t++) {

			Stack<Character> stack = new Stack<>();
			
			int cnt= 0;
			
			char [] str = br.readLine().toCharArray();
			
			for(int i=0; i<str.length; i++) {
				if(str[i]=='(') {
					stack.add(str[i]);
				}
				else {
					if(str[i-1]==')') {
						stack.pop();
						cnt++;
					}else {
						stack.pop();
						cnt+=stack.size();
					}
					
				}
			}
			
			
			System.out.println("#"+t+" "+cnt);
			
		}

	}

}
