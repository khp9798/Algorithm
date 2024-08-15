import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(br.readLine());
		
		for(int t=1; t<=T; t++) {
			String str = br.readLine();
			
			int cnt=0;
			for(int i=0; i<str.length(); i++) {
				char c = str.charAt(i);
				
				if(c=='(' && str.charAt(i+1)==')') {
					cnt++;
				}else if(c=='(' && str.charAt(i+1)!=')') {
					cnt++;
				}else if(c==')' && str.charAt(i-1)!='(') {
					cnt++;
				}
			}
			
			System.out.println("#"+t+" "+cnt);
		}

	}

}
