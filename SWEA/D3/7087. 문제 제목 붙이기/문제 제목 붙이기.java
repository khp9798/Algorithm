import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Solution {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int n = Integer.parseInt(br.readLine());

		for (int t = 1; t <= n; t++) {
			int T = Integer.parseInt(br.readLine());

			int[] arr = new int[T];

			StringTokenizer st;
			for (int i = 0; i < T; i++) {
				st = new StringTokenizer(br.readLine());
				arr[i] = st.nextToken().charAt(0);
			}

			// 65~90 A~Z
			Arrays.sort(arr);

//			System.out.println(Arrays.toString(arr));

			int cnt = 0;
			
			for (int i = 1; i < T; i++) {
				if (arr[i] - arr[i - 1] == 1) {
					cnt++;
				} else if (arr[i - 1] == arr[i]) {
					continue;
				} else {
					break;
				}

			}

			
			if (arr[0] == 65) {
				cnt++;
			}else {
				cnt=0;
			}
			System.out.println("#" + t + " " + cnt);
			
			cnt=0;
		}

	}

}
