import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int T = Integer.parseInt(br.readLine());
		for (int t = 1; t <= T; t++) {

			

			StringTokenizer st = new StringTokenizer(br.readLine());

			int N = Integer.parseInt(st.nextToken());
			int M = Integer.parseInt(st.nextToken());
			
			int [] count = new int [N+M+1];

			for(int i=1; i<=N; i++) {
				for(int j=1; j<=M; j++) {
					count[i+j]++;
				}
			}
			
			System.out.print("#" + t );
			int maxcount = Integer.MIN_VALUE;
			for(int i=1; i<count.length; i++) {
				if(maxcount<count[i]) {
					maxcount=count[i];
					
				}
			}
			
			for(int i=1; i<count.length; i++) {
				if(maxcount==count[i]) {
					System.out.print(" "+i);
				}
			}
			System.out.println();
			
		}

	}

}
