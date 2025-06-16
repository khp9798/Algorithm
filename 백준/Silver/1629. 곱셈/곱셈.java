import java.util.*;

public class Main {

	// 수가 21억이라 직접 곱하면 무조건 시간복잡도가 터진다.

	// 1승을 계산할 수 있다.
	// k승을 계산했으면 2k승과 2k+1승도 o(1)에 계산할 수 있다.

	static long a, b, c;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		a = sc.nextLong();
		b = sc.nextLong();
		c = sc.nextLong();

		System.out.println(mul(a, b, c));
	}

	static long mul(long a, long b, long c) {
		if (b == 1)
			return a % c; // a가 c보다 클 수 있기 때문에 c로 나눠줌.

		long val = mul(a, b / 2, c);
		val = val * val % c;

		if (b % 2 == 0)
			return val;

		return val * a % c;
	}

}
