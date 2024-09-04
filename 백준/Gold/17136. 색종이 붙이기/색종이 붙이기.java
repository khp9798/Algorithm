import java.util.Arrays;
import java.util.Scanner;

public class Main {

	static int[][] map = new int[10][10];
	static int [] cnt = new int[6];

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		for (int i = 0; i < 10; i++) {
			for (int j = 0; j < 10; j++) {
				map[i][j] = sc.nextInt();
			}
		}

		dfs(0,0);
		
		
		//System.out.println(Arrays.toString(cnt));
		
		System.out.println(res==Integer.MAX_VALUE? -1:res);

	}
	

	static int res = Integer.MAX_VALUE;
	static void dfs(int r, int c) {
		if(r>9) {
			int sum=0;
			for(int i=1; i<cnt.length; i++) {
				sum+=cnt[i];
			}
			res = Math.min(res, sum);
			return;
		}
		if(c>9) {
			dfs(r+1,0);
			return;
		}
		
		if(map[r][c]!=1) {
			dfs(r,c+1);
			
		}
		else {
			for(int size=5; size>=1; size--) {
				if(cnt[size]<5 && check(r,c,size)) {

					paper(r,c,size,0);
					cnt[size]++;
					
					dfs(r,c+1);
					
					paper(r,c,size,1);
					cnt[size]--;
				}
			}
		}
		
		
		
		
	}
	
	static void paper(int r, int c, int size, int num) {
		for (int row = r; row < r + size; row++) {
			for (int col = c; col < c + size; col++) {
				if (row >= 10 || col >= 10)
					continue;
				map[row][col] = num;
			}
		}
	}
	
	
	static boolean check(int r, int c, int size) {
		for (int row = r; row < r + size; row++) {
			for (int col = c; col < c + size; col++) {
				if (row >= 10 || col >= 10 || map[row][col] != 1)
					return false;
			}
		}

		return true;
	}

}
