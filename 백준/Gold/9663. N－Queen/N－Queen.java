

import java.util.Scanner;

public class Main {

	
	//N이 주어졌을 때 NxN 체스판에서 퀸을 놓는 방법의 수 구하기
	static int N;
	
	
	//1차원 배열로 풀어보기
	static int [] board;
	
	static boolean [] visited;
	
	static int res = 0;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		N = sc.nextInt();
		
		board = new int[N];
		visited = new boolean[N];
		
		//0행부터 탐색 시작
		Queen(0);
		
		System.out.println(res);
	}

	private static void Queen(int row) {
		//행 끝까지 갔다면 경우의 수++
		if(row == N) {
			res ++;
			return;
		}
		
		
		//지금 행에서 가능한 열 찾기
		for(int col=0; col<N; col++) {
			//퀸이 공격할 수 없다면
			if(NoQueenAttack(row,col)) {
				//퀸 위치 저장
				board[row] = col;
				//해당 열의 퀸이 있다 체크
				visited[col] = true;
				//다음 행으로 이동
				Queen(row+1);
				//가다가 아닌 경우일 수 있으므로 백트래킹을 위해 체크 풀기
				visited[col] = false;
			}
		}
		
	}

	private static boolean NoQueenAttack(int row, int col) {
		//이미 그 열에 퀸이 있다면 false;
		if(visited[col]) return false;
		
		//지금까지의 퀸에 대각선 상에 없어야 한다.
		//대각선에 있다는 것은 0,0 2,2   row1-row2의 절댓값과 col1-col2의 절댓값이 같다.
		for(int r=0; r<row; r++) {
			if(Math.abs(row-r) == Math.abs(col-board[r])) return false;
		}
		
		return true;
	}
	
	
	

}
