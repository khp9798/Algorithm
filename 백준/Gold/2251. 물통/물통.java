import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

class Main {

	static boolean[][][] visited;
	static int[] bottle;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine());

		StringBuilder sb = new StringBuilder();

		visited = new boolean[201][201][201];

		bottle = new int[3];
		
		List<Integer> res = new ArrayList<>();

		// bottle[0] = a의 한계 , [1] = b의 한계 , [2] = c의 한계

		for (int i = 0; i < 3; i++) {
			bottle[i] = Integer.parseInt(st.nextToken());
		}

		Queue<int[]> q = new LinkedList<>();
		q.add(new int[] { 0, 0, bottle[2] });
		

		while (!q.isEmpty()) {
			int[] status = q.poll();

			// 했던 경우
			if (visited[status[0]][status[1]][status[2]])
				continue;
			visited[status[0]][status[1]][status[2]] = true;
			if (status[0] == 0)
				res.add(status[2]); // a가 비어있는 경우 출력

			// a에서 b,c에 넣는 경우

			// a에서 b에 넣기
			if (bottle[1] < status[0] + status[1]) {
				int[] arr = { status[0] + status[1] - bottle[1], bottle[1], status[2] };
				q.add(arr);
				//visited[status[0] + status[1] - bottle[1]][bottle[1]][status[2]] = true;
			}else {
				int [] arr = { 0 , status[0]+status[1], status[2]};
				q.add(arr);
			}
			
			
			//a에서 c넣기 
			if (bottle[2] < status[0] + status[2]) {
				int[] arr = { status[0] + status[2] - bottle[2], status[1], bottle[2] };
				q.add(arr);
				//visited[status[0] + status[2] - bottle[2]][status[1]][bottle[2]] = true;
			}else {
				int [] arr = { 0 , status[1], status[0]+status[2]};
				q.add(arr);
			}
			
			
			
			
			
			
			// b에서 a,c에 넣는 경우
			
			//b에서 a 넣기
			if (bottle[0] < status[0] + status[1]) {
				int[] arr = { bottle[0], status[1]+status[0]-bottle[0], status[2] };
				q.add(arr);
				//visited[status[0] + status[2] - bottle[2]][status[1]][bottle[2]] = true;
			}else {
				int [] arr = { status[0]+status[1] , 0, status[2]};
				q.add(arr);
			}
			
			//b에서 c 넣기
			if (bottle[2] < status[1] + status[2]) {
				int[] arr = { status[0], status[1]+status[2] - bottle[2], bottle[2] };
				q.add(arr);
				//visited[status[0] + status[2] - bottle[2]][status[1]][bottle[2]] = true;
			}else {
				int [] arr = { status[0] , 0, status[1]+status[2]};
				q.add(arr);
			}
			
			
			
			
	
			// c에서 a,b에 넣는 경우
			
			
			//c에서 a 넣는 경우
			if (bottle[0] < status[2] + status[0]) {
				int[] arr = { bottle[0], status[1], status[2]+status[0] -bottle[0] };
				q.add(arr);
				//visited[status[0] + status[2] - bottle[2]][status[1]][bottle[2]] = true;
			}else {
				int [] arr = { status[0]+status[2] , status[1], 0};
				q.add(arr);
			}
			
			
			//c에서 b 넣는 경우
			if (bottle[1] < status[2] + status[1]) {
				int[] arr = { status[0], bottle[1], status[2]+status[1] - bottle[1] };
				q.add(arr);
				//visited[status[0] + status[2] - bottle[2]][status[1]][bottle[2]] = true;
			}else {
				int [] arr = { status[0] , status[1]+status[2], 0};
				q.add(arr);
			}

		}
		
		Collections.sort(res);
		

		for (int num : res) {
			System.out.print(num+" ");
		}
	}
}