import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int num = Integer.parseInt(st.nextToken());
		
		int n = Integer.parseInt(st.nextToken());
		
		
		List<Integer> list = new ArrayList<>();
		while(num/n!=0) {
			list.add(num%n);
			num = num/n;
		}

		list.add(num%n);
		for(int i = list.size()-1; i>=0; i--){
			if(list.get(i)>=10) {
				char c = (char) ('A'+(list.get(i) - 10));
				System.out.print(c);
			}else {
				System.out.print(list.get(i));				
			}
		}
	}
	
	
}
