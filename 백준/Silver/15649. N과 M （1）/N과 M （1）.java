

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	static int N;
	static int M;

	static boolean [] visited;
	static int [] arr;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		
		

		M = Integer.parseInt(st.nextToken());
		
		visited = new boolean[N+1];
		arr = new int[M];

		dfs(0);

	}

	static void dfs(int cnt) {
		if(cnt==M) {
			for (int i : arr) {
				System.out.print(i+" ");
			}
			System.out.println();
			return;
		}
		
		for(int i=1; i<N+1; i++) {
			if(!visited[i]) {
				visited[i] = true;
				arr[cnt] = i;
				dfs(cnt+1);
				visited[i] = false;
			}
		}
	}
}
