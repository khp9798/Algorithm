

import java.util.*;

public class Main {
	
	static int[] arr;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		
		arr = new int[sc.nextInt()];
		
		for(int i=0; i<arr.length ;i++) {
			arr[i] = sc.nextInt();
		}
		
		
		for(int i=arr.length-1; i>=0; i--) {
			for(int j=0; j<i; j++) {
				buble(j);
			}
		}
		
		
		for(int i=0; i<arr.length; i++) {
			System.out.println(arr[i]);
		}
	}
	
	
	public static void buble(int idx) {
		if(arr[idx] > arr[idx+1]) {
			int temp = arr[idx+1];
			arr[idx+1] = arr[idx];
			arr[idx] = temp;
		}
		
//		System.out.println(Arrays.toString(arr));
	}

}
