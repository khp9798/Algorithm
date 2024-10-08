import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		for(int t=1; t<=10; t++) {
			int N = Integer.parseInt(br.readLine());
			
			
			int [] arr = new int[N];
			
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int i=0; i<N; i++) {
				arr[i]= Integer.parseInt(st.nextToken());
			}
			
			
			int res=0;
			for(int i=2; i<N-2; i++) {
				int left = Math.max(arr[i-2], arr[i-1]);
				int right = Math.max(arr[i+1], arr[i+2]);
				
				int view = arr[i] - Math.max(left, right);
				if(view>0) {
					res+=view;
				}
			}
			
			System.out.println("#"+t+" "+res);
		}

	}

}
