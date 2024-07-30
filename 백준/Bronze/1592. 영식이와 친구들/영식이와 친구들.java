import java.util.*;
import java.io.*;

public class Main {

	public static void main(String[] args) throws Exception{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

		int N = Integer.parseInt(st.nextToken());

		int M = Integer.parseInt(st.nextToken());

		int L = Integer.parseInt(st.nextToken());

		int[] count = new int[N + 1];

		// 일단 1번자리 사람이 공을 받고 시작하기 때문에 1로 초기화
		count[1] = 1;
		int num = 1;
		int cnt = 0;

		while (true) {
			if (count[num] == M)
				break;
			if (count[num] % 2 == 1) {
				num = num + L;
				if (num > N)
					num = num - N;
			} else {
				num = num - L;
				if (num < 1)
					num = num + N;
			}

			count[num]++;
			cnt++;

		}

		System.out.println(cnt);

	}

}
