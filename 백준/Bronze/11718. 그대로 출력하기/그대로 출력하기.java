import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

	// a부터 z까지 26
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		String a  = br.readLine();
		while(a!=null) {
			System.out.println(a);
			a = br.readLine();
		}
		

	}

}
