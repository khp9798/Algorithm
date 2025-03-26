import java.util.*;
import java.io.*;


public class Main {

	static int n;
	static int m;
	
	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		
		m = Integer.parseInt(st.nextToken());
		
		List<Integer> arr = new ArrayList<>();
		
		st = new StringTokenizer(br.readLine());
		for(int i=0; i<n; i++) {
			arr.add(Integer.parseInt(st.nextToken()));
		}
		
		int [] sum = new int[n+1];
		
		for(int i=1; i<=n; i++) {
			sum[i] = sum[i-1]+arr.get(i-1);
		}
		
		
		StringBuilder sb = new StringBuilder();
		
		
		for(int i=0; i<m; i++) {
			st = new StringTokenizer(br.readLine());
			
			int start = Integer.parseInt(st.nextToken());
			
			int end = Integer.parseInt(st.nextToken());
			
			sb.append(sum[end]-sum[start-1]).append("\n");
		}
		
		System.out.println(sb.toString());
	}

}
