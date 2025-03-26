import java.util.*;
import java.io.*;


public class Main {

	static int n;
	
	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		n = Integer.parseInt(br.readLine());
		
		PriorityQueue<Integer> pq = new PriorityQueue<>();
		
		StringBuilder sb = new StringBuilder();
		
		for(int i=0; i<n; i++) {
			int num = Integer.parseInt(br.readLine());
			
			if(num==0) {
				if(pq.isEmpty()) sb.append(0).append("\n");
				else sb.append(pq.poll()).append("\n");
			}
			else {
				pq.add(num);
			}
		}
		
		
		System.out.println(sb.toString());
	}

}
