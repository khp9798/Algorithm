import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {

	//한 변의 길이
	static int N;
	
	//치즈 정보
	static int [][] cheese;
	
	//방문 체크 배열
	static boolean [][] visited;
	
	
	//day
	static int day;
	
	
	//res
	static int res;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(br.readLine());
		
		for(int t=1; t<=T; t++) {
			N = Integer.parseInt(br.readLine());
			
			cheese = new int[N][N];
			
			for(int r=0; r<N; r++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				for(int c=0; c<N; c++) {
					cheese[r][c] = Integer.parseInt(st.nextToken());
				}
			}
			
			res = Integer.MIN_VALUE;
			day=0;
			while(true) {
				int count = 0;
				visited = new boolean[N][N];
				for(int r=0; r<N; r++) {
					for(int c=0; c<N; c++) {
						if(cheese[r][c]>day && !visited[r][c]) {
							dfs(r,c);
							count++;							
						}
					}
				}
				
				if(count==0) break;
				
				res = Math.max(res, count);
				
				day++;
			}
			
			
			System.out.println("#"+t+" "+res);
		}

	}

	
	static int [] dr = {-1,1,0,0};
	static int [] dc = {0,0,-1,1};
	
	private static void dfs(int r, int c) {
		visited[r][c] = true;
		
		for(int d=0; d<4; d++) {
			int nr = r+dr[d];
			int nc = c+dc[d];
			
			if(nr<0 || nc<0 || nr>=N || nc>=N) continue;
			
			if(cheese[nr][nc]<=day) continue;
			
			if(visited[nr][nc]) continue;
			
			dfs(nr,nc);
		}
	}

}
