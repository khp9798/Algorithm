import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {

	
	static boolean [] prime;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(br.readLine());
		
		for(int t=1; t<=T; t++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			
			String d = st.nextToken();
			
			int a = Integer.parseInt(st.nextToken());
			
			int b = Integer.parseInt(st.nextToken());
			
			
			isprime(b);
			
			int cnt=0;
			for(int i=a; i<=b; i++) {
				//소수라는 뜻
				if(prime[i]==false) {
					String sosu = i+"";
					if(sosu.contains(d)) {
						cnt++;
					}
				}
			}
			
			System.out.println("#"+t+" "+cnt);
		}

	}
	
	static void isprime(int b) {
		
		prime = new boolean[b+1];
		
		if(b<2) {
			return;
		}
		
		prime[0] = prime[1] = true;
		
		for(int k=2; k<=Math.sqrt(b); k++) {
			
			if(prime[k]==true) {
				continue;
			}
			for(int i=k*k; i<=b; i=i+k) {
				prime[i] = true;
			}
			
		}
	}

}
