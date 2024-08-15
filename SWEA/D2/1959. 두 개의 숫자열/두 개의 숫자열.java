import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(br.readLine());
		
		StringTokenizer st;
		for(int t=1; t<=T; t++) {
			st = new StringTokenizer(br.readLine());
			
			int N = Integer.parseInt(st.nextToken());
			
			int[] a = new int[N];
			
			int M = Integer.parseInt(st.nextToken());
			
			int[] b = new int[M];
			
			
			st = new StringTokenizer(br.readLine());
			for(int i=0; i<N; i++) {
				a[i] = Integer.parseInt(st.nextToken());
			}
			
			st = new StringTokenizer(br.readLine());
			for(int i=0; i<M; i++) {
				b[i] = Integer.parseInt(st.nextToken());
			}
			
			
			int max = Math.max(N, M);
			int min = Math.min(M, N);
			
			//5-3+1      5-2+1
			int maxsum = Integer.MIN_VALUE;
			
			for(int k=0; k<max-min+1; k++) {
				int sum=0;
				int j=0;
				for(int i=k; i<max; i++) {
					if(a.length==min) {
						if(j==min) {
							break;
						}
						sum+=b[i]*a[j];
						j++;
					}
					else {
						if(j==min) {
							break;
						}
						sum+=a[i]*b[j];
						j++;
					}
					
				}
				if(maxsum<sum) {
					maxsum=sum;
				}
			}
			
			
			
			System.out.println("#"+t+" "+maxsum);
			
		}

	}

}
