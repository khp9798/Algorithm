import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		
		int[] score = new int[10];
		for(int i=0; i<10; i++) {
			score[i] = sc.nextInt();
		}
		
		int sum=0;
		int hundred = 0;
		
		for(int i=0; i<10; i++) {
			sum+=score[i];
			if(Math.abs(100-hundred) >= Math.abs(100-sum)) {
				if(hundred<sum) {
					hundred = sum;					
				}
			}
			
		}
		
		System.out.println(hundred);
	}

}
