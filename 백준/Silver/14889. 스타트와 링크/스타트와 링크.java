


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {



	static int N;
	static boolean [] visited;
	static int [][] power;
	
	static int min = Integer.MAX_VALUE;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
		
		//사람수
		N = Integer.parseInt(br.readLine());
		
		visited = new boolean[N];
		
		power = new int[N][N];
		
		for(int i=0; i<N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int j=0; j<N; j++) {
				power[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		dfs(0,0);
		System.out.println(min);

	}
	
	
	static void dfs(int idx, int depth) {
		if(depth==N/2) {
			powerCal();
			return;
		}
		
		for(int i=idx; i<N; i++) {
			if(!visited[i]) {
				visited[i] = true;
				dfs(i+1,depth+1);
				visited[i] = false;
			}
		}
	}


	static void powerCal() {
				
		
		int sumTrue = 0;
		int sumFalse = 0;
		
		
		for(int i=0; i<N; i++) {
			for(int j=0; j<N; j++) {
				if(visited[i]&&visited[j]) {
					sumTrue += power[i][j];
				}
				else if (!visited[i]&&!visited[j]){
					sumFalse += power[i][j];					
				}
			}
		}
		
		
		min = Math.min(min, Math.abs(sumTrue-sumFalse));
		
	}

	
	

}
