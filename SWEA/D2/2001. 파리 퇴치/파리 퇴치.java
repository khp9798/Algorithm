import java.util.Scanner;

public class Solution {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int T = sc.nextInt();

		for (int t = 1; t <= T; t++) {
			int N = sc.nextInt();
			int M = sc.nextInt();
			
			int[][] arr = new int[N][N];
			for(int r=0; r<N; r++) {
				for(int c=0; c<N; c++) {
					arr[r][c] = sc.nextInt();
				}
			}
			
			
			
			int max = Integer.MIN_VALUE;
			for(int r=0; r<=N-M; r++) {
				for(int c=0; c<=N-M; c++) {
					int sum=0;
					for(int x=r; x<r+M; x++) {
						for(int y=c; y<c+M; y++) {
							sum+=arr[x][y];
						}
					}
					max = Math.max(max, sum);
				}
			}
			
			System.out.println("#"+t+" "+max);
		}

	}

}
