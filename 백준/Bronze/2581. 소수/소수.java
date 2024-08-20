
import java.util.Scanner;

public class Main {

	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int m = sc.nextInt();
		int n = sc.nextInt();

		int sum=0;
		
		int min = Integer.MAX_VALUE;
		for(int i=m; i<=n; i++) {
			boolean isprime = true;
			if(i==1) {
				isprime = false;
			}
			else {
				for(int j=2; j<i; j++) {
					if(i%j==0) {
						isprime=false;
					}
				}
				
				if(isprime) {
					sum+=i;
					if(min>i) min=i;
				}
			}
		}
		
		System.out.println(sum = sum==0? -1 : sum);
		if(sum!=-1) {
			System.out.println(min);
		}
	}
	
	

}
