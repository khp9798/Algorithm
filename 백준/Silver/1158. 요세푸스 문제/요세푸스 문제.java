import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

class Main{
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		StringBuilder sb = new StringBuilder();
		
		int N = Integer.parseInt(st.nextToken());
		
		int K = Integer.parseInt(st.nextToken());
		
		
		Queue<Integer> q = new LinkedList<>();
		
		for(int i=1; i<=N; i++) {
			q.add(i);
		}
		
		sb.append("<");
		
		int cnt = 0;
		while(!q.isEmpty()) {
			int num = q.poll();
			cnt++;
			if(cnt==K) {
				if(q.isEmpty()) {
					sb.append(num);					
				}
				else {
					sb.append(num+", ");					
					cnt=0;					
				}
			}else {
				q.add(num);
			}
		}
		sb.append(">");
		
		System.out.println(sb);
	}
}