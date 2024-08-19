

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {


	static String ABC = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
	static String abc = "abcdefghijklmnopqrstuvwxyz";
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String str = br.readLine();
		
		char[] a = abc.toCharArray();
		char[] A = ABC.toCharArray();
		
		int[] count = new int[abc.length()];
		
		for(int i=0; i<str.length(); i++) {
			char c = str.charAt(i);
			
			for(int j=0; j<a.length; j++) {
				if(c==a[j] || c==A[j]) {
					count[j]++;
				}
			}
		}
		
		
		int max = Integer.MIN_VALUE;
		int idx = 0;
		for(int i=0; i<count.length; i++) {
			if(max<count[i]) {
				max = count[i];
				idx = i;
			}
		}
		
		
		int cnt = 0;
		for(int i=0; i<count.length; i++) {
			if(max==count[i]) {
				cnt++;
			}
		}
		
		if(cnt>1) {
			System.out.println("?");
		}else {
			System.out.println(A[idx]);			
		}
	}

}
