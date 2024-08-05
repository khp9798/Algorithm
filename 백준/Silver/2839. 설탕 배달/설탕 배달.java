import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		
		int cnt=Integer.MAX_VALUE;
		for(int i=0; i<=N/3; i++) {
			for(int j=0; j<=N/5; j++) {
				if(3*i+5*j == N) {
					int sum=i+j;
					if(cnt>sum)
						cnt=sum;
					
				}
			}
		}
		if(cnt==Integer.MAX_VALUE)
			cnt=-1;
		
		System.out.println(cnt);

	}

}
