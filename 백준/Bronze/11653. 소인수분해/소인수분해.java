

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class Main {

	
	static boolean [] prime;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(br.readLine());
		
		prime = new boolean[n+1];
		prime();
//		System.out.println(Arrays.toString(prime));
		
		for(int i=2; i<prime.length; i++) {
			if(!prime[i] && n%i==0) {
				while(n%i==0) {
					System.out.println(i);
					n/=i;
				}
			}
		}
	}
	
	static void prime() {
		prime[0] = true;
		prime[1] = true;
		
		for(int i=2; i<Math.sqrt(prime.length-1); i++) {
			for(int j=i*i; j<=prime.length-1; j+=i) {
				prime[j] = true;
			}
		}
	}

}
