import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		
		int K = sc.nextInt();
		
		int a = 1;
		for(int i=0; i<K; i++) {
			a*=N-i;
		}
		
		int b = 1;
		for(int j=1; j<=K; j++) {
			b*=j;
		}
		
		System.out.println(a/b);

	}

}
