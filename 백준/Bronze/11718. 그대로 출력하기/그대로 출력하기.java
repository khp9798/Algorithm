import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

	// a부터 z까지 26
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		String a ;
		while((a= br.readLine())!=null) {
			System.out.println(a);
			
		}
		br.close();
		

	}

}
