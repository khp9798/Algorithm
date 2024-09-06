import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Scanner;

public class Main {

	static int N;
	static int M;

	static List<Edge>[] edges;

	static class Edge implements Comparable<Edge>{
		int to;
		int W;

		public Edge(int to, int w) {
			super();
			this.to = to;
			W = w;
		}

		@Override
		public int compareTo(Main.Edge o) {
			// TODO Auto-generated method stub
			return this.W - o.W;
		}

	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		N = sc.nextInt();

		M = sc.nextInt();

		edges = new ArrayList[N+1];

		for (int i = 1; i < N+1; i++) {
			edges[i] = new ArrayList<>();

		}
		
		
		for(int i=0; i<M; i++) {
			int A = sc.nextInt();
			int B = sc.nextInt();
			int W = sc.nextInt();
			
			edges[A].add(new Edge(B,W));
			edges[B].add(new Edge(A,W));
		}
		
		
		
		boolean [] visited = new boolean[N+1];
		
		PriorityQueue<Edge> pq = new PriorityQueue<>();
		
		visited[1]=true;
		pq.addAll(edges[1]);
		
		
		int res=0;
		int pick=1;
		
		while(pick!=N) {
			Edge e = pq.poll();
			if(visited[e.to]) continue;
			
			visited[e.to] = true;
			res+=e.W;
			pick++;
			
			pq.addAll(edges[e.to]);
		}
		
		System.out.println(res);
	}

}