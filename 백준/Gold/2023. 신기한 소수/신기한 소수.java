import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	// 세로 크기
	static int N;

	static int Start = 1;
	static int End = 1;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());

		End = (int) (End * Math.pow(10, N)) - 1;

		Sosu(2,1);
		Sosu(3,1);
		Sosu(5,1);
		Sosu(7,1);
		
		
	}

	static boolean res = false;

	static int [] a = {2,3,5,7};
	static int [] last = {1,3,5,9};
	
	static void Sosu(int num, int jaricnt) {

		if(jaricnt == N) {
			if(isPrime(num)) {
				System.out.println(num);
			}
		}

		for(int i=1; i<=9; i+=2) {
			if(isPrime(num*10+i)) {
				Sosu(num*10+i,jaricnt+1);
			}
		}
		
	}
	
	static boolean isPrime(int num) {
		for(int i=2; i<num; i++) {
			if(num%i==0) {
				return false;
			}
		}
		
		return true;
	}
}