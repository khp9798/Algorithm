

import java.util.Scanner;

public class Solution {

	static int [] score;
	static int [] cal;
	static boolean [] visited;
	static int N; //재료의 개수
	static int L; //칼로리 제한
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
      
		
		int T = sc.nextInt();
		
		for(int t=1; t<=T; t++) {
			//재료의 개수
			N = sc.nextInt();
			
			
			//칼로리 제한
			L = sc.nextInt();
			
			
			score = new int[N];
			cal = new int[N];
			
			
			for(int i=0; i<N; i++) {
				score[i] = sc.nextInt();
				cal[i] = sc.nextInt();
			}
			
			for(int i=1; i<=N; i++) {
				//조합의 개수
				cnt = i;
				
				
				for(int j=0; j<N; j++) {
					//조합에 시작하는 인덱스
					visited = new boolean[N];
					good(j,1,0,0);
				}
				
			}
			
			System.out.println("#"+t+" "+max);
			max = Integer.MIN_VALUE;
			
		}

	}
	
	static int cnt = 0;
	static int max = Integer.MIN_VALUE;
	
	//idx는 현재 재료 인덱스
	//a는 현재 조합을 몇개 했는지
	public static void good(int idx, int a, int scoresum, int calsum) {
		visited[idx] = true;
		scoresum += score[idx];
		calsum += cal[idx];
		
		if(calsum>L) {
//			visited[idx] = false;
			return;
		}
		if(a==cnt) {
			max  = Math.max(scoresum, max);
			return;
		}
		
		
		
		
		for(int i=idx; i<N; i++) {
			if(!visited[i]) {
				good(i,a+1,scoresum,calsum);
				visited[i] = false;
			}
		}
	}

}
