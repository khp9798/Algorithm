

import java.util.Scanner;

public class Solution {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		for (int i = 0; i < 10; i++) {
			int testcase = sc.nextInt();
			
			
			int N = sc.nextInt();
			
			int M = sc.nextInt();
			
			
			System.out.println("#"+testcase+" "+pow(N,M));
		}
	}

	static long pow(int n, int m) {
		if(m==0) {
			return 1;
		}
		else if(m==1) {
			return n;
		}
		else {
			if(m%2==0) {
				long tmp = pow(n,m/2);
				return tmp*tmp;
			}else {
				long tmp = pow(n,(m-1)/2);
				return tmp*tmp*n;
			}
		}
		
		
	}
}
