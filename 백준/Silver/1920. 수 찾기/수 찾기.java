import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

class Main{
	
	static int N;
	static int [] A;

	static int M;
	
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(br.readLine());
		
		A = new int[N];
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		for(int i=0; i<N; i++) {
			A[i] = Integer.parseInt(st.nextToken());
		}
		
		Arrays.sort(A);
		
		M = Integer.parseInt(br.readLine());
		
		st = new StringTokenizer(br.readLine());
		
		for(int i=0; i<M; i++) {
			int num = Integer.parseInt(st.nextToken());
			
			binarySearch(0,N-1,num);
			
		}
	}
	
	
	static void binarySearch(int left, int right, int num) {
		int mid = (left+right)/2;
		
		if(A[mid]==num) {
			System.out.println(1);
			return;
		}
		if(left<right) {
			if(A[mid]>num) {
				binarySearch(left,mid-1,num);							
			}
			else {
				binarySearch(mid+1,right,num);
			}
		}
		
		else {
			System.out.println(0);
			return;
		}
		
	}
}