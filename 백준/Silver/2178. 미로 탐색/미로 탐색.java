
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

	
	static int [][] map;
	
	//상하좌우
	static int [] dr = {-1,1,0,0};
	static int [] dc = {0,0,-1,1};
	
	//행의 길이
	static int N;
	
	//열의 길이
	static int M;
	
	
	static int[][] miro;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		//행의 길이
		N = Integer.parseInt(st.nextToken());
		
		//열의 길이
		M = Integer.parseInt(st.nextToken());
		
		map = new int[N][M];
		
		//miro 카운팅 배열을 만들어서 도착점에는 지금까지 얼마나 걸렸는지 나오게
		miro = new int[N][M];
		
		//map 내용 입력 받기
		for(int r=0; r<N; r++) {
			String[] str = br.readLine().split("");
			for(int c=0; c<M; c++) {
				map[r][c] = Integer.parseInt(str[c]);
			}
		}
		
		
		//최소거리를 구하기 때문에 bfs를 이용해야함.
		bfs(0,0);
		
		
		System.out.println(miro[N-1][M-1]);

	}
	
	static class point {
		int r;
		int c;
		
		
		public point(int r, int c) {
			super();
			this.r = r;
			this.c = c;
		}
		
	}
	
	static void bfs(int r, int c) {
		//bfs이기 때문에 queue 사용
		Queue<point> queue = new LinkedList<>();
		queue.add(new point(r, c));
		miro[r][c] = 1;
		
		while(!queue.isEmpty()) {
			point p = queue.poll();
			
			for(int d=0; d<4; d++) {
				int nr = p.r + dr[d];
				int nc = p.c + dc[d];
				
				//범위를 벗어나면 queue에다 안넣음
				if(0>nr || nr>=N || 0>nc || nc>=M) {
					continue;
				}
				
				//이미 방문 했거나 갈 수 없는 길이면 queue에 안넣음
				if(miro[nr][nc]!=0 || map[nr][nc] ==0) {
					continue;
				}
				
				queue.add(new point(nr,nc));
				miro[nr][nc] = miro[p.r][p.c] +1;
			}
		}
		
		
		
	}
}
