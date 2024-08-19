import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int[] student = new int[31];
		
		for(int i=0; i<28; i++) {
			int num = Integer.parseInt(br.readLine());
			student[num] = 1;
		}

		
		for(int i=1; i<31; i++) {
			if(student[i] !=1) {
				System.out.println(i);
			}
		}
	}

}
