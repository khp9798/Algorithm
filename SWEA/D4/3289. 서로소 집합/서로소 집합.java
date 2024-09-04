

import java.util.Arrays;
import java.util.Scanner;

public class Solution {

	static int N;
	static int[] p;
	static int M;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int tc = sc.nextInt();
		
		for(int t=1; t<=tc; t++) {
			//정점의 개수
			N = sc.nextInt();
			
			//연산의 개수
			M = sc.nextInt();
			
			p = new int[N+1];
			
			
			//초기는 자기자신을 대표로 함.
			for(int i=1; i<=N; i++) {
				p[i] = i;
			}
			
			
			System.out.print("#"+t+" ");
			boolean res = false;
			//연산
			for(int i=0; i<M; i++) {
				int command = sc.nextInt();
				
				if(command==0) {
					int A = sc.nextInt();
					int B = sc.nextInt();
					
					Union(A, B);
					
				}else {
					int A = sc.nextInt();
					int B = sc.nextInt();
					
					if(findSet(A) == findSet(B)) {
						res = true;
					}
					else {
						res = false;
					}
					
					System.out.print(res? 1:0);
				}
			}
			
			System.out.println();
			
		}

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
