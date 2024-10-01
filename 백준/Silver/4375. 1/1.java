import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
        while(sc.hasNextInt()){
            int N = sc.nextInt();
		
		long num=1;
		int count=1;
		while(true) {
			if(num%N==0) {
				System.out.println(count);
				break;
			}
			else {
				count++;
				num = num*10+1;
				num%=N;
			}
		}
        }
		
	}

}
