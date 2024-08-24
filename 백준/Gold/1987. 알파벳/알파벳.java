

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

	static int N;
	static int M;

	static char[][] map;
	static boolean [] visited = new boolean['Z'-'0'+1];

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		map = new char[N][M];
		

		for (int r = 0; r < N; r++) {
			String[] str = br.readLine().split("");
			for (int c = 0; c < M; c++) {
				map[r][c] = str[c].charAt(0);
			}
		}

		dfs(0, 0, 1);
		
		System.out.println(res);
	}

	static int[] dr = { -1, 1, 0, 0 };
	static int[] dc = { 0, 0, -1, 1 };

	
	static int res = 0;
	static void dfs(int r, int c, int count) {
		visited[map[r][c]-'0'] = true;
		res = Math.max(res, count);
//		System.out.println(r+", "+c+" = "+map[r][c]);
		
		for(int d=0; d<4; d++) {
			int nr = r+dr[d];
			int nc = c+dc[d];
			
			if(0<=nr &&nr<N && 0<=nc && nc<M && !visited[map[nr][nc]-'0']) {
				dfs(nr,nc,count+1);
				visited[map[nr][nc]-'0'] = false;
			}
		}

	}

}
