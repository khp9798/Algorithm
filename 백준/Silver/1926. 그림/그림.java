import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {

	static int [][] map;
	static boolean [][] visited;
	static int N;
	static int M;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		//행의 길이
		N = sc.nextInt();
		//열의 길이
		M = sc.nextInt();
		
		map = new int[N][M];
		visited = new boolean[N][M];
		
		
		
		for(int r=0; r<N; r++) {
			for(int c=0; c<M; c++) {
				map[r][c] = sc.nextInt();
			}
		}
		
		
		int picture = 0;
		for(int r=0; r<N; r++) {
			for(int c=0; c<M; c++) {
				if(map[r][c] == 1 && !visited[r][c]) {
					dfs(r,c, 1);
					picture++;
					max = Math.max(max, picturecnt);
					picturecnt = 1;
				}
			}
		}
		
		System.out.println(picture);
		System.out.println(max);

	}

	static int [] dr = {-1,1,0,0};
	static int [] dc = {0,0,-1,1};
	
	static int max = 0;
	static int picturecnt = 1;
	static void dfs(int r, int c, int cnt) {
		visited[r][c] = true;
		
		for(int d=0; d<4; d++) {
			int nr = r+dr[d];
			int nc = c+dc[d];
			
			if(0<=nr && nr<N && 0<=nc && nc<M && map[nr][nc]==1 && !visited[nr][nc]) {
				picturecnt++;
				dfs(nr,nc,cnt+1);
			}
		}
		
	}

	
	
	
	
	

}
