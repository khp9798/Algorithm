
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	static int[][] nodes;
	static boolean[] visited;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine());

		// 노드 개수
		int N = Integer.parseInt(st.nextToken());

		// 간선 개수
		int M = Integer.parseInt(st.nextToken());

		nodes = new int[N + 1][N + 1];
		visited = new boolean[N + 1];

		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());

			int u = Integer.parseInt(st.nextToken());

			int v = Integer.parseInt(st.nextToken());

			nodes[u][v] = 1;
			nodes[v][u] = 1;
		}

		int cnt = 0;
		for (int i = 1; i < N + 1; i++) {
			if (!visited[i]) {
				dfs(i);
				cnt++;
			}
		}

		System.out.println(cnt);
	}

	private static void dfs(int start) {
		visited[start] = true;

		for(int i=1; i<nodes.length; i++) {
			if (nodes[start][i]==1 && !visited[i]) {
				dfs(i);
			}
		}
		
	}

}
