import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int num = sc.nextInt();

		int total = 0;
		
		boolean[][] arr = new boolean[101][101];
		
		for(int i=0; i<num; i++) {
			int x=sc.nextInt();
			int y=sc.nextInt();
			
			for(int j=x; j<x+10; j++ ) {
				for(int k=y; k<y+10; k++) {
					if(!arr[j][k]) {
						arr[j][k] = true;
						total++;
					}
				}
			}
		}
		
		System.out.println(total);

		

	}

}
