import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;


class Main{
	
	static Queue<Integer> q = new LinkedList<>();
	static int N;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(br.readLine());
		
		for(int i=1; i<=N; i++) {
			q.add(i);
		}
		
		
		while(q.size()!=1) {
			q.poll();
			
			
			int num = q.poll();
			
			q.add(num);
		}
		
		
		System.out.println(q.poll());
	}
}