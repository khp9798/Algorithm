import java.util.Scanner;

class Main {

	static int N;
	static int M;
	static boolean[] visited;
	static int[] sel;
	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		N = sc.nextInt();

		M = sc.nextInt();

		visited = new boolean[N + 1];

		sel = new int[M];

		dfs(1,0);
		
		System.out.println(sb.toString());

	}

	private static void dfs(int idx,int depth) {
		if (depth == M) {
			for (int i : sel) {
				sb.append(i+" ");
			}
			sb.append("\n");

			return;
		}

		for (int i = idx; i <= N; i++) {

			sel[depth] = i;
			dfs(i,depth + 1);

		}

	}

}