

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

	// a부터 z까지 26
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String str = br.readLine();
		
		String reverse = "";
		for(int i=str.length()-1; i>=0; i--) {
			reverse+=str.charAt(i);
		}
		
		if(str.equals(reverse)) {
			System.out.println(1);
		}else {
			System.out.println(0);
		}
	}

}
