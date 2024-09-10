import java.util.Scanner;

class Main{
	
	static int N;
	static int S;
	
	static int [] arr;
	static boolean [] visited;
	
	public static void main(String [] args) {
		
		Scanner sc = new Scanner(System.in);
		
		
		N = sc.nextInt();
		
		S = sc.nextInt();
		
		arr = new int[N];
		visited = new boolean[N];
		
		for(int i=0; i<N; i++) {
			arr[i] = sc.nextInt();
		}
		
		
		dfs(0,0);
		
		System.out.println(res);
	}

	static int res=0;
	private static void dfs(int idx, int cnt) {
		if(cnt==N) {
			int sum=0;
			int count=0;
			for(int i=0; i<N; i++) {
				if(visited[i]) {
					count++;
					sum+=arr[i];
				}
			}
			
			if(sum==S && count!=0) {
				res++;
			}
			
			return;
		}
		
		if(idx==N) {
			return;
		}
		
		
		
		visited[idx] = true;
		dfs(idx+1,cnt+1);
		visited[idx] = false;
		
		dfs(idx+1,cnt+1);
		
		
	}

	

	
}