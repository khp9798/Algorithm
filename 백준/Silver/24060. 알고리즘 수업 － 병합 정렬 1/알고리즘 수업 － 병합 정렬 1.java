import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

	static int[] A;
	static int[] tmp;
	static int K;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine());

		int N = Integer.parseInt(st.nextToken());

		A = new int[N];
		tmp = new int[A.length];
		
		K = Integer.parseInt(st.nextToken());

		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			A[i] = Integer.parseInt(st.nextToken());
		}

		MergeSort(0, N - 1);

		System.out.println(res);

	}
	
	static int count = 0;
	static int res = -1;

	private static void MergeSort(int left, int right) {
		if (left < right) {
			int mid = (left + right) / 2;
			MergeSort(left, mid);
			MergeSort(mid + 1, right);
			Merge(left, mid, right);
		}

	}

	private static void Merge(int left, int mid, int right) {
		int L = left, R = mid + 1, idx = left;

		while (L <= mid && R <= right) {
			if (A[L] < A[R]) {
				tmp[idx++] = A[L++];
			} else {
				tmp[idx++] = A[R++];
			}
		}

		while (L <= mid) {
			tmp[idx++] = A[L++];
		}

		while (R <= right) {
			tmp[idx++] = A[R++];
		}

		for (int i = left; i <= right; i++) {
			A[i] = tmp[i];
			count++;
			if(count==K) {
				res = A[i];
			}
			
		}
	}

}