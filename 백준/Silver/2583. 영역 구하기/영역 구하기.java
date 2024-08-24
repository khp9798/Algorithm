

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

	static int[][] map;
	static boolean[][] visited;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine());

		// 행의 길이
		int N = Integer.parseInt(st.nextToken());

		// 열의 길이
		int M = Integer.parseInt(st.nextToken());

		// 직사각형의 개수
		int K = Integer.parseInt(st.nextToken());

		map = new int[N][M];
		visited = new boolean[N][M];

		// 직사각형 부분 -1로 만들기
		for (int i = 0; i < K; i++) {
			st = new StringTokenizer(br.readLine());

			int c1 = Integer.parseInt(st.nextToken());
			int r1 = Integer.parseInt(st.nextToken());

			int c2 = Integer.parseInt(st.nextToken());
			int r2 = Integer.parseInt(st.nextToken());

			for (int r = r1; r < r2; r++) {
				for (int c = c1; c < c2; c++) {
					map[r][c] = -1;
				}
			}
		}

		int cnt = 1;
		for (int r = 0; r < N; r++) {
			for (int c = 0; c < M; c++) {
				if (!visited[r][c] && map[r][c] != -1) {
					visited[r][c] = true;
					dfs(r, c,cnt);
					cnt++;
				}
			}
		}
		
		
		System.out.println(cnt-1);
		
		
		int [] res = new int[cnt];
		for(int i=1; i<cnt; i++) {
			int sum=0;
			for(int r=0; r<N; r++) {
				for(int c=0; c<M; c++) {
					if(map[r][c]==i) {
						sum++;
					}
				}
			}
			res[i-1] = sum;
		}
		
		
		Arrays.sort(res);
		
		
		for(int i=1; i<res.length; i++) {
			System.out.print(res[i]+" ");
		}

	}

	
	static int [] dr = {-1,1,0,0};
	static int [] dc = {0,0,-1,1};
	
	static void dfs(int r, int c, int num) {	
		map[r][c] = num;
		
		for(int d=0; d<4; d++) {
			int nr = r+dr[d];
			int nc = c+dc[d];
			
			if(0<=nr && nr<map.length && 0<=nc && nc<map[0].length && !visited[nr][nc] && map[nr][nc] !=-1) {
				visited[nr][nc] = true;
				dfs(nr,nc,num);
			}
		}
		
	}

}
