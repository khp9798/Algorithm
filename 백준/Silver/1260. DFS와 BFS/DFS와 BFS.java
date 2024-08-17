import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

	
	//노드들의 연결관계를 저장핧 map
	static int [][] map;
	//노드를 방문했는지 안했는지 확인할 visited
	static boolean [] visitedDfs;
	static boolean [] visitedBfs;
	
	
	public static void main(String[] args) throws IOException {
		BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		//정점의 개수
		int N = Integer.parseInt(st.nextToken());
		
		//간선의 개수
		int M = Integer.parseInt(st.nextToken());
		
		
		//탐색을 시작할 정점의 번호
		int V = Integer.parseInt(st.nextToken());
		
		
		map = new int[N+1][N+1];
		visitedDfs = new boolean[N+1];
		visitedBfs = new boolean[N+1];
		
		//노드들의 관계 입력 받기
		for(int i=0; i<M; i++) {
			st = new StringTokenizer(br.readLine());
			
			int start = Integer.parseInt(st.nextToken());
			
			int end = Integer.parseInt(st.nextToken());
			
			
			//간선이 양방향이기 때문에 1->2면 2->1인 것
			map[start][end] = 1;
			map[end][start] = 1;
		}
		
		dfs(V);
		System.out.println();
		bfs(V);
	}

	
	//시작할 정점 번호를 입력받는 dfs 메소드 생성
	static void dfs(int start) {
		//일단 처음 자기자신 방문했으니
		visitedDfs[start] = true;
		System.out.print(start+" ");
		
		//지금 노드에서 갈 수 있는 노드들을 탐색
		for(int i=1; i<map.length; i++) {
			//연결이 되어있고 아직 안간 곳으로 가야됨
			if(map[start][i]==1 && !visitedDfs[i]) {
				dfs(i);
			}
		}
	}
	
	
	//시작할 정점 번호를 입력 받는 bfs 메소드 생성
	static void bfs(int start) {
		Queue<Integer> queue = new LinkedList<>();
		queue.add(start);
		
		
		while(!queue.isEmpty()) {
			//현재 노드 번호
			int node = queue.poll();
			visitedBfs[node] = true;
			System.out.print(node+" ");
			for(int i=1; i<map.length; i++) {
				if(map[node][i]==1 && !visitedBfs[i]) {
					queue.add(i);
					visitedBfs[i] = true;
				}
			}
		}
	}
}
