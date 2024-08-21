import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

	
	//256(=245+2+4+5)이 된다. 따라서 245는 256의 생성자가 된다. 
	
	//자연수 N이 주어졌을 때, N의 가장 작은 생성자를 구해내는 프로그램
	
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(br.readLine());
		
		
		int i = 0;
		
		while(true) {
			int sum=0;
			
			
			int num = i;
			sum+=num;
			
			while(num/10>0) {
				sum+=num%10;
				num/=10;
			}
			sum+=num%10;
			
			
			if(sum==n) {
				System.out.println(i);
				break;
			}
			if(i>n) {
				System.out.println(0);
				break;
			}
			i++;
		}
		
		
	}

}
