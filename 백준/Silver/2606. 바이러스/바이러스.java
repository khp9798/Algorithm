
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	static int Node;
	static int edge;
	// 바이러스의 연결 관계
	static int[][] virus;
	static boolean[] virustrue;

	public static void main(String[] args) throws Exception, Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		// 컴퓨터의 수
		Node = Integer.parseInt(br.readLine());

		// 연결의 수
		edge = Integer.parseInt(br.readLine());

		// 바이러스 연결 관계
		virus = new int[Node + 1][Node + 1];
		
		//바이러스가 걸렸는지 안걸렸는지
		virustrue = new boolean[Node+1];

		StringTokenizer st;
		for (int i = 0; i < edge; i++) {
			st = new StringTokenizer(br.readLine());
			int start = Integer.parseInt(st.nextToken());

			int end = Integer.parseInt(st.nextToken());

			virus[start][end] = 1;
			virus[end][start] = 1;
		}

		dfs(1);
		
		//1번 컴퓨터는 뺴야됨
		System.out.println(cnt-1);
	}
	
	//바이러스가 걸린 컴퓨터 수
	static int cnt=0;
	
	static void dfs(int start) {
		//일단 시작할 때 자기 자신은 바이러스가 걸림
		virustrue[start] = true;
		cnt++;
		
		for(int i=1; i<Node+1; i++) {
			//연결이 되어있거나 방문을 안한 컴퓨터를 센다.
			if(virus[start][i] == 1 && !virustrue[i]) {
				dfs(i);
			}
		}
	}

}
