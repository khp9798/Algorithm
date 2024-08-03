import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

	public static void main(String[] args) throws IOException {
		String[] Croatia = {"c=","c-","dz=","d-","lj","nj","s=","z="};
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String sb = br.readLine();

		
		
		
		int idx = 0;
		
		for(int i=0; i<Croatia.length; i++) {
			idx = sb.indexOf(Croatia[i]);
			if(idx>=0) {
				sb = sb.replaceAll(Croatia[i], "a");
			}
		}
		
		
		System.out.println(sb.length());
		
	}

}
