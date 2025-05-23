import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		while(true) {
			String str = br.readLine();
			
			if(str.equals("#")) {
				return;
			}
			
			char[] vowels = {'a','e','i','o','u','A','E','I','O','U'};
			int result = 0;
			for(int i=0; i<str.length(); i++) {
				for(int j=0; j<vowels.length; j++) {
					if(str.charAt(i) == vowels[j]) {
						result++;
					}
				}
			}
			
			System.out.println(result);
		}
	}

}
