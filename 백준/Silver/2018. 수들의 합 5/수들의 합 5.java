import java.util.*;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		// 연속된 자연수의 합으로 나타 내야할
		int n = sc.nextInt();

		// 시작 값 (자연수의 합이니까 무조건 1부터 시작
		int start = 1;

		// 종료 값 (n이 1일 수도 있음.)
		int end = 1;

		// 자연수의 합은 무조건 1부터 시작하므로 최소가 1
		int sum = 1;

		// 자기 자신으로 나타낼 수 있으므로 시작이 1
		int answer = 1;

		while (end != n) {
			if (sum < n) {
				end++;
				sum += end;
			} else if (sum > n) {
				sum -= start;
				start++;
			} else {
				answer++;
				end++;
				sum += end;
			}
		}

		System.out.println(answer);

	}

}
