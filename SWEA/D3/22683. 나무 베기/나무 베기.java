import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Solution {

	static int N;
	static int K;

	static char[][] map;

	static int[][][] visited;

	static int[] dr = { -1, 0, 1, 0 };
	static int[] dc = { 0, 1, 0, -1 };

	static int[] startP;
	static int[] destP;

	static int res;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int T = Integer.parseInt(br.readLine());

		for (int t = 1; t <= T; t++) {
			StringTokenizer st = new StringTokenizer(br.readLine());

			N = Integer.parseInt(st.nextToken());
			K = Integer.parseInt(st.nextToken());

			map = new char[N][N];

			visited = new int[N][N][K + 1];
			
			for(int i=0; i<N; i++) {
				for(int j=0; j<N; j++) {
					Arrays.fill(visited[i][j], Integer.MAX_VALUE);
				}
			}

			res = Integer.MAX_VALUE;

			startP = new int[2];
			destP = new int[2];

			for (int r = 0; r < N; r++) {
				String str = br.readLine();
				map[r] = str.toCharArray();
				for (int c = 0; c < N; c++) {
					if (map[r][c] == 'X') {
						startP[0] = r;
						startP[1] = c;
					} else if (map[r][c] == 'Y') {
						destP[0] = r;
						destP[1] = c;
					}
				}
			}


			bfs(startP[0], startP[1], 0, K);

			
			res = res == Integer.MAX_VALUE ? -1 : res;
			System.out.println("#" + t + " " + res);
		}
	}

	private static void bfs(int row, int col, int turn, int cut) {
		Queue<int[]> q = new LinkedList<>();
		visited[row][col][cut] = 0;
		q.add(new int[] { row, col, turn, cut,0 });

		while (!q.isEmpty()) {
			int[] xy = q.poll();

			int r = xy[0];
			int c = xy[1];
			int turn1 = xy[2];
			int cnt = xy[3];
			
			int destination = xy[4];
			

			if (r == destP[0] && c == destP[1]) {
				res = Math.min(res, turn1);
			}

			for (int d = 0; d < 4; d++) {
				int nr = r + dr[d];
				int nc = c + dc[d];
				
				

				if (nr < 0 || nc < 0 || nr >= N || nc >= N)
					continue;

				//바라보는 방향과 갈 방향이 같을 때
				if(destination==d) {
					if (map[nr][nc] == 'T' && cnt > 0) {
						if (visited[nr][nc][cnt - 1] > turn1+1) {
							visited[nr][nc][cnt - 1] = turn1+1;
							q.add(new int[] { nr, nc, turn1+1, cnt - 1,d });
						}
					} else if (map[nr][nc] != 'T') {
						if (visited[nr][nc][cnt]>turn1+1) {
							visited[nr][nc][cnt] = turn1+1;
							q.add(new int[] { nr, nc, turn1+1, cnt ,d});
						}
					}
					
				}else if(Math.abs(destination-d)==2) {
					if (map[nr][nc] == 'T' && cnt > 0) {
						if (visited[nr][nc][cnt - 1] > turn1+3) {
							visited[nr][nc][cnt - 1] = turn1+3;
							q.add(new int[] { nr, nc, turn1+3, cnt - 1,d });
						}
					} else if (map[nr][nc] != 'T') {
						if (visited[nr][nc][cnt] > turn1+3) {
							visited[nr][nc][cnt] = turn1+3;
							q.add(new int[] { nr, nc, turn1+3, cnt ,d});
						}
					}
				}else {
					if (map[nr][nc] == 'T' && cnt > 0) {
						if (visited[nr][nc][cnt - 1] > turn1+2) {
							visited[nr][nc][cnt - 1] = turn1+2;
							q.add(new int[] { nr, nc, turn1+2, cnt - 1,d });
						}
					} else if (map[nr][nc] != 'T') {
						if (visited[nr][nc][cnt] > turn1+2) {
							visited[nr][nc][cnt] = turn1+2;
							q.add(new int[] { nr, nc, turn1+2, cnt ,d});
						}
					}
				}

				
			}
		}
	}

}
