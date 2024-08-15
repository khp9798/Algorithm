import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {

	
	static int [] dr = {-1,1,0,0,0};
	static int [] dc = {0,0,0,-1,1};
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br=  new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(br.readLine());
		
		StringTokenizer st;
		for(int t=1; t<=T; t++) {
			st = new StringTokenizer(br.readLine());
			
			//행의 갯수
			int N = Integer.parseInt(st.nextToken());
			
			//열의 갯수
			int M = Integer.parseInt(st.nextToken());
			
			
			int[][] map = new int[N][M];
			
			for(int r=0; r<N; r++) {
				st = new StringTokenizer(br.readLine());
				for(int c=0; c<M; c++) {
					map[r][c] = Integer.parseInt(st.nextToken());
				}
			}
			
			
			int max = Integer.MIN_VALUE;
			
			for(int r=0; r<N; r++) {
				for(int c=0; c<M; c++) {
					int balloncnt = 0;
					for(int d=0; d<5; d++) {
						int nr = r+dr[d];
						int nc = c+dc[d];
						
						if(0<=nr && nr<N && 0<=nc && nc<M) {
							balloncnt+=map[nr][nc];
						}
					}
					
					if(max<balloncnt) {
						max = balloncnt;
					}
				}
			}
			
			System.out.println("#"+t+" "+max);
			
		}

	}

}
