

import java.util.Scanner;

public class Main {

	static int N;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		N = sc.nextInt();

		for(int i=0; i<N; i++) {
			String str = sc.next();
			
			System.out.println(isPalindrome(str)+" "+cnt);
			cnt=1;
		}
	}

	private static int isPalindrome(String str) {
		// TODO Auto-generated method stub
		return recrusion(str,0,str.length()-1);
	}

	
	static int cnt = 1;
	static int recrusion(String str, int l, int r) {
		if(l>=r) {
			return 1;
		}
		else if(str.charAt(l) != str.charAt(r)) {
			return 0;
		}
		else {
			cnt++;
			return recrusion(str,l+1,r-1);
		}
	}

}
