import java.util.Arrays;
import java.util.Scanner;

public class Main {

	public static void main(String[] args){
		
		
		Scanner sc = new Scanner(System.in);
		
		int[] nums = new int[10];
		int[] nummod = new int[10];
		
		for(int i=0; i<nums.length; i++) {
			nums[i] = sc.nextInt();
			nummod[i] = nums[i]%42;
		}
		
		
		Arrays.sort(nummod);
		int cnt=0;
		for(int i=0; i<nummod.length-1; i++) {
			if(nummod[i] != nummod[i+1])
				cnt++;
		}
		
		System.out.println(cnt+1);
		

	}

}
