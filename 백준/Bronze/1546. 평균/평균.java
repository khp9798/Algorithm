

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		//과목 갯수
		int N = sc.nextInt();
		
		int [] score = new int[N];
		
		int max = Integer.MIN_VALUE;
		for(int i=0; i<N; i++) {
			score[i] = sc.nextInt();
			if(max<score[i]) max = score[i];
		}
		
		
		double sum = 0;
		for(int i=0; i<N; i++) {
			sum+=(double) score[i]/max*100;
		}

		System.out.println(sum/N);
	}

}
