import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	static String w = "WBWBWBWB";
	static String b = "BWBWBWBW";

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine());

		int m = Integer.parseInt(st.nextToken());
		int n = Integer.parseInt(st.nextToken());

		char[][] map = new char[m][n];

		for (int r = 0; r < m; r++) {
			String[] str = br.readLine().split("");

			for (int c = 0; c < n; c++) {
				map[r][c] = str[c].charAt(0);
			}
		}

		int min = Integer.MAX_VALUE;
		for (int i = 0; i <= m - 8; i++) {
			for (int j = 0; j <= n - 8; j++) {
				int cntw = 0;
				int cntb = 0;
				for (int r = 0; r < 8; r++) {
					int mapr = r+i;
					for (int c = 0; c < 8; c++) {
						int mapc = c+j;
						//w 시작
						if(r%2==0 && w.charAt(c) == map[mapr][mapc]) {
							cntw++;
						}
						if(r%2 == 1 && b.charAt(c) == map[mapr][mapc]) {
							cntw++;
						}
						if(r%2==0 && b.charAt(c) == map[mapr][mapc]) {
							cntb++;
						}
						if(r%2 == 1 && w.charAt(c) == map[mapr][mapc]) {
							cntb++;
						}
					}
				}
				min = min > Math.min(cntw, cntb) ? Math.min(cntw, cntb) : min;
			}
		}

		System.out.println(min);
	}

}
