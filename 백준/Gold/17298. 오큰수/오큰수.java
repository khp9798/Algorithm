

import java.util.*;
import java.io.*;

public class Main {

	static int n;
	static int[] arr;
	static Stack<Integer> stack = new Stack<>();

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		n = Integer.parseInt(br.readLine());

		arr = new int[n];

		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < n; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}

		int[] result = new int[n];
		
		for(int i=n-1; i>=0; i--) {
			while(!stack.isEmpty() && stack.peek() <= arr[i]) {
				stack.pop();
			}
			
			if(stack.isEmpty()) result[i] = -1;
			else {
				result[i] = stack.peek();
			}
			
			stack.add(arr[i]);
		}
		
		
		StringBuilder sb = new StringBuilder();
		for(int i = 0; i<n; i++) {
			sb.append(result[i]+" ");
		}

		System.out.println(sb.toString());
	}


}
