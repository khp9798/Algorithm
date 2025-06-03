import java.util.*;
import java.io.*;

public class Main {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine());

		// 배열 a의 크기
		int n = Integer.parseInt(st.nextToken());

		// 배열 b의 크기
		int m = Integer.parseInt(st.nextToken());

		int[] a = new int[n];

		int[] b = new int[m];

		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < n; i++) {
			a[i] = Integer.parseInt(st.nextToken());
		}

		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < m; i++) {
			b[i] = Integer.parseInt(st.nextToken());
		}

		int aPoint = 0, bPoint = 0;

		StringBuilder sb = new StringBuilder();

		while (aPoint < n && bPoint < m) {
			if (a[aPoint] < b[bPoint]) {
				sb.append(a[aPoint] + " ");
				aPoint++;
			} else if (a[aPoint] > b[bPoint]) {
				sb.append(b[bPoint] + " ");
				bPoint++;
			} else {
				sb.append(a[aPoint] + " ");
				aPoint++;
			}
		}

		if (aPoint < n) {
			for (int i = aPoint; i < n; i++) {
				sb.append(a[i] + " ");
			}
		} else if (bPoint < m) {
			for (int i = bPoint; i < m; i++) {
				sb.append(b[i] + " ");
			}

		}

		System.out.println(sb.toString());

	}

}
