import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		for(int t=1; t<=10; t++) {
			int testcase = Integer.parseInt(br.readLine());
			
			
			String pattern = br.readLine();
			String str = br.readLine();
			
			
			int cnt=0;
			for(int i=0; i<=str.length()-pattern.length(); i++) {
				String st="";
				for(int j=i; j<i+pattern.length(); j++) {
					st += str.charAt(j);
				}
				
				if(pattern.equals(st)) {
					cnt++;
				}
			}
			
			System.out.println("#"+testcase+" "+cnt);
		}

	}

}
