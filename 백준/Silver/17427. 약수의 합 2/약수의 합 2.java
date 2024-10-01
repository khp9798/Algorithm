import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		
        
        	int N = Integer.parseInt(br.readLine());
        	
        	long res = 0;
        	
        	for(int i=1; i<=N; i++) {
        		res += i*(N/i);
        	}
        	bw.write(res+"\n");
        
        
        bw.flush();
		
	}

}
