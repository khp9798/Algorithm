import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String str = br.readLine();
		
		
		int N = str.length();
		int R = 0;
		int C = 0;
		
		for(int i=1; i<=N; i++) {
			if(N%i==0 && i<=N/i) {
				R = i;
				C = N/R;	
			}
			
		}
		
		char[][] message = new char[C][R];
		
		int idx=0;
		
		for(int i=0; i<message.length; i++) {
			for (int j=0; j<message[i].length; j++) {
				message[i][j] = str.charAt(idx++);
			}
		}
		
		String answer = "";
		for(int c = 0; c<message[0].length; c++) {
			for(int r = 0; r<message.length; r++) {
				answer+=message[r][c];
			}
		}
		
		System.out.println(answer);
	}

}
