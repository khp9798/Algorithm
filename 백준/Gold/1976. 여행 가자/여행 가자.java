
import java.util.Scanner;

class Main {

	static int N;
	static int M;
	
	static int [][] edges;
	
	static int [] plan;
	
	static int [] p;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		
		N = sc.nextInt();
		
		M = sc.nextInt();
		
		edges = new int[N+1][N+1];
		
		for(int i=1; i<=N; i++) {
			for(int j=1; j<=N; j++) {
				edges[i][j] = sc.nextInt();
			}
		}
		
		plan = new int[M];
		
		for(int i=0; i<M; i++) {
			plan[i] = sc.nextInt();
		}
		
		
		p = new int[N+1];
		
		for(int i=1; i<=N; i++) {
			p[i] = i;
		}
		
		
		for(int i=1; i<=N; i++) {
			for(int j=1; j<=N; j++) {
				if(edges[i][j]==1) {
					Union(i,j);
				}
			}
		}
		
		
		boolean res = true;
		for(int i=1; i<M; i++) {
			if(findSet(plan[i])!=findSet(plan[i-1])) {
				res = false;
			}
		}
		
		System.out.println(res? "YES" : "NO");
		
		
	}

	static int findSet(int x) {
		if(p[x]!=x) {
			p[x] = findSet(p[x]);
		}
		return p[x];
	}
	
	
	static void Union(int x, int y) {
		p[findSet(y)] = findSet(x);
	}



}