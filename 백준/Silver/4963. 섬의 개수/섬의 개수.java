
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	static int[][] map;
	static boolean[][] visited;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st;
		while (true) {
			st = new StringTokenizer(br.readLine());

			int w = Integer.parseInt(st.nextToken());

			int h = Integer.parseInt(st.nextToken());

			if (w == 0 && h == 0) {
				break;
			}

			map = new int[h][w];
			visited = new boolean[h][w];

			for (int r = 0; r < h; r++) {
				st = new StringTokenizer(br.readLine());
				for (int c = 0; c < w; c++) {

					map[r][c] = Integer.parseInt(st.nextToken());

				}
			}
			
			
			int cnt=0;
			for(int r=0; r<h; r++) {
				for(int c=0; c<w; c++) {
					if(map[r][c]==1 && !visited[r][c]) {
						dfs(r,c);
						cnt++;
					}
				}
			}
			
			
			System.out.println(cnt);
			
			
		}

	}

	
	static int [] dr = {-1,1,0,0,-1,-1,1,1};
	static int [] dc = {0,0,-1,1,-1,1,-1,1};
	
	static void dfs(int r, int c) {
		visited[r][c] = true;
		
		for(int d=0; d<8; d++) {
			int nr = r+dr[d];
			int nc = c+dc[d];
			
			if(0<=nr && nr<map.length && 0<=nc && nc<map[0].length
					&& !visited[nr][nc] && map[nr][nc] == 1) {
				dfs(nr,nc);
			}
		}
		
	}

}
