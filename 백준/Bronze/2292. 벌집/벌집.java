import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);

		int N = sc.nextInt();
		
		
		int count=1;
		
		int rangemin = 2;
		
		if(N==1) {
			System.out.println(count);
		}
		else {
			while(rangemin<=N) {
				rangemin = rangemin + (6 * count);
				count++;
			}
			System.out.println(count);
			
		}
		
		
	}

}
