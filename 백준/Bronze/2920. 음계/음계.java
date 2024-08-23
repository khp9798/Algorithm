

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		
		StringTokenizer st = new StringTokenizer(br.readLine());
		String res = "";
		for(int i=0; i<8; i++) {
			res += st.nextToken();
		}
		
		String a = "12345678";
		
		String d = "87654321";
		
		
		if(res.equals(a)) System.out.println("ascending");
		else if(res.equals(d)) System.out.println("descending");
		else System.out.println("mixed");
		
		
	}

}
