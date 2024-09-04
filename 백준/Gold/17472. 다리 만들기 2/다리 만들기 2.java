import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Main {

	static int N;
	static int M;
	static int[][] map;
	static boolean[][] visited;

	static int[] dr = { -1, 1, 0, 0 };
	static int[] dc = { 0, 0, -1, 1 };

	static class Edge implements Comparable<Edge>{
		int A;
		int B;
		int W;

		@Override
		public String toString() {
			return "Edge [A=" + A + ", B=" + B + ", W=" + W + "]";
		}

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

	static List<Edge> edges;
	
	static int [] p;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		N = sc.nextInt();
		M = sc.nextInt();

		map = new int[N][M];
		visited = new boolean[N][M];

		for (int r = 0; r < N; r++) {
			for (int c = 0; c < M; c++) {
				map[r][c] = sc.nextInt();
			}
		}

		// 섬의 번호 매기기
		int num = 0;
		for (int r = 0; r < N; r++) {
			for (int c = 0; c < M; c++) {
				if (!visited[r][c] && map[r][c] == 1) {
					dfs(r, c, ++num);
				}
			}
		}

		// 간선 정보
		edges = new ArrayList<>();

//        for(int r=0; r<N; r++) {
//        	for(int c=0; c<M; c++) {
//        		System.out.print(map[r][c]+" ");
//        	}
//        	System.out.println();
//        }

		for (int r = 0; r < N; r++) {
			for (int c = 0; c < M; c++) {
				if (map[r][c] != 0) {
					dfsSelectD(r,c);
				}
			}
		}
		
		Collections.sort(edges);
		
		p = new int [num+1];
		
		
		for(int i=1; i<num+1; i++) {
			p[i] = i;
		}
		
		
		boolean [] visited = new boolean[num+1];
		int ans=0;
		int pick=0;
		for(int i=0; i<edges.size(); i++) {
			int px = findSet(edges.get(i).A);
			int py = findSet(edges.get(i).B);
			
			visited[edges.get(i).A] = true;
			visited[edges.get(i).B] = true;
			
			
			if(px!=py) {
				Union(px,py);
				ans+=edges.get(i).W;
				pick++;
			}
			
			if(pick==num-1) {
				break;
			}
		}
		
		
//		System.out.println(edges);
		for(int i=1; i<p.length; i++) {
			findSet(i);
		}
		
		boolean res=true;
		for(int i=2; i<p.length; i++) {
			if(p[i-1]!=p[i]) {
				res = false;
			}
		}
//		System.out.println(Arrays.toString(p));
//		System.out.println(Arrays.toString(visited));
		System.out.println(ans==0 || !res? -1:ans);
	}

	
	static int findSet(int x) {
		if(p[x]!=x)
			p[x] = findSet(p[x]);
		return p[x];
		
	}
	
	
	static void Union(int x, int y) {
		p[findSet(y)] = findSet(x);
	}
	
	private static void dfs(int r, int c, int num) {
		visited[r][c] = true;
		map[r][c] = num;

		for (int d = 0; d < 4; d++) {
			int nr = r + dr[d];
			int nc = c + dc[d];
			if (0 <= nr && nr < N && 0 <= nc && nc < M && !visited[nr][nc] && map[nr][nc] == 1) {
				dfs(nr, nc, num);
			}
		}

	}

	static void dfsSelectD(int r, int c) {
		for (int d = 0; d < 4; d++) {
			int nr = r + dr[d];
			int nc = c + dc[d];

			if (0 <= nr && nr < N && 0 <= nc && nc < M && !visited[nr][nc] && map[nr][nc] == 0) {
				dfsGo(nr, nc, d, 1, map[r][c]);
			}
		}
	}

	static void dfsGo(int r, int c, int direction, int length, int islandnum) {
		if(0>r || r>=N || 0>c || c>=M) return;
		
		if (map[r][c] != 0) {
			if (length > 2) {
				edges.add(new Edge(islandnum, map[r][c], length-1));
			}
			return;
		}

		
		
		dfsGo(r + dr[direction], c + dc[direction], direction, length + 1, islandnum);

	}
}