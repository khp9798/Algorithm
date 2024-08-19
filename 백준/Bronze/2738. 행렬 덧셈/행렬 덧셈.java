

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		
		int M = Integer.parseInt(st.nextToken());
		
		
		int[][] a = new int[N][M];
		
		int[][] b = new int[N][M];
		
		
		int[][] sum = new int[N][M];
		
		
		for(int r=0; r<N; r++) {
			st = new StringTokenizer(br.readLine());
			for(int c=0; c<M; c++) {
				a[r][c] = Integer.parseInt(st.nextToken());
			}
		}
		
		for(int r=0; r<N; r++) {
			st = new StringTokenizer(br.readLine());
			for(int c=0; c<M; c++) {
				b[r][c] = Integer.parseInt(st.nextToken());
			}
		}
		
		
		for(int r=0; r<N; r++) {
			for(int c=0; c<M; c++) {
				sum[r][c] = a[r][c] + b[r][c];
				
				System.out.print(sum[r][c]+" ");
			}
			System.out.println();
		}
	}

}
