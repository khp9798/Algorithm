import java.util.Arrays;
import java.util.Scanner;
import java.util.Set;

class Main {

	static int N;
	static int M;
	static int[][] visited;
	static boolean[] select;
	static int[] sel;
	static int[] num;
	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		N = sc.nextInt();

		M = sc.nextInt();

		num = new int[N];
		

		for (int i = 0; i < N; i++) {
			num[i] = sc.nextInt();

		}

		
		Arrays.sort(num);


		sel = new int[M];
		select = new boolean[N];


		dfs(0,0);

		System.out.println(sb.toString());

	}

	private static void dfs(int idx,int depth) {
		if (depth == M) {
			for (int i : sel) {
				sb.append(i + " ");
			}
			sb.append("\n");

			return;
		}

		int xx=0;
		for (int i = 0; i < N; i++) {
			if(num[i]!=xx) {
				
				xx = num[i];
				sel[depth] = num[i];
				dfs(i,depth + 1);				
				
			}

		}

	}

}