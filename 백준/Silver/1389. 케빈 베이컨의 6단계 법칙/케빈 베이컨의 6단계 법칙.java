import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {

	static int [][] relation;
	static boolean [] visited;
	static int N;
	static int M;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		//유저의 수
		N = sc.nextInt();
		relation = new int[N+1][N+1];
		visited = new boolean[N+1];
		
		
		//관계의 수
		M = sc.nextInt();
		
		
		for(int t=0; t<M; t++) {
			int a = sc.nextInt();
			int b = sc.nextInt();
			
			relation[a][b] = 1;
			relation[b][a] = 1;
		}
		
		
		int min = Integer.MAX_VALUE;
		int minnum = 0;
		for(int i=1; i<=N; i++) {
			int sum=0;
			for(int j=1; j<=N; j++) {
				if(i!=j) {
					sum+=bfs(i,j,sum);
					visited = new boolean[N+1];
					
				}
			}
			
			if(min>sum) {
				min = sum;
				minnum = i;
			}
			
		}
		
		
		System.out.println(minnum);

	}

	
	static class user{
		int num;
		int length;
		public user(int num, int length) {
			super();
			this.num = num;
			this.length = length;
		}
		
	}
	
	
	static int bfs(int start, int end, int sum) {
		Queue<user> queue = new LinkedList<>();
		queue.add(new user(start,0));
		visited[start] = true;
		
		
		
		while(!queue.isEmpty()) {
			user p = queue.poll();
			
			int num = p.num;
			int length = p.length;
			
			if(num==end) {
				sum=length;
				break;
			}
			
			for(int i=1; i<=N; i++) {
				if(relation[num][i] == 1 && !visited[i]) {
					visited[i] = true;
					queue.add(new user(i,length+1));
				}
			}
		}
		
		return sum;
	}

}
