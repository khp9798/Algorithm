import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Solution {

	static int res;
	static int[][] map;
	static boolean[][] visited;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		for (int t = 0; t < 10; t++) {
			int testcase = Integer.parseInt(br.readLine());

			System.out.print("#" + testcase + " ");

			map = new int[16][16];
			visited = new boolean[16][16];

			for (int r = 0; r < 16; r++) {
				String str = br.readLine();
				for (int c = 0; c < 16; c++) {
					map[r][c] = str.charAt(c) - '0';
				}
			}

			res=0;
			bfs(1, 1);

			System.out.println(res);
		}

	}

	static int[] dr = { -1, 1, 0, 0 };
	static int[] dc = { 0, 0, -1, 1 };

	private static void bfs(int startr, int startc) {
		Queue<int[]> q = new LinkedList<>();
		q.add(new int[] { startr, startc });
		visited[startr][startc] = true;

		while (!q.isEmpty()) {
			int[] xy = q.poll();

			int r = xy[0];
			int c = xy[1];

			if(map[r][c]==3) {
				res = 1;
				return;
			}
			
			for (int d = 0; d < 4; d++) {
				int nr = r + dr[d];
				int nc = c + dc[d];
				
				if(nr<0 || nc<0 || nr>=16|| nc>=16) continue;
				if(visited[nr][nc] || map[nr][nc]==1 || map[nr][nc]==2) continue;
				
				visited[nr][nc] = true;
				q.add(new int[] {nr,nc});
			}
		}
	}

}
