import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine(), ",");
		
		int count = 0;
		while(st.hasMoreTokens()) {
			st.nextToken();
			count++;
		}
		
		System.out.println(count);

	}

}
