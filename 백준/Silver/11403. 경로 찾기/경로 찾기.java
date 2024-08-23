
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;



public class Main {

	static int N;
	static boolean [] visited;
	static int [][] relation;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(br.readLine());
		
		visited = new boolean [N+1];
		relation = new int[N+1][N+1];
		
		StringTokenizer st;
		for(int r=1; r<N+1; r++) {
			st = new StringTokenizer(br.readLine());
			for(int c=1; c<N+1; c++) {
				relation[r][c] = Integer.parseInt(st.nextToken());
			}
		}

		
		for(int start=1; start<N+1; start++) {
			for(int end=1; end<N+1; end++) {
				
				dfs(start,end,0);
				
				System.out.print(res+" ");
				res = 0;
				visited = new boolean [N+1];
			}
			System.out.println();
		}
	}

	
	static int res=0;
	
	
	static void dfs(int start, int end, int length) {
		if(length>0 && start == end) {
			res = 1;
			return;
		}
		
		
		for(int i=1; i<N+1; i++) {
			if(relation[start][i]==1 && !visited[i]) {
				visited[i] = true;
				dfs(i,end,length+1);
			}
		}
		
	}

}
