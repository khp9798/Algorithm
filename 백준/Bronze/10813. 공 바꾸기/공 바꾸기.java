import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br=  new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		
		int [] balls = new int[N+1];
		
		for(int i=1; i<N+1; i++) {
			balls[i] = i;
		}
		
		int M = Integer.parseInt(st.nextToken());
		
		
		for(int k=0; k<M; k++) {
			st = new StringTokenizer(br.readLine());
			
			int i = Integer.parseInt(st.nextToken());
			
			
			int j = Integer.parseInt(st.nextToken());
			
			
			int tmp= balls[i];
			balls[i] = balls[j];
			balls[j] = tmp;
		}
		
		for(int i=1; i<N+1; i++) {
			System.out.print(balls[i]+" ");
		}

	}

}
