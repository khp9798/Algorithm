

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

	static int N;
	static int M;
	static int H;
	static int[][][] box;

	// 상하좌우
	static int[] dr = { -1, 1, 0, 0 };
	static int[] dc = { 0, 0, -1, 1 };

	
	static class tomato {
		int h;
		int r;
		int c;
		int day;
		public tomato(int h, int r, int c, int day) {
			super();
			this.h = h;
			this.r = r;
			this.c = c;
			this.day = day;
		}
		
		
	}
	
	static Queue<tomato> queue = new LinkedList<>();
	
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine());

		// 가로 길이
		N = Integer.parseInt(st.nextToken());

		// 세로 길이
		M = Integer.parseInt(st.nextToken());

		// 높이
		H = Integer.parseInt(st.nextToken());

		box = new int[H][M][N];

		// 상자 정보 입력 받기
		for (int h = 0; h < H; h++) {
			for (int r = 0; r < M; r++) {
				st = new StringTokenizer(br.readLine());
				for (int c = 0; c < N; c++) {
					box[h][r][c] = Integer.parseInt(st.nextToken());
					if(box[h][r][c]==1) {
						queue.add(new tomato(h, r, c,0));
					}
				}
			}
		}

		bfs();
		
	}
	
	static void bfs() {
		int day = 0;
		
		while(!queue.isEmpty()) {
			tomato t = queue.poll();
			
			day = t.day;
			
			int fnh = t.h-1;
			int bnh = t.h+1;
			
			if(0<=fnh && box[fnh][t.r][t.c]==0) {
				box[fnh][t.r][t.c]=1;
				queue.add(new tomato(fnh,t.r,t.c,day+1));
			}
			
			if(bnh<H && box[bnh][t.r][t.c]==0) {
				box[bnh][t.r][t.c]=1;
				queue.add(new tomato(bnh,t.r,t.c,day+1));
			}
			
			for(int d=0; d<4; d++) {
				int nr = t.r + dr[d];
				int nc = t.c + dc[d];
				if(0<=nr && nr<M && 0<=nc && nc<N && box[t.h][nr][nc]==0) {
					box[t.h][nr][nc] = 1;
					queue.add(new tomato(t.h,nr,nc,day+1));
				}
			}
		}
		
		
		if(chechbox()) {
			System.out.println(day);
		}else {
			System.out.println(-1);
		}
	}

	static boolean chechbox() {
		for (int h = 0; h < H; h++) {
			for (int r = 0; r < M; r++) {
				for (int c = 0; c < N; c++) {
					if(box[h][r][c]==0) {
						return false;
					}
				}
			}
		}
		
		return true;
	}
	

}
