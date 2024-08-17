
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	static int[][] relation;
	static boolean[] visited;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		// 사람의 수 입력
		int N = Integer.parseInt(br.readLine());

		// 사람 사이 관계 정보를 저장할 배열 초기화
		relation = new int[N + 1][N + 1];
		
		//방문 했는지 안했는지 검증 위한 boolean 배열
		visited = new boolean[N+1];

		// 계산해야할 두 사람의 번호 입력
		StringTokenizer st = new StringTokenizer(br.readLine());
		int p1 = Integer.parseInt(st.nextToken());
		int p2 = Integer.parseInt(st.nextToken());

		// 관계의 개수
		int edge = Integer.parseInt(br.readLine());
		// 관계 입력 받기
		for (int i = 0; i < edge; i++) {
			st = new StringTokenizer(br.readLine());
			int parent = Integer.parseInt(st.nextToken());
			int child = Integer.parseInt(st.nextToken());

			// 관계가 있으면 1로 표시
			relation[parent][child] = 1;
			relation[child][parent] = 1;
		}

		
		//특정 구간에 관계를 알아야하기 때문에 dfs 사용
		dfs(p1,p2,0);
		
		System.out.println(result);
	}

	static int result=-1;
	static void dfs(int start, int end, int cnt) {
		if(start==end) {
			result = cnt;
			return;
		}
		
		visited[start] = true;
		
		for(int i=0; i<relation.length; i++) {
			if(relation[start][i]==1 && !visited[i]) {
				dfs(i,end,cnt+1);
			}
		}
	}
}
