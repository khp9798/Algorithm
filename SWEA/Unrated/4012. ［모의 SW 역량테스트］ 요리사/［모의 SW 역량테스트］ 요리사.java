import java.util.Scanner;

public class Solution {

	static int N;
	
	static int [][] rel;
	
	static boolean [] visited;
	
	static int res;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int T= sc.nextInt();
		
		for(int t=1; t<=T; t++) {
			System.out.print("#"+t+" ");
			N = sc.nextInt();
			
			rel = new int[N][N];
			
			for(int i=0; i<N; i++) {
				for(int j=0; j<N; j++) {
					rel[i][j] = sc.nextInt();
				}
			}
			
			visited = new boolean[N];
			
			
			res = Integer.MAX_VALUE;
			
			dfs(0,0);
			
			System.out.println(res);
		}
	}


	static void dfs(int start, int count) {
		if(count==N/2) {
			cal();
			return;
		}
		
		for(int i=start; i<N; i++) {
			if(!visited[i]) {
				visited[i] = true;
				dfs(i+1,count+1);
				visited[i] = false;
			}
		}
	}


	private static void cal() {
		int truesum = 0;
		int falsesum =0;
		for(int r=0; r<N; r++) {
			for(int c=0; c<N; c++) {
				if(visited[r] && visited[c]) {
					truesum+=rel[r][c];
				}
				else if(!visited[r] && !visited[c]) {
					falsesum+=rel[r][c];
				}
			}
		}
		
		res = Math.min(res, Math.abs(truesum-falsesum));
		
	}
}
