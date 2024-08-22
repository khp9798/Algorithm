import java.util.Scanner;

public class Solution {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int T = sc.nextInt();

		for (int t = 1; t <= T; t++) {
			int max = Integer.MIN_VALUE;
			for(int i=0; i<10; i++) {
				int num = sc.nextInt();
				max = Math.max(num, max);
			}
			
			System.out.println("#"+t+" "+max);
		}

	}

}
