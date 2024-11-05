
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Solution{

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int tc = Integer.parseInt(br.readLine());
		
		for(int t=1; t<=tc; t++) {
			System.out.print("#"+t+" ");
			
			StringTokenizer st = new StringTokenizer(br.readLine());
			int n = Integer.parseInt(st.nextToken());
			int m = Integer.parseInt(st.nextToken());
			
			
			boolean check = true;
			
			for(int i=0; i<n; i++) {
				
				if((m & (1<<i)) == 0) {
					check = false;
					break;
				}
			}
			
			if(check) {
				System.out.println("ON");
			}else {
				System.out.println("OFF");
			}
		}
	}

}
