

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.Scanner;

public class Main {

	static int N;
	static int [] nums;
	static int [] operator = new int[4];
	static int max = Integer.MIN_VALUE;
	static int min = Integer.MAX_VALUE;
	
	
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

	public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner(System.in);
		
		N = sc.nextInt();
		nums = new int[N];
		
		for(int i=0; i<N; i++) {
			nums[i] = sc.nextInt();
		}
		
		for(int i=0; i<4; i++) {
			operator[i] = sc.nextInt();
		}
		

		dfs(nums[0],1);
		
		bw.write(max+"\n");
		bw.write(min+"\n");
		
		bw.flush();
		bw.close();

	}

	private static void dfs(int currResult, int idx){
		if(idx == N) {
			max = Math.max(currResult, max);
			min = Math.min(currResult, min);
			return;
		}

		
		for(int i=0; i<4; i++) {
			if(operator[i]>0) {
				operator[i] -- ;
				
				if(i==0) {
					dfs(currResult+nums[idx],idx+1);
				}
				else if(i==1) {
					dfs(currResult-nums[idx],idx+1);
				}
				else if(i==2) {
					dfs(currResult*nums[idx],idx+1);
				}
				else if(i==3) {
					if(currResult<0) {
						dfs(-(Math.abs(currResult)/nums[idx]),idx+1);
					}
					else {
						dfs(currResult/nums[idx],idx+1);						
					}
				}
				
				operator[i]++;
				
			}
		}
	}

}
