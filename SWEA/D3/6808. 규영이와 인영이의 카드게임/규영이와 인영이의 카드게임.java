

import java.util.Scanner;

public class Solution {

	static int N = 18;
	static boolean [] nums = new boolean[N+1];
	static int [] kyu = new int[N/2];
	static int[] in = new int[N/2];
	
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		
		
		int T = sc.nextInt();
		
		for(int tc=1; tc<=T; tc++) {
			nums = new boolean[19];
			for(int i=0; i<N/2; i++) {
				kyu[i] = sc.nextInt();
				nums[kyu[i]] = true;
			}
			
			int k=0;
			for(int i=1; i<N+1; i++) {
				if(!nums[i]) in[k++] = i;
			}
			
			CardGame(0);
			System.out.println("#"+tc+" "+win+" "+lose);
			
			win=0;
			lose=0;
		}//tc

	}
	
	static boolean [] visited = new boolean[N/2];
	static int scoreKyu = 0;
	static int scoreIn = 0;
	
	
	static int win = 0;
	static int lose = 0;
	
	static int [] in2 = new int[9];
	
	static void CardGame (int idx) {
		if(idx>=N/2) {
			Syobu(in2);
			return;
		}
		
		
		for(int i=0; i<N/2; i++) {
			if(visited[i]) continue;
			

			
			in2[idx] = in[i];
			visited[i] = true;
			CardGame(idx+1);
			visited[i] = false;
			
		}
	}

	static void Syobu(int[] in) {
		for(int i=0; i<N/2; i++) {
			if (kyu[i] > in[i]) {
				scoreKyu += kyu[i] + in[i];
			} else {
				scoreIn += kyu[i] + in[i];
			}
		}
		
		
		if(scoreKyu>scoreIn) {
			win++;
		}
		else if(scoreKyu<scoreIn) {
			lose++;
		}
		scoreKyu = 0;
		scoreIn = 0;
	}

}
