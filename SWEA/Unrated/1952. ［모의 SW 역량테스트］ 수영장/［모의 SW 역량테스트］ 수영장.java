

import java.util.Scanner;

public class Solution {

	
	static int[] cost;
	static int[] plan;
	static int res;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int tc = sc.nextInt();
		
		for(int t=1; t<=tc; t++) {
			cost = new int[4];
			
			plan = new int[13];
			
			
			for(int i=0; i<4; i++) {
				cost[i] = sc.nextInt();
			}
			
			
			
			for(int i=1; i<=12; i++) {
				plan[i] = sc.nextInt();
			}
			
			
			
			
			res = Integer.MAX_VALUE;
			
			dfs(1,0);
			
			System.out.println("#"+t+" "+res);
		}

	}

	private static void dfs(int month, int sum) {
		if(res<=sum) return;
		
		if(month>12) {
			res = Math.min(res,sum);
			return;
		}
		
		
		
		dfs(month+1,sum+cost[0]*plan[month]);
		
		dfs(month+1,sum+cost[1]);
		
		dfs(month+3,sum+cost[2]);
		
		dfs(month+12, sum+cost[3]);
	}

}
