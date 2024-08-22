

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	
	static boolean [][] visited;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(br.readLine());
		
		for(int t=1; t<=T; t++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			//행
			int N = Integer.parseInt(st.nextToken());
			
			//열
			int M = Integer.parseInt(st.nextToken());
			
			//배추의 개수
			int K = Integer.parseInt(st.nextToken());
			
			
			int [][] map = new int [N][M];
			visited = new boolean[N][M];
			
			for(int i=0; i<K; i++) {
				st = new StringTokenizer(br.readLine());
				
				int r = Integer.parseInt(st.nextToken());
				int c = Integer.parseInt(st.nextToken());
				
				map[r][c] = 1;
			}
			
			
			for(int r=0; r<N; r++) {
				for(int c=0; c<M; c++) {
					if(map[r][c]==1 && !visited[r][c]) {
						map[r][c] = cnt;
						visited[r][c] = true;
						dfs(r,c,map);
						cnt++;
					}
				}
			}
			
			
			System.out.println(cnt-1);
			
			cnt=1;
		}

	}
	
	static int cnt = 1;
	
	static int [] dr = {-1,1,0,0};
	static int [] dc = {0,0,-1,1};
	
	
	static void dfs (int r, int c, int [][] map) {
		for(int d=0; d<4; d++) {
			int nr = r+dr[d];
			int nc = c+dc[d];
			
			if(0<=nr && nr<map.length && 0<=nc && nc<map[0].length && !visited[nr][nc] && map[nr][nc]==1) {
				map[nr][nc] = cnt;
				visited[nr][nc] = true;
				dfs(nr,nc,map);
			}
		}
	}

}
