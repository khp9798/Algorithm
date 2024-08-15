import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Solution {

	
	static String a = "CEFGHIJKLMNSTUVWXYZ";
	static String b = "ADOPQR";
	static String c = "B";
	
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(br.readLine());
		
		
		for(int t=1; t<=T; t++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			
			String str1 = st.nextToken();
			String str2 = st.nextToken();
			
			int[] str1hole = new int[str1.length()];
			int[] str2hole = new int[str2.length()];
			
			for(int i=0; i<str1.length(); i++) {
				if(b.contains(str1.charAt(i)+"")) {
					str1hole[i]++;
				}
				else if(c.contains(str1.charAt(i)+"")) {
					str1hole[i]+=2;
				}
			}
			
			
			for(int i=0; i<str2.length(); i++) {
				if(b.contains(str2.charAt(i)+"")) {
					str2hole[i]++;
				}
				else if(c.contains(str2.charAt(i)+"")) {
					str2hole[i]+=2;
				}
			}
			
			
			if(Arrays.equals(str1hole, str2hole)) {
				System.out.println("#"+t+" "+"SAME");
			}
			else {
				System.out.println("#"+t+" "+"DIFF");
			}
			
		}

	}

}
