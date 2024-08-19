import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		//바구니 갯수
		int N = Integer.parseInt(st.nextToken());
		
		
		//1번 인덱스는 버림
		int [] balls = new int[N+1];
		
		//공을 넣는 방법 갯수
		int M = Integer.parseInt(st.nextToken());
		
		
		for(int m=0; m<M; m++) {
			st = new StringTokenizer(br.readLine());
			
			int i = Integer.parseInt(st.nextToken());
			
			
			int j = Integer.parseInt(st.nextToken());
			
			int num = Integer.parseInt(st.nextToken());
			
			
			for(int k=i; k<=j; k++) {
				balls[k] = num;
			}
		}
		
		
		for(int i=1; i<N+1; i++) {
			System.out.print(balls[i]+" ");
		}
		

	}

}
