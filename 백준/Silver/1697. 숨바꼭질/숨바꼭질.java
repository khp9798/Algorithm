
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

	static int [] road = new int[100001];
	static boolean [] visited = new boolean[100001];
	static class soobin{
		int x;
		int cnt;
		public soobin(int x, int cnt) {
			super();
			this.x = x;
			this.cnt = cnt;
		}
		
		
	}
	public static void main(String[] args) throws Exception {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		//수빈이 위치
		int p1 = Integer.parseInt(st.nextToken());
		
		//동생 위치
		int p2 = Integer.parseInt(st.nextToken());
		
		
		bfs(p1,p2,0);
		
		System.out.println(result);
	}
	
	static int result = 0;
	static void bfs(int start, int end,int cnt) {
		Queue<soobin> queue = new LinkedList<>();
		queue.add(new soobin(start,cnt));
		visited[start] = true;
		
		while(!queue.isEmpty()) {
			//현재 위치
			soobin sb = queue.poll();
			
			
			if(sb.x==end) {
				result = sb.cnt;
				return;
			}
			
			if(sb.x+1 < 100001 && !visited[sb.x+1]) {
				visited[sb.x+1] = true;
				queue.add(new soobin(sb.x+1,sb.cnt+1));				
			}
			if(sb.x-1 >=0 && !visited[sb.x-1]) {
				visited[sb.x-1] = true;
				queue.add(new soobin(sb.x-1,sb.cnt+1));
				
			}
			
			if(sb.x*2 <100001 && !visited[sb.x*2]) {
				visited[sb.x*2] = true;
				queue.add(new soobin(sb.x*2,sb.cnt+1));				
			}
			
		}
		
	}

}
