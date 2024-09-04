
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;
import java.util.Set;

public class Solution {

	static int N;
	static int M;
	
	static int [] person;
	
	static Set<Integer> p;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int tc = sc.nextInt();
		
		for(int t=1; t<=tc; t++) {
			//사람의 수
			N = sc.nextInt();
			
			//관계의 수
			M = sc.nextInt();
			
			
			person = new int[N+1];
			
			
			for(int i=1; i<=N; i++) {
				person[i] = i;
			}
			
			
			for(int i=0; i<M; i++) {
				int A = sc.nextInt();
				int B = sc.nextInt();
				
				Union(A,B);
			}
			
			
			p = new HashSet<>();
			
			for(int i=1; i<=N; i++) {
				findSet(i);
			}
			
			for(int i=1; i<=N; i++) {
				p.add(person[i]);
			}
			
			
			System.out.println("#"+t+" "+p.size());
		
			
		}

	}
	
	
	static int findSet(int x) {
		if(person[x]!=x) {
			person[x] = findSet(person[x]);
		}
		return person[x];
	}
	
	
	
	static void Union(int x, int y) {
		person[findSet(y)] = findSet(x);
	}

}
