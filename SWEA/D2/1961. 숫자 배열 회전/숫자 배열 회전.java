
import java.util.Scanner;

public class Solution {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int T = sc.nextInt();

		for (int t = 1; t <= T; t++) {
			int N = sc.nextInt();

			int[][] arr = new int[N][N];

			for (int r = 0; r < N; r++) {
				for (int c = 0; c < N; c++) {
					arr[r][c] = sc.nextInt();
				}
			}
			//90도 회전
			int[][] arr90 = new int[N][N];
			for(int r=0; r<N; r++) {
				for(int c=0; c<N; c++) {
					arr90[r][c] = arr[N-1-c][r];
				}
			}
			
		
			
			//180도 회전
			int[][] arr180 = new int[N][N];
			for(int r=0; r<N; r++) {
				for(int c=0; c<N; c++) {
					arr180[r][c] = arr[N-1-r][N-1-c];
				}
			}
			
			
			//270도 회전
			int[][] arr270 = new int[N][N];
			for(int r=0; r<N; r++) {
				for(int c=0; c<N; c++) {
					arr270[r][c] = arr[c][(N-1)-r];
				}
			}
			
			
			System.out.println("#"+t);
			for(int r=0; r<N; r++) {
				for(int c=0; c<N; c++) {
					System.out.print(arr90[r][c]);
				}
				System.out.print(" ");
				for(int c=0; c<N; c++) {
					
					System.out.print(arr180[r][c]);
				}
				System.out.print(" ");
				for(int c=0; c<N; c++) {
					
					System.out.print(arr270[r][c]);
				}
				System.out.println();
			}
			
			
		}

	}

}
