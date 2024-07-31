import java.util.Arrays;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);

		int[] dwarf = new int[9];
		
		int sum=0;
		
		
		//난쟁이 키 입력받음,  9난쟁이 키 합 
		for(int i=0; i<dwarf.length; i++) {
			dwarf[i] = sc.nextInt();
			sum+=dwarf[i];
		}
		
		Arrays.sort(dwarf);
		int fakedwarf1 = 0;
		int fakedwarf2 = 0;
		
		for(int i=0; i<dwarf.length; i++) {
			for (int j=i+1; j<dwarf.length; j++) {
				if(sum-dwarf[i]-dwarf[j]==100) {
					fakedwarf1 = dwarf[i];
					fakedwarf2 = dwarf[j];
				}
			}
		}
		
		for(int i=0; i<dwarf.length; i++) {
			if(!(dwarf[i] == fakedwarf1 || dwarf[i] == fakedwarf2))
				System.out.println(dwarf[i]);
		}
	}

}
