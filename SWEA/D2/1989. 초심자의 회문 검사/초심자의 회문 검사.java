import java.util.Scanner;

public class Solution {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int T = sc.nextInt();

		for (int t = 1; t <= T; t++) {
			
			String str = sc.next();
			
			String reverse="";
			
			for(int i=str.length()-1; i>=0; i--) {
				reverse+=str.charAt(i);
			}
			
			
			int result=0;
			
			result = str.equals(reverse) ? 1: 0;
			
			System.out.println("#"+t+" "+result);
		}

	}

}
