

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int a = Integer.parseInt(br.readLine());
		int b = Integer.parseInt(br.readLine());
		int c = Integer.parseInt(br.readLine());

		int res = a*b*c;
		
		String str = res+"";
		
		
		
		int [] count = new int[10];
		
		for(int i=0; i<str.length(); i++) {
			int num = str.charAt(i)-'0';
			
			count[num]++;
		}
		
		
		for (int i : count) {
			System.out.println(i);
		}
		
	}

}
