

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

	static class floor {
		int x;
		int cnt;

		public floor(int x, int cnt) {
			super();
			this.x = x;
			this.cnt = cnt;
		}

	}

	static int F;
	static int S;
	static int G;
	static int U;
	static int D;

	static floor[] building;
	static boolean[] visited;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine());

		// 총 건물 층수
		F = Integer.parseInt(st.nextToken());

		// 현재 강호가 있는 층수
		S = Integer.parseInt(st.nextToken());

		// 목적지 층수
		G = Integer.parseInt(st.nextToken());

		// 위로 갈 수 있는 층수
		U = Integer.parseInt(st.nextToken());

		// 아래로 갈 수 있는 층수
		D = Integer.parseInt(st.nextToken());

		// 건물 정보 저장 배열
		building = new floor[F + 1];
		visited = new boolean[F + 1];

		// 최소 몇번 눌러야 하는지니까 bfs 사용
		bfs(S, 0);

		if(result==-1) {
			System.out.println("use the stairs");
		}
		else {
			System.out.println(result);			
		}
	}

	static int result = -1;

	static void bfs(int S, int cnt) {
		Queue<floor> queue = new LinkedList<>();
		queue.add(new floor(S, cnt));

		while (!queue.isEmpty()) {
			floor f = queue.poll();

			visited[f.x] = true;
			if (f.x == G) {
				result = f.cnt;
				return;
			}
			if (f.x + U < F + 1 && !visited[f.x + U]) {
				visited[f.x+U] = true;
				queue.add(new floor(f.x + U, f.cnt + 1));
			}
			if (f.x - D >= 1 && !visited[f.x - D]) {
				visited[f.x-D] = true;
				queue.add(new floor(f.x - D, f.cnt + 1));
			}
		}
	}

}
