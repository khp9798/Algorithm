

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

	
	static boolean [] visited;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int a = Integer.parseInt(st.nextToken());
		int b = Integer.parseInt(st.nextToken());

		visited = new boolean[b+1];
		
		bfs(a,b);
		
		System.out.println(res);
	}

	
	static class num{
		long data;
		int cnt;
		public num(long data, int cnt) {
			super();
			this.data = data;
			this.cnt = cnt;
		}
		
		
	}
	
	static int res = -1;
	static void bfs(int start, int end) {
		Queue<num> queue = new LinkedList<>();
		queue.add(new num(start,0));
		
		
		while(!queue.isEmpty()) {
			num num = queue.poll();
			
			long data = num.data;
			
			int cnt = num.cnt;
			
			if(data == end) {
				res = cnt+1;
				return;
			}else if(data>end) {
				
			}else {
				queue.add(new num(data*10+1,cnt+1));
				queue.add(new num(data*2,cnt+1));
			}
			
			
		}
		
		
	}

}
