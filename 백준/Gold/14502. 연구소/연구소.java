import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

	static int N;
	static int M;
	static int[][] map;
	static boolean[][] visited;

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		map = new int[N][M];
		visited = new boolean[N][M];

		int onecnt = 0;
		for (int r = 0; r < N; r++) {
			st = new StringTokenizer(br.readLine());
			for (int c = 0; c < M; c++) {
				map[r][c] = Integer.parseInt(st.nextToken());
				if (map[r][c]==1) {
					onecnt++;
				}
			}
		}

		dfs(0);
		
		
		
		System.out.println(N*M - onecnt-3- min);
	}

	//
	static void dfs(int blockcnt) {
		if (blockcnt == 3) {
			bfs();
			return;
		}

		for (int r = 0; r < N; r++) {
			for (int c = 0; c < M; c++) {
				if (map[r][c] == 0) {
					map[r][c] = 1;
					visited = new boolean[N][M];
					dfs(blockcnt + 1);
					map[r][c] = 0;
				}
			}
		}
		
		
		

	}

	static class Virus {
		int r;
		int c;
		int viruscnt;

		public Virus(int r, int c, int viruscnt) {
			super();
			this.r = r;
			this.c = c;
			this.viruscnt = viruscnt;
		}

	}

	static int[] dr = { -1, 1, 0, 0 };
	static int[] dc = { 0, 0, -1, 1 };

	
	static int min = Integer.MAX_VALUE;
	
	
	static void bfs() {
		Queue<Virus> queue = new LinkedList<>();
		int res=0;
		for (int r = 0; r < N; r++) {
			for (int c = 0; c < M; c++) {
				if (map[r][c] == 2 && !visited[r][c]) {
					queue.add(new Virus(r, c, 1));
					visited[r][c] = true;
					res++;
				}
			}
		}

		while (!queue.isEmpty()) {
			Virus v = queue.poll();
			
			
			for (int d = 0; d < 4; d++) {
				int nr = v.r + dr[d];
				int nc = v.c + dc[d];

				if(0<=nr && nr<N && 0<=nc && nc<M && !visited[nr][nc] && map[nr][nc]==0) {
					visited[nr][nc] = true;
					res++;
					queue.add(new Virus(nr,nc,v.viruscnt));
				}
			}
		}
		
		
		min = Math.min(min, res);

	}
}
