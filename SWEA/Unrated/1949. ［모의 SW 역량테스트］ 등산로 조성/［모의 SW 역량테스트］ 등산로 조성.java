

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {

	static int N;
	static int K;
	
	static int [][] map;
	static boolean [][] visited;
	
	static int [] dr = {-1,1,0,0};
	static int [] dc = {0,0,-1,1};
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(br.readLine());
		
		for(int t=1; t<=T; t++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			
			//배열 크기
			N = Integer.parseInt(st.nextToken());
			
			map = new int[N][N];
			visited = new boolean[N][N];
			
			
			//깎을 수 있는 최대 높이
			K = Integer.parseInt(st.nextToken());
			
			
			int max = Integer.MIN_VALUE;
			for(int r=0; r<N; r++) {
				st = new StringTokenizer(br.readLine());
				for(int c=0; c<N; c++) {
					map[r][c] = Integer.parseInt(st.nextToken());
					if (max<map[r][c]) {
						max = map[r][c];
					}
				}
			}
			
			
			for(int r=0; r<N; r++) {
				for(int c=0; c<N; c++) {
					if (map[r][c] == max) {
						visited[r][c] = true;
						dfs(r,c,1,0);
						visited[r][c] = false;
					}
				}
			}
			
			
			System.out.println("#"+t+" "+result);
			result=0;
		}
		
		
	}

	
	static int result = Integer.MIN_VALUE;
	private static void dfs(int r, int c,int cnt,int concnt) {
		
		
		
		for(int d=0; d<4; d++) {
			int nr = r+dr[d];
			int nc = c+dc[d];
			
			if(0<=nr && nr<N && 0<=nc && nc<N
					&&!visited[nr][nc]) {
				if(map[r][c] > map[nr][nc]) {
					visited[nr][nc] = true;
					dfs(nr,nc,cnt+1,concnt);	
					visited[nr][nc] = false;
				}
				else if(concnt<1) {
					for(int i=1; i<=K; i++) {
						if(map[r][c] > map[nr][nc] - i) {
							map[nr][nc] -= i;
							dfs(nr,nc,cnt+1,concnt+1);
							map[nr][nc] += i;
						}
					}
					
				}
				
			}
		}
		
		
		if(result<cnt) {
			result = cnt;
			
		}
		
	}

}
