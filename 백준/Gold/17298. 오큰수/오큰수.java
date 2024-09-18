import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int n = Integer.parseInt(br.readLine());

		int[] arr = new int[n];

		int[] res = new int[n];

		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < n; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}

		Stack<Integer> stack = new Stack<>();
		for (int i = 0; i < n; i++) {

			while (!stack.isEmpty() && arr[stack.peek()] < arr[i]) {
				res[stack.pop()]=arr[i];
			}
			stack.add(i);

			
		}

		StringBuilder sb = new StringBuilder();
		for(int i=0; i<n; i++) {
			if(res[i]==0) {
				sb.append(-1+" ");
			}else {
				sb.append(res[i]+" ");				
			}
		}

		System.out.println(sb.toString());
	}
}
