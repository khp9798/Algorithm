import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution {

	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		
		
		String answer = "";
		for(int i=1; i<=N; i++) {
			answer+=i+" ";
		}

		answer = answer.replace('3', '-');
		answer = answer.replace('6','-');
		answer = answer.replace('9','-');
		
		
		String answer2 = "";
		
		for(int i=0; i<answer.length(); i++) {
			char c = answer.charAt(i);
			if(c!=' ' && c!='-'&& answer.charAt(i+1) == '-') {
				continue;
			}
			else if(i>0 && '0'<=c && c<='9' && answer.charAt(i-1)=='-') {
				continue;
			}
			else {
				answer2+=c;
			}
		}
		System.out.println(answer2);
		
	}

}
