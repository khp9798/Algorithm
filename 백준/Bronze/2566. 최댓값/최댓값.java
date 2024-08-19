

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st;

		int[][] a = new int[9][9];

		
		int max = Integer.MIN_VALUE;
		int maxr=0;
		int maxc=0;
		for (int r = 0; r < 9; r++) {
			st = new StringTokenizer(br.readLine());
			for (int c = 0; c < 9; c++) {
				a[r][c] = Integer.parseInt(st.nextToken());
				if(max<a[r][c]) {
					max = a[r][c];
					maxr=r;
					maxc=c;
				}
			}
		}

		
		System.out.println(max);
		System.out.println((maxr+1)+" "+(maxc+1));
	}

}
