

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Main {

	static int N;
	static int[][] map;
	static boolean[][] visited;
	
	static int[] dr = {-1,1,0,0};
	static int[] dc = {0,0,-1,1};
	
	static int cnt=1;
	
	static List<Integer> answer = new ArrayList<>();
	
	public static void main(String[] args) throws Exception, Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		//지도의 크기
		N = Integer.parseInt(br.readLine());
		
		//지도 내용 입력 받기
		map = new int[N][N];
		visited = new boolean[N][N];
		
		for(int r=0; r<N; r++) {
			String[] str = br.readLine().split("");
			for(int c=0; c<N; c++) {
				map[r][c] = Integer.parseInt(str[c]);
			}
		}
		
		for(int r=0; r<N; r++) {
			for(int c=0; c<N; c++) {
				if(map[r][c] == 1 && !visited[r][c]) {
					dfs(r,c);
					answer.add(cnt);
					cnt=1;
				}
			}
		}
		
		Collections.sort(answer);
		
		System.out.println(answer.size());
		for(int a : answer) {
			System.out.println(a);
		}

	}
	

	
	static void dfs(int r, int c) {
		//일단 자기자신은 방문했으니까
		visited[r][c] = true;
		
		//상하좌우 탐색
		for(int d=0; d<4; d++) {
			
			int nr = r+dr[d];
			int nc = c+dc[d];
			
			
			if(0<=nr && nr<N && 0<=nc && nc<N && !visited[nr][nc] && map[nr][nc]!=0) {
				dfs(nr,nc);
				cnt++;
			}
		}
	}

}
