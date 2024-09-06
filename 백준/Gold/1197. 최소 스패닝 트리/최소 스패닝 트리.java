
import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Scanner;

public class Main {

	static class Edge implements Comparable<Edge>{
		int A,B,W;

		public Edge(int a, int b, int w) {
			super();
			A = a;
			B = b;
			W = w;
		}

		@Override
		public int compareTo(Main.Edge o) {
			// TODO Auto-generated method stub
			return this.W - o.W;
		}
		
		
	}
	
	static List<Edge>[] rel;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int V = sc.nextInt();
		int E = sc.nextInt();
		
		
		rel = new ArrayList[V+1];
		
		for(int i=1; i<=V; i++) {
			rel[i] = new ArrayList<>();
		}
		
		for(int i=0; i<E; i++) {
			int A = sc.nextInt();
			int B = sc.nextInt();
			int W = sc.nextInt();
			
			rel[A].add(new Edge(A,B,W));
			rel[B].add(new Edge(B,A,W));
			
		}
		
		
		boolean[] visited = new boolean[V+1];
		int [] dist = new int[V+1];
		
		PriorityQueue<Edge> pq = new PriorityQueue<>();
		
		pq.addAll(rel[1]);
		visited[1] = true;
		
		
		int res=0;
		int pick=1;
		
		
		while(pick!=V) {
			Edge e = pq.poll();
			
			if(visited[e.B]) continue;
			
			visited[e.B] = true;
			res+=e.W;
			pick++;
			
			pq.addAll(rel[e.B]);
		}
		
		
		System.out.println(res);
		
		
	}

	
}