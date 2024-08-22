import java.util.Arrays;
import java.util.Scanner;

public class Solution {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int T = sc.nextInt();

		for (int t = 1; t <= T; t++) {
			
			int [] arr = new int[10];
			for(int i=0; i<10; i++) {
				arr[i] = sc.nextInt();
			}
			
			Arrays.sort(arr);
			
			double sum=0;
			for(int i=1; i<9; i++) {
				sum+=arr[i];
			}
			System.out.printf("#%d %.0f\n",t,sum/8);
		}

	}

}
