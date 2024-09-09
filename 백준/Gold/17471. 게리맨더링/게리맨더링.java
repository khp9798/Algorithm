import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;

public class Main {

	static int N;
	
	static int [] zone;
	
	static int [][] edges;
	
	static boolean [] visited;
	
	static boolean [] selected;
	
	static int res;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		N = sc.nextInt();
		
		zone = new int[N+1];
		
		edges = new int[N+1][N+1];
		
		selected = new boolean[N+1];
		
		
		
		//인구 수 입력
		for(int i=1; i<=N; i++) {
			zone[i] = sc.nextInt();
		}
		
		
		for(int i=1; i<=N; i++) {
			int cnt = sc.nextInt();
			
			for(int j=0; j<cnt; j++) {
				int to = sc.nextInt();
				
				edges[i][to] = 1;
				edges[to][i] = 1;
			}
		}
		
		
		res = Integer.MAX_VALUE;
		comb(1);
		
		
		
		System.out.println(res == Integer.MAX_VALUE ? -1 : res);
	}

	private static void comb(int idx) {
		if(idx==N+1) {
			List<Integer> TrueTeam = new ArrayList<>();
			List<Integer> FalseTeam = new ArrayList<>();
			
			for(int i=1; i<selected.length; i++) {
				if(selected[i]) TrueTeam.add(i);
				else FalseTeam.add(i);
			}
			
			
			if(TrueTeam.size()==0 || FalseTeam.size()==0) {
				return;
			}
			
			
			int A = check(TrueTeam, true);
			int B = check(FalseTeam, false);
			
			
			if(A!=-1 && B!=-1) {
				res = Math.min(res, Math.abs(A-B));
			}
			return;
		}
		
		
		selected[idx] = true;
		comb(idx+1);
		selected[idx] = false;
		
		comb(idx+1);
	}

	
	private static int check(List<Integer> Team, boolean b) {
		visited = new boolean[N+1];
		
		
		Queue<Integer> q = new LinkedList<>();
		q.add(Team.get(0));
		visited[Team.get(0)] = true;
		
		int cnt = 0;
		int people = 0;
		while(!q.isEmpty()) {
			int now = q.poll();
			
			cnt++;
			people+= zone[now];
			for(int i=1; i<=N; i++) {
				if(!visited[i] && selected[i] == b && edges[now][i] == 1) {
					q.add(i);
					visited[i]= true;
				}
			}
			
		}
		
		
		if(cnt==Team.size()) return people;
		else return -1;
	}

}
