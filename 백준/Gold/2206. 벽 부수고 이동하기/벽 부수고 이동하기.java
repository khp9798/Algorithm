

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
	static boolean[][][] visited;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		map = new int[N][M];
		visited = new boolean[N][M][2];

		for (int r = 0; r < N; r++) {
			String [] str = br.readLine().split("");
			for (int c = 0; c < M; c++) {
				int num = Integer.parseInt(str[c]);
				map[r][c] = num == 1 ? -1 : num;
			}
		}
		
		
		//벽을 안깬 경우
		visited[0][0][1] = true;
		
		//벽을 깬 경우
		visited[0][0][0] = true;
		
		//두 경우 모두 0,0에서 시작하니 방문처리 
		
		bfs(0, 0, 1,1);
		
		
		

		System.out.println(res);

	}

	static class Node {
		int r;
		int c;
		int crush;
		int road;
		public Node(int r, int c, int crush, int road) {
			super();
			this.r = r;
			this.c = c;
			this.crush = crush;
			this.road = road;
		}

		

	}

	static int[] dr = { -1, 1, 0, 0 };
	static int[] dc = { 0, 0, -1, 1 };

	
	
	static int res = -1;
	static void bfs(int r, int c, int crush, int length) {
		Queue<Node> queue = new LinkedList<>();
		queue.add(new Node(r, c, crush,length));
		

		while (!queue.isEmpty()) {
			Node n = queue.poll();

			int row = n.r;
			int col = n.c;

			int road = n.road;
			int cnt = n.crush;
			

			if(row==N-1 && col == M-1) {

				res = road;
				return;
			}
			
			
			
			

			for (int d = 0; d < 4; d++) {
				int nr = row + dr[d];
				int nc = col + dc[d];

				if (0 <= nr && nr < N && 0 <= nc && nc < M) {
					if (cnt > 0 && !visited[nr][nc][cnt-1] &&map[nr][nc]==-1) {
						//벽을 깬 경우
						visited[nr][nc][cnt-1] = true;
						queue.add(new Node(nr,nc,cnt-1,road+1));
				
					}
					else if(!visited[nr][nc][cnt] && map[nr][nc]!=-1) {
						//벽을 안깨는 경우
						visited[nr][nc][cnt] = true;
						queue.add(new Node(nr,nc,cnt,road+1));
	
					}
				}
			}

		}
	}

}
