import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Solution {

	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(br.readLine());
		
		for(int t=1; t<=T; t++) {
			String info = br.readLine();
			
			//누적합 배열 만들기
			int[] count = new int[info.length()];
			
			count[0] = info.charAt(0) - '0';
			for(int i=1; i<count.length; i++) {
				count[i] = count[i-1]+info.charAt(i)-'0';
			}
			
//			System.out.println(Arrays.toString(count));
			
			int cnt=0;
			for(int i=1; i<count.length; i++) {
				if(count[i-1]+cnt<i) {
					cnt++;
				}
			}
			System.out.println("#"+t+" "+cnt);
		}
	}

}
