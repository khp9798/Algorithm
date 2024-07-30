import java.util.Scanner;

public class Main {

	static int cnt=0;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);

		int N = sc.nextInt();

		int M = sc.nextInt();

		int L = sc.nextInt();

		int[] count = new int[N];

		// 일단 1번자리 사람이 공을 받고 시작하기 때문에 1로 초기화
		count[0] = 1;

		playball(count, 0, L, M);

		System.out.println(playball(count, 0, L, M));

	}

	static int playball(int[] count, int idx, int L, int M) {
		for (int i = 0; i < count.length; i++) {
			if (count[i] == M)
				break;
			else {
				cnt++;
				if (count[idx] % 2 == 1) {
					// 시계방향으로 2칸 이동했을 때 배열의 크기를 넘는다면
					if (idx + L > count.length - 1) {
						count[L - (count.length - 1 - idx) - 1]++;
						return playball(count, L - (count.length - 1 - idx) - 1, L, M);
					}
					// 넘지 않는 경우
					else {
						count[idx + L]++;
						return playball(count, idx + L, L, M);
					}
				} else {
					if (idx - L < 0) {
						count[count.length - 1 - (L - idx - 1)]++;
						return playball(count, count.length - 1 - (L - idx - 1), L, M);

					} else {
						count[idx - L]++;
						return playball(count, idx - L, L, M);
					}
				}

			}
		}
		return cnt;

	}

}
