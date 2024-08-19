

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine());

		String a = st.nextToken();
		
		String b = st.nextToken();
		
		
		String str1="";
		String str2="";
		for(int i=a.length()-1; i>=0; i--) {
			str1+=a.charAt(i);
		}
		for(int i=b.length()-1; i>=0; i--) {
			str2+=b.charAt(i);
		}
		
		
		int q = Integer.parseInt(str1);
		int q2 = Integer.parseInt(str2);
		
		System.out.println(Math.max(q, q2));
	}

}
