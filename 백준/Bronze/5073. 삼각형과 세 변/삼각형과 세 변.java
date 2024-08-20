import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


public class Main {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		
		while(true) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			
			int max = Math.max(c, Math.max(a, b));
			
			if(a==b && b==c) {
				if(a==0) break;
				System.out.println("Equilateral");
			}
			
			else if(a==max && b+c<=a) {
				System.out.println("Invalid");
			}
			else if(b==max && a+c<=b) {
				System.out.println("Invalid");
			}
			else if(c==max && b+a<=c) {
				System.out.println("Invalid");
			}
			
			
			else if(a==b || b==c || a==c) {
				System.out.println("Isosceles");
			}
			else {
				System.out.println("Scalene");
			}
		}
		
		
		
	}

}
