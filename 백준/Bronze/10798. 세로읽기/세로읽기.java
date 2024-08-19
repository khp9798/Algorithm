

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st;

		char[][] c = new char[5][];
		
		int max = Integer.MIN_VALUE;
		for(int r=0; r<c.length; r++) {
			st = new StringTokenizer(br.readLine());
			
			c[r] = st.nextToken().toCharArray();
			
			if(max<c[r].length) {
				max = c[r].length;
			}
		}
		
		
		
		for(int col=0; col<max; col++) {
			for(int r=0; r<5; r++) {
				try {
					System.out.print(c[r][col]);
					
				}catch (ArrayIndexOutOfBoundsException e) {
					continue;
				}
			}
		}
		
	}

}
