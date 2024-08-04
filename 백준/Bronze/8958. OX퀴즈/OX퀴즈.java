import java.util.Arrays;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int T = sc.nextInt();
		
		for(int t=0; t<T; t++) {
			String str = sc.next();
			
			
			int[] arr = new int[str.length()];
			for(int i=0; i<str.length(); i++) {
				if(str.charAt(i) == 'O') {
					arr[i] = 1;
				}
			}
			
			
			for(int i=0; i<arr.length; i++) {
				if(arr[i]==0) {
					continue;
				}else {
					if(i==0) {
						arr[i] = 1;
					}else {
						arr[i] = arr[i-1]+arr[i];						
					}
				}
			}
			
			int sum=0;
			for(int i=0; i<arr.length; i++) {
				sum+=arr[i];
			}
			
			System.out.println(sum);
		}

	}

}
