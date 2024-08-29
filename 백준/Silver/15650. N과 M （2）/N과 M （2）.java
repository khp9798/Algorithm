

import java.util.Scanner;

public class Main {

	
	//1부터 n까지 자연수 중에서 중복없이 m개를 고른 수열
	//고른 수열은 오름차순
	
	static int N;
	static int M;
	static boolean [] visited;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		
		N = sc.nextInt();
		M = sc.nextInt();
		
		visited = new boolean[N+1];

		
		sunyul(1,0);
	}
	
	
	static void sunyul(int start, int cnt) {
		
		
		if(cnt>=M) {
			for(int i=1; i<=N; i++) {
				if(visited[i])
					System.out.print(i+" ");
			}
			System.out.println();
			return;
		}
		
		if(start>N) {
			return; 
		}
		
		
		visited[start] = true;
		sunyul(start+1,cnt+1);
		visited[start] = false;
		sunyul(start+1,cnt);
		
		
	}
	
	

}
