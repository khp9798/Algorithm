import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

	// . : 무조건 이동 가능
	// # : 절대 이동 불가능
	// "abcdef" : 열쇠
	// "ABCDEF" : 문 (같은 문자의 열쇠가 있다면 문열고 갈 수 있음)
	// 0 : 민식이의 현재 위치
	// 1 : 미로 탈출구

	// 움직임은 상하좌우가능.

	// 미로를 탈출하는 걸리는 이동 횟수의 최솟값을 구함
	// BFS

	// 열쇠를 매개변수에 배열로 받아서 처리하면 될 것 같음.

	// 세로 크기
	static int N;

	// 가로 크기
	static int M;

	static char[][] map;

	static String keys = "abcdef";
	static String doors = "ABCDEF";
	static boolean[][][] visited;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());

		M = Integer.parseInt(st.nextToken());

		map = new char[N][M];
		visited = new boolean[N][M][64];

		for (int r = 0; r < N; r++) {
			String str = br.readLine();
			for (int c = 0; c < M; c++) {
				map[r][c] = str.charAt(c);
			}
		}

		out: for (int r = 0; r < N; r++) {
			for (int c = 0; c < M; c++) {
				if (map[r][c] == '0') {
					map[r][c] = '.';
					bfs(r, c);
					break out;
				}
			}
		}

		System.out.println(res);

	}

	static class Person {
		int r;
		int c;
		int length;
		int keys;

		public Person(int r, int c, int length, int keys) {
			super();
			this.r = r;
			this.c = c;
			this.length = length;
			this.keys = keys;
		}

	}

	static int[] dr = { -1, 1, 0, 0 };
	static int[] dc = { 0, 0, -1, 1 };

	static int res=-1;

	static void bfs(int r, int c) {
		Queue<Person> queue = new LinkedList<>();
		queue.add(new Person(r, c, 0, 0));
		visited[r][c][0] = true;

		while (!queue.isEmpty()) {
			Person p = queue.poll();

			int length = p.length;
			int key = p.keys;

			

			
			

			for (int d = 0; d < 4; d++) {
				int nr = p.r + dr[d];
				int nc = p.c + dc[d];

				if (0 <= nr && nr < N && 0 <= nc && nc < M && map[nr][nc] != '#' && !visited[nr][nc][key]) {

					// 그냥 갈 수 있는 길일 때
					if (map[nr][nc] == '.') {
                        visited[nr][nc][key]=true;
						queue.add(new Person(nr, nc, length + 1, key));
					}
					
					// 열쇠를 만났을 때
					else if (keys.contains(map[nr][nc] + "")) {

						int addKey = key | 1<<(map[nr][nc] - 'a');

						if (!visited[nr][nc][addKey]) {
                            visited[nr][nc][addKey]=true;
							queue.add(new Person(nr, nc, length + 1, addKey));
						}

					}

					// 문을 만났을 때
					else if (doors.contains(map[nr][nc] + "")) {

						if ((key & 1<<(map[nr][nc] - 'A')) >0) {
//							int currKey = key ^ 1<<(map[nr][nc] - 'A');
							if(!visited[nr][nc][key]) {
                                visited[nr][nc][key]=true;
								queue.add(new Person(nr, nc, length + 1, key));
							}

						}

					}
					
					else if(map[nr][nc] == '1' ) {
						res = length+1;
						return;
					}

				}
				
			}
		}

	}

}