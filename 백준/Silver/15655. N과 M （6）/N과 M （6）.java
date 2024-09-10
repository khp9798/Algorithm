import java.util.Arrays;
import java.util.Scanner;

class Main {

	static int N;
	static int M;
	static boolean[] visited;
	static int[] sel;
	static int[] num;
	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		N = sc.nextInt();

		M = sc.nextInt();
		
		num = new int[N];
		for(int i=0; i<N; i++) {
			num[i] = sc.nextInt();
		}

		Arrays.sort(num);
		visited = new boolean[N + 1];

		sel = new int[M];

		dfs(0,0);
		
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

		for (int i = idx; i < N; i++) {
			if(!visited[i]) {
				visited[i] = true;
				sel[depth] = num[i];
				dfs(i,depth + 1);
				visited[i] = false;
			}
			

		}

	}

}