import java.util.Arrays;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		//사람 수
		int N = sc.nextInt();
		
		//사람마다 걸리는 시간 배열
		int[] p = new int[N];
		
		for(int i=0; i<N; i++) {
			p[i] = sc.nextInt();
		}
		
		Arrays.sort(p);
		

		int[] prefixsum = new int[N];
		prefixsum[0] = p[0];
		
		
		int sum=prefixsum[0];
		for(int i=1; i<N; i++) {
			prefixsum[i] = prefixsum[i-1] + p[i];
			sum+=prefixsum[i];
		}


		
		System.out.println(sum);
	}

}
