import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int T = sc.nextInt();
		
		
		for(int t=0; t<T; t++) {
			int num = sc.nextInt();
			int [] coin = new int[4];
			
			int quarter = 25;
			int dime = 10;
			int nickel = 5;
			int penny = 1;
			
			coin[0] = num/quarter;
			num-=coin[0]*quarter;
			
			coin[1] = num/dime;
			num-=coin[1]*dime;
			
			coin[2] = num/nickel;
			num-=coin[2]*nickel;
			
			coin[3] = num/penny;
			
			
			for (int i : coin) {
				System.out.print(i+" ");
			}
			System.out.println();
		}

	}

}
