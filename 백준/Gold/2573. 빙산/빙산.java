import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	static int N;
	static int M;

	static int[][] map;
	static int[][] copymap;

	static boolean[][] visited;

	static int[] dr = { -1, 1, 0, 0 };
	static int[] dc = { 0, 0, -1, 1 };

	static int cnt = 0;

	

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());

		M = Integer.parseInt(st.nextToken());

		map = new int[N][M];
		copymap = new int[N][M];

		for (int r = 0; r < N; r++) {
			st = new StringTokenizer(br.readLine());
			for (int c = 0; c < M; c++) {
				map[r][c] = Integer.parseInt(st.nextToken());
			}
		}

		int isTwo = 0;
		int cnt = 0;
		while (isTwo < 2) {
			
			for (int r = 0; r < N; r++) {
				for (int c = 0; c < M; c++) {
					if (map[r][c] != 0) {
						melt(r, c);
					}
				}
			}

			for (int r = 0; r < N; r++) {
				for (int c = 0; c < M; c++) {
					if (map[r][c] != 0) {
						map[r][c] = map[r][c] < copymap[r][c] ? 0 : map[r][c] - copymap[r][c];
					}
				}
			}

//			for (int r = 0; r < N; r++) {
//				for (int c = 0; c < M; c++) {
//					System.out.print(map[r][c] + " ");
//				}
//				System.out.println();
//			}
//
//			System.out.println();

			visited = new boolean[N][M];
			isTwo=0;
			for (int r = 0; r < N; r++) {
				for (int c = 0; c < M; c++) {
					if (map[r][c] != 0 && !visited[r][c]) {
						clear(r, c);
						isTwo++;
						
					}
				}
			}
            
            if(isTwo==0) {
				break;
			}


			cnt++;
		}

		
		System.out.println(isTwo>=2 ? cnt : 0);

	}

	// 상하좌우에 바다가 몇개있는지 탐색
	static void melt(int r, int c) {
		int cnt = 0;

		for (int d = 0; d < 4; d++) {
			int nr = r + dr[d];
			int nc = c + dc[d];

			if (0 <= nr && nr < N && 0 <= nc && nc < M && map[nr][nc] == 0) {
				cnt++;
			}
		}

		copymap[r][c] = cnt;

	}

	// 구역이 2개로 나뉘는지
	static void clear(int r, int c) {
		visited[r][c] = true;

		for (int d = 0; d < 4; d++) {
			int nr = r + dr[d];
			int nc = c + dc[d];

			if (0 <= nr && nr < N && 0 <= nc && nc < M && !visited[nr][nc] && map[nr][nc] != 0) {
				clear(nr, nc);
			}
		}

	}

}
