import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Solution {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		

		int T = Integer.parseInt(br.readLine());
		for (int t = 1; t <= T; t++) {

			Queue<String> queue1 = new LinkedList<String>();
			Queue<String> queue2 = new LinkedList<>();
			
			
			int N = Integer.parseInt(br.readLine());
			StringTokenizer st = new StringTokenizer(br.readLine());
			
			for(int i=1; i<=N/2+N%2; i++) {
				queue1.add(st.nextToken());
			}
			
			for(int i=N/2+N%2+1; i<=N; i++) {
				queue2.add(st.nextToken());
			}
			
			
			System.out.print("#"+t);
			for(int i=0; i<N/2; i++) {
				System.out.print(" "+queue1.poll());
				System.out.print(" "+queue2.poll());
			}
			
			if(N%2==1) {
				System.out.println(" "+queue1.poll());
			}else {
				System.out.println();
			}
			
			
			
			
		}

	}

}
