import java.util.Arrays;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		// 스위치 갯수 입력 받기
		int N = sc.nextInt();
		int[] switch1 = new int[N];

		// 스위치 상태 입력 받기
		for (int i = 0; i < switch1.length; i++) {
			switch1[i] = sc.nextInt();
		}

		// 학생 수 입력 받기
		int studentnum = sc.nextInt();

		// 학생 수만큼 스위치 변경 활동함.
		for (int i = 0; i < studentnum; i++) {

			// 학생의 성별과 받은 수 입력
			int gender = sc.nextInt();
			int getnum = sc.nextInt();

			// 성별이 1이면 남자, 2이면 여자

			// 성별이 남자일 때
			if (gender == 1) {
				for (int j = 0; j < switch1.length; j++) {
					if ((j + 1) % getnum == 0) {
						switch1[j] = switch1[j] == 1 ? 0 : 1;

					}
				}
			}
			// 성별이 여자일 때
			else {

				// 좌우 탐색 인덱스 자기자신으로 초기화
				int leftidx = getnum - 1;
				int rightidx = getnum - 1;

				// 자기 자신은 좌우가 대칭이든 아니든 바꾸니까 일단 바꿈
				switch1[leftidx] = switch1[leftidx] == 1 ? 0 : 1;

				// 좌우 탐색하는 범위는 아무리 커도 배열크기의 반보다 작음.
				for (int j = 1; j < switch1.length / 2; j++) {

					// 좌우 탐색하는데 범위를 넘어사면 break;
					if (rightidx + j >= switch1.length || leftidx - j < 0)
						break;

					// 좌우 탐색했는데 대칭일 때
					if (switch1[leftidx - j] == switch1[rightidx + j]) {
						switch1[leftidx - j] = switch1[leftidx - j] == 1 ? 0 : 1;
						switch1[rightidx + j] = switch1[rightidx + j] == 1 ? 0 : 1;
					}
					// 대칭이 아닐 때
					else
						break;

				}

			}
		}

		// 한 줄에 20개씩 출력
		for (int i = 0; i < switch1.length; i++) {
			System.out.print(switch1[i] + " ");
			if ((i + 1) % 20 == 0)
				System.out.println();
		}
	}
}