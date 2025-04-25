import java.io.*;

public class Main {

	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String s = br.readLine();
		
		int [] count = new int[26];
		
		
		for(int i=0; i<s.length(); i++) {
			count[s.charAt(i)-'a']++;
		}
		
		
		for(int num: count) {
			System.out.print(num+" ");
		}
	}

}
