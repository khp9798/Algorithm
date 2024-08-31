
import java.util.Scanner;

public class Main {

	static int N;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		N = sc.nextInt();
		
		facto(1);
		
		System.out.println(res);
	}

	
	static long res = 1;
	static void facto(int i) {
		if(i>N) {
			return;
		}
		
		res*=i;
		facto(i+1);
		
	}

	
}
