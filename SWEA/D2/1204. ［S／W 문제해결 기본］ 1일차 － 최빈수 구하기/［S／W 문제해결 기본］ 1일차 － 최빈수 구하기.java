import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(br.readLine());
		for(int t=1; t<=T; t++) {
			int testcase = Integer.parseInt(br.readLine());
			
			
			int [] count = new int[101];
			
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int i=0; i<1000; i++) {
				count[Integer.parseInt(st.nextToken())]++ ;
			}
			
			
			int maxcount = Integer.MIN_VALUE;
			int res =0;
			for(int i=99; i>=0; i--) {
				if(maxcount<count[i]) {
					maxcount = count[i];
					res=i;
				}
				
			}
			
			System.out.println("#"+testcase+" "+res);
		}

	}

}
