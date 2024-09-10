import java.util.Scanner;

class Main{
	
	
	static int N;
	static int [] board;
	static boolean [] visited;
	
	public static void main(String [] args) {
		
		Scanner sc = new Scanner(System.in);
		
		
		N = sc.nextInt();
		
		
		//board의 인덱스가 row, 값이 col
		board = new int[N];
		
		visited = new boolean[N];
		
		dfs(0);
		
		System.out.println(res);
	}

	static int res=0;
	private static void dfs(int r) {
		if(r==N) {
			res++;
			return;
		}
		
		
		for(int i=0; i<N; i++) {
			if(checkQ(r,i)) {
				board[r] = i;
				visited[i] = true;
				dfs(r+1);	
				board[r] = 0;
				visited[i] = false;
			}
		}
		
	}
	
	
	static boolean checkQ(int r, int c) {
		if (visited[c]) return false;
		
		
		for(int i=0; i<r; i++) {
			if( Math.abs(i-r) == Math.abs(board[i]-c)) {
				return false;
			}
		}
		
		return true;
	}

	
}