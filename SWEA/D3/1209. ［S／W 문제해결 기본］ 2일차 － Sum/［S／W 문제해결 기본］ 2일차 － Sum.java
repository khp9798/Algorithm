import java.util.Scanner;

public class Solution {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		

		for (int t = 1; t <= 10; t++) {
			int[][] arr = new int[100][100];
			
			int testcase = sc.nextInt();

			int max = Integer.MIN_VALUE;
			
			
			for(int r=0; r<100; r++) {
				for(int c=0; c<100; c++) {
					arr[r][c] = sc.nextInt();
				}
			}

			// 각 행의 합
			for (int r = 0; r < 100; r++) {
				int rsum = 0;
				for (int c = 0; c < 100; c++) {
					rsum += arr[r][c];
				}
				max = Math.max(max, rsum);
			}

			// 각 열의 합
			for (int c = 0; c < 100; c++) {
				int csum = 0;
				for (int r = 0; r < 100; r++) {
					csum += arr[r][c];
				}
				max = Math.max(max, csum);
			}

			
			
			// 대각선의 합

			int xsum = 0;
			int ysum = 0;
			for (int r = 0; r < 100; r++) {
				for (int c = 0; c < 100; c++) {
					if (r == c) {
						xsum += arr[r][c];
					}
					if(r+c==99) {
						ysum += arr[r][c];
					}
				}
			}

			if (max < Math.max(xsum, ysum))
				max = Math.max(xsum, ysum);

			
			
			System.out.println("#"+t+" "+max);
		}

	}

}
