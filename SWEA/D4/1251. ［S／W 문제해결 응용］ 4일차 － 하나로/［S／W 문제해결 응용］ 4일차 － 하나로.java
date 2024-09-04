

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class Solution {

	
	static int N;
	static double E;
	
	static class Island{
		int num;
		int x;
		int y;
		@Override
		public String toString() {
			return "Island [x=" + x + ", y=" + y + "]";
		}
		
		
	}
	
	
	static class Edge implements Comparable<Edge>{
		Island A;
		Island B;
		double W;
		public Edge(Island a, Island b, double w) {
			super();
			A = a;
			B = b;
			W = w;
		}
		
		@Override
		public String toString() {
			return "Edge [A=" + A + ", B=" + B + ", W=" + W + "]";
		}

		@Override
		public int compareTo(Edge o) {
			// TODO Auto-generated method stub
			return (int) (this.W-o.W);
		}

		
		
		
		
	}
	
	
	static Edge[] edges;
	
	static int [] p;
	
	
	static Island [] islands;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int tc = sc.nextInt();
		
		for(int t=1; t<=tc; t++) {
			//섬의 개수
			N = sc.nextInt();
			
			islands = new Island[N];
			
			//X좌표 입력
			for(int i=0; i<N; i++) {
				islands[i] = new Island();
				islands[i].num = i+1;
				islands[i].x = sc.nextInt();
			}
			
			//Y좌표 입력
			for(int i=0; i<N; i++) {
				islands[i].y = sc.nextInt();
			}
			
			//세율
			E = sc.nextDouble();
			
			
			edges = new Edge[edgesize(N-1)];  // (N-1)!
//			System.out.println(edgesize(N-1));
			
			int idx=0;
			for(int i=0; i<N-1; i++) {
				for(int j=i+1; j<N; j++) {
					double W = Math.pow(islands[i].x-islands[j].x, 2)+Math.pow(islands[i].y-islands[j].y, 2);
					edges[idx++] = new Edge(islands[i], islands[j], W);
				}
			}
			
			
			Arrays.sort(edges);
			
//			for(int i=0; i<edges.length; i++) {
//				System.out.println(edges[i]);
//			}
			
			
			p = new int[N+1];
			
			for(int i=1; i<=N; i++) {
				p[i] = i;
			}
			
			
			double res = 0;
			int pick = 0; //N-1개만 픽해야됨
			
			for(int i=0; i<edges.length; i++) {
				int px = findSet(edges[i].A.num);
				int py = findSet(edges[i].B.num);
				
				
				
				if(px!=py) {
					Union(px,py);
					res+=edges[i].W*E;
					pick++;
				}
				if(pick==N-1) {
					break;
				}
			}
			
//			System.out.println(Arrays.toString(p));
			System.out.printf("#%d %.0f\n",t,res);
			
		}

	}
	
	
	static int edgesize(int num) {
		int result= 0;
		for(int i=num; i>=1; i--) {
			result+=i;
		}
		
		return result;
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
