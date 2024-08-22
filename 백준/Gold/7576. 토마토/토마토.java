

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

	static int[][] box;
	

	static int[] dr = { -1, 1, 0, 0 };
	static int[] dc = { 0, 0, -1, 1 };

	
	static class tomato{
		int r;
		int c;
		int day;
		
		public tomato(int r, int c, int day) {
			this.r = r;
			this.c = c;
			this.day = day;
		}
		
		
	}
	
	static Queue<tomato> queue = new LinkedList<>();

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine());

		int M = Integer.parseInt(st.nextToken());

		int N = Integer.parseInt(st.nextToken());

		box = new int[N][M];

		for (int r = 0; r < N; r++) {
			st = new StringTokenizer(br.readLine());
			for (int c = 0; c < M; c++) {
				box[r][c] = Integer.parseInt(st.nextToken());
			}
		}

		for (int r = 0; r < N; r++) {
			for (int c = 0; c < M; c++) {
				if (box[r][c] == 1) {
					queue.add(new tomato(r,c,0));
					
				}
			}
		}
		
		bfs();

	}

	
	static int result = 0;
	
	static void bfs() {
		
		
		
		
		while(!queue.isEmpty()) {
			tomato t = queue.poll();
			
			int row = t.r;
			int col = t.c;
			
			int day = t.day;
			
			result = day;
			
			for (int d = 0; d < 4; d++) {
				int nr = row + dr[d];
				int nc = col + dc[d];

				
				if(0<=nr && nr<box.length && 0<=nc && nc<box[0].length
						&& box[nr][nc]==0) {
					box[nr][nc] = 1;
					queue.add(new tomato(nr,nc,day+1));
				}
			}
		}
		
		if(clear()) {
			System.out.println(result);
		}else {
			System.out.println(-1);
		}
	}
	
	
	static boolean clear() {
		
		for(int r=0; r<box.length; r++) {
			for(int c=0; c<box[0].length; c++) {
				if(box[r][c]==0) {
					return false;
				}
			}
		}
		
		return true;
	}

}
