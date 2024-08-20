import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int a = sc.nextInt();
		
		while(a!=-1) {
			List<Integer> list = new ArrayList<>();
			
			for(int i=1; i<a; i++) {
				if(a%i==0) {
					list.add(i);
				}
			}
			
			int sum=0;
			for(int i=0; i<list.size(); i++) {
				sum+=list.get(i);
			}
			
			if(a==sum) {
				System.out.print(a+" = ");
				for(int i=0; i<list.size(); i++) {
					if(i==list.size()-1) {
						System.out.println(list.get(i));
					}
					else {
						System.out.print(list.get(i)+" + ");
					}
				}
			}else {
				System.out.println(a+" is NOT perfect.");
			}
			
			a=sc.nextInt();
		}
		
	}

}
