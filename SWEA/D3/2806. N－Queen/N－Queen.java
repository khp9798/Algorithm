

import java.util.Scanner;

public class Solution {

	static int N;

	static int[] dr = { -1, 1, 0, 0, -1, -1, 1, 1 };
	static int[] dc = { 0, 0, -1, 1, -1, 1, -1, 1 };

	static int[][] map;
	static int[][] visited;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int T = sc.nextInt();

		for (int tc = 1; tc <= T; tc++) {
			N = sc.nextInt();

			for (int c = 0; c < N; c++) {
				visited = new int[N][N];
				map = new int [N][N];
				Queen(0, c, 1);
				

			}

			
			
			System.out.println("#"+tc+" "+res);
            res=0;
		} // tc

	}

	static int res = 0;
	static void Queen(int r, int c, int count) {
		if(N==1) {
			res++;
			return;
		}
		else if(N==2) {
			res=0;
			return;
		}
		
		if(count==N) {
			res++;
			return;
		}
		
		
		
		if(visited[r][c]==0) {
			visited[r][c]+=1;
			for (int d = 0; d < 8; d++) {
				int nr = r + dr[d];
				int nc = c + dc[d];

				if (0 <= nr && nr < N && 0 <= nc && nc < N ) {
					QueenAttack(r, c, d,1);
				}
			}
			
		}
		
		
		for(int col = 0; col<N; col++) {
			if(r+1<N && visited[r+1][col]==0) {
				
				visited[r+1][col]+=1;
				for (int d = 0; d < 8; d++) {
					int nr = (r+1) + dr[d];
					int nc = col + dc[d];

					if (0 <= nr && nr < N && 0 <= nc && nc < N ) {
						QueenAttack(r+1, col, d,1);
					}
				}
				
				Queen(r+1,col,count+1);
				
				visited[r+1][col]-=1;
				for (int d = 0; d < 8; d++) {
					int nr = (r+1) + dr[d];
					int nc = col + dc[d];

					if (0 <= nr && nr < N && 0 <= nc && nc < N ) {
						QueenAttack(r+1, col, d,-1);
					}
				}
				
				
			}
		}
		
	}

	static void QueenAttack(int r, int c, int direction, int value) {
		
		
		int nr = r + dr[direction];
		int nc = c + dc[direction];

		if (0 <= nr && nr < N && 0 <= nc && nc < N) {
			visited[nr][nc] += value;
			QueenAttack(nr, nc, direction,value);
		}

	}

}
