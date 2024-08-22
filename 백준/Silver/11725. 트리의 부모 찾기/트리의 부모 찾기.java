

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {

	static ArrayList<Integer> nodes[];
	static boolean visited[];
	static int [] parent;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(br.readLine());

		nodes = new ArrayList[N+1];
		visited = new boolean[N + 1];
		parent = new int[N+1];

		for (int i = 1; i <= N; i++) {  
            nodes[i] = new ArrayList<>();  
        }
		for (int i = 0; i < N - 1; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());

			int start = Integer.parseInt(st.nextToken());

			int end = Integer.parseInt(st.nextToken());

			nodes[start].add(end);
			nodes[end].add(start);
		}
		
		dfs(1);
		
		for(int i=2; i<N+1; i++) {
			System.out.println(parent[i]);
		}
	}

	
	static void dfs(int start) {
		visited[start] = true;
		
		for (int i : nodes[start]) {
			if(!visited[i]) {
				parent[i] = start;
				dfs(i);
			}
		}
	}
	
	


}
