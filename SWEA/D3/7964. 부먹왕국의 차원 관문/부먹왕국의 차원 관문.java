
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(br.readLine());
		
		StringTokenizer st;
		for(int t=1; t<=T; t++) {
			st = new StringTokenizer(br.readLine());
			//도시 개수
			int N = Integer.parseInt(st.nextToken());
			
			//거리 제한
			int D = Integer.parseInt(st.nextToken());
			
			int cnt=0;
			int breakb = 0;
			
			st = new StringTokenizer(br.readLine());
			for(int i=0; i<N; i++) {
				int city = Integer.parseInt(st.nextToken());
				
				if(city==1) {
					breakb=0;
				}else {
					breakb++;
					if(breakb==D) {
						cnt++;
						breakb=0;
					}
				}
				
			}
			System.out.println("#"+t+" "+cnt);
			
		}

	}

}
