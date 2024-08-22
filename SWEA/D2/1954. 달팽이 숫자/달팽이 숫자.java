
import java.util.Scanner;

public class Solution {

	
	//우 하 좌 상
	static int [] dr = {0,1,0,-1};
	static int [] dc = {1,0,-1,0};
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int T = sc.nextInt();

		for (int t = 1; t <= T; t++) {
			int N = sc.nextInt();
			
			int [][] arr = new int[N][N];
			
			int num=1;
			int r=0;
			int c=0;
			int d=0;
			arr[r][c] = num++;
			
			while(true) {
				
				if(num==N*N+1) {
					break;
				}
				if(d==4) {
					d=0;
				}
				
				int nr = r+dr[d];
				int nc = c+dc[d];
				
				if(0<=nr && nr<N && 0<=nc && nc<N && arr[nr][nc]==0) {
					r=nr;
					c=nc;
					arr[r][c] = num++;
				}
				else {
					d++;
				}
				
			}
			
			
			System.out.println("#"+t);
			for(int i=0; i<N; i++) {
				for(int j=0; j<N; j++) {
					System.out.print(arr[i][j]+" ");
				}
				System.out.println();
			}
		}

	}

}
