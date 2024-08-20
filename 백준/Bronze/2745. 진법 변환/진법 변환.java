import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		String str = st.nextToken();
		
		int n = Integer.parseInt(st.nextToken());
		
		
		int sum=0;
		for(int i=str.length()-1; i>=0; i--) {
			char c = str.charAt(i);
			
			if('0'<=c && c<='9') {
				sum+=(c-'0')*Math.pow(n, Math.abs(i-(str.length()-1)));
			}
			else {
				sum+=((c-'A')+10)*Math.pow(n, Math.abs(i-(str.length()-1)));
			}
		}
		
		System.out.println(sum);

	}

}
