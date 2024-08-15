import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class  Solution{

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		// N의 배수들을 String으로 받고, 배수들을 받을 때마다 1~9까지 카운팅배열 ++

		int T = Integer.parseInt(br.readLine());

		for (int t = 1; t <= T; t++) {

			int N = Integer.parseInt(br.readLine());

			// 1~9까지 카운팅 배열 0은 비운다.
			int[] count = new int[10];

			// 카운팅 배열이 모두 1이상이 될 때 종료됨

			int a=1;
			while (true) {
				String str = (N * a) + "";
				for (int j = 0; j < str.length(); j++) {
					char c = str.charAt(j);
					count[c - '0']++;
				}
				if(count[0] >=1 && count[1] >= 1 && count[2] >=1 && count[3] >=1 && count[4] >=1 &&
					count[5] >=1 && count[6] >=1 && count[7] >=1 && count[8] >=1 &&
					count[9] >=1) {
					break;
				}
				a++;
			}
			
//			System.out.println(Arrays.toString(count));
			System.out.println("#"+t+" "+N*a);
		}

	}

}
