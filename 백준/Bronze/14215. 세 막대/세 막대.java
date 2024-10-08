import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;


public class Main {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		
		int [] arr = new int[3];
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i=0; i<3; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		Arrays.sort(arr);
		
		if(arr[0]+arr[1]>arr[2]) {
			System.out.println(arr[0]+arr[1]+arr[2]);
		}else {
			System.out.println((arr[0]+arr[1])*2-1);
		}
		
	}

}
