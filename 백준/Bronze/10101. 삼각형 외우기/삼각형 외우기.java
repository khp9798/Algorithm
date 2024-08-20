import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class Main {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		
		int [] arr = new int[3];
		
		boolean Equilateral = true;
		int sum=0;
		for(int i=0; i<3; i++) {
			arr[i] = Integer.parseInt(br.readLine());	
			if(arr[i]!=60) {
				Equilateral = false;
			}
			sum+=arr[i];
		}
		
		
		if(Equilateral) {
			System.out.println("Equilateral");
		}
		else {
			boolean Isosceles = false;
			if(sum!=180) {
				System.out.println("Error");
			}
			else {
				for(int i=0; i<3; i++) {
					for(int j=0; j<3; j++) {
						if(i!=j && arr[i]==arr[j]) {
							Isosceles = true;
						}
					}
				}
				
				
				System.out.println(Isosceles ? "Isosceles" : "Scalene");
			}
		}
		
		
	}

}
