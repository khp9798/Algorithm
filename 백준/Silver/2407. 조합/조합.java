import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.StringTokenizer;

public class Main {
	
	static int N;
	static int M;
	static int max = 100;
	static BigInteger [][] arr = new BigInteger[max+1][max+1];
	
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		
		M = Integer.parseInt(st.nextToken());
		
		comb_dp();

		System.out.println(arr[N][M]);
	}

	private static void comb_dp() {
		//nC0 == 1 nCn == 1
		for(int i=0; i<=max; i++) {
			arr[i][0] = new BigInteger("1");
			arr[i][i] = new BigInteger("1");
		}
		
		
		
		//nCr = n-1Cr-1 + n-1Cr
		
		for(int i=1; i<=max; i++) {
			for(int j=1; j<i; j++) {
				arr[i][j] = arr[i-1][j-1].add(arr[i-1][j]);
			}
		}
		
	}

	

}