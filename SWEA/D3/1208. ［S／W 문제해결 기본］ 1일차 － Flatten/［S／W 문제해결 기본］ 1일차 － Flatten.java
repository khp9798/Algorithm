import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Solution {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		for(int t=1; t<=10; t++) {
			int [] arr = new int[100];
			
			int dumpcnt = Integer.parseInt(br.readLine());
			
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int i=0; i<100; i++) {
				arr[i]= Integer.parseInt(st.nextToken());
			}
			Arrays.sort(arr);
			
			int res = 0;
			while(dumpcnt!=0) {
				
				
				arr[99]--;
				arr[0]++;
				
				Arrays.sort(arr);
				res  = arr[99] - arr[0];
				if(res<=1) break;
				dumpcnt--;
			}
			
			System.out.println("#"+t+" "+res);
		}

	}

}
