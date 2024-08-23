
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int T = Integer.parseInt(br.readLine());
		
		for(int i=0; i<T; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			
			int H = Integer.parseInt(st.nextToken());
			
			int W = Integer.parseInt(st.nextToken());
			
			int N = Integer.parseInt(st.nextToken());
			
			
			System.out.print(N%H==0 ?H:N%H);
			System.out.printf("%02d\n",N%H == 0 ? N/H : N/H+1);
		}
		
		
		
		
		
		
		
	}

}
