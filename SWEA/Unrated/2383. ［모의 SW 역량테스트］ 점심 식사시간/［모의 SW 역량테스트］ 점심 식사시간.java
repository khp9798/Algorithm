
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Solution {

	static int N; 
	
	static int [][] map;
	
	static class Point{
		int r;
		int c;
		int distance;
		public Point(int r, int c) {
			super();
			this.r = r;
			this.c = c;
		}
		
	}
	
	
	static List<Point> person;
	static Point[] stairs;
	static boolean [] visited;
	
	

	
	static int res;
	
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int T = sc.nextInt();
		
		for(int t=1; t<=T; t++) {
			N = sc.nextInt();
			
			map = new int[N][N];
			person = new ArrayList<>();
			stairs = new Point[2];
			
			int idx=0;
			for(int r=0; r<N; r++) {
				for(int c=0; c<N; c++) {
					map[r][c] = sc.nextInt();
					if(map[r][c]==1) {
						person.add(new Point(r,c));
					}
					else if(map[r][c]>=2) {
						stairs[idx++] = new Point(r,c);
					}
				}
			}
			
			visited = new boolean[person.size()];
			
			
			res = Integer.MAX_VALUE;
			
			comb(0);
			
			System.out.println("#"+t+" "+res);
		}
		
		

	}
	
	
	private static void comb(int idx) {
		if(idx==person.size()) {
			//true면 계단 1, false면 계단 2로 간다.
			goStair();
			return;
		}
		
		
		visited[idx] = true;
		comb(idx+1);
		visited[idx] = false;
		
		comb(idx+1);
		
	}
	
	
	static List<Integer> timeTrue;
	static List<Integer> timeFalse;
	
	
	static void goStair() {

		
		timeTrue = new ArrayList<>();
		timeFalse = new ArrayList<>();
		
		for(int i=0; i<person.size(); i++) {
			if(visited[i]) {
				int distanceTrue =  Math.abs(person.get(i).r - stairs[0].r)+ Math.abs(person.get(i).c - stairs[0].c)+1;
				timeTrue.add(distanceTrue);

			}
			else {
				int distanceFalse = Math.abs(person.get(i).r - stairs[1].r)+ Math.abs(person.get(i).c - stairs[1].c)+1;
				timeFalse.add(distanceFalse);
			}
		}
		
		
		Collections.sort(timeTrue);
		Collections.sort(timeFalse);
		
		
		downStair();

	
	}
	
	
	
	private static void downStair() {
		
		for(int i=0; i<timeTrue.size(); i++) {
			if(i/3<1) {
				timeTrue.set(i,timeTrue.get(i)+map[stairs[0].r][stairs[0].c]);
			}else {
				if(timeTrue.get(i-3)>timeTrue.get(i)) {
					timeTrue.set(i, timeTrue.get(i-3)+map[stairs[0].r][stairs[0].c]);
				}
				else {
					timeTrue.set(i, timeTrue.get(i)+map[stairs[0].r][stairs[0].c]);
				}
			}
		}
		
		
		for(int i=0; i<timeFalse.size(); i++) {
			if(i/3<1) {
				timeFalse.set(i,timeFalse.get(i)+map[stairs[1].r][stairs[1].c]);
			}else {
				if(timeFalse.get(i-3)>timeFalse.get(i)) {
					timeFalse.set(i, timeFalse.get(i-3)+map[stairs[1].r][stairs[1].c]);
				}
				else {
					timeFalse.set(i, timeFalse.get(i)+map[stairs[1].r][stairs[1].c]);
				}
			}
		}
		
		
		if(timeTrue.size()==0 && timeFalse.size()!=0) {
			res = Math.min(res, timeFalse.get(timeFalse.size()-1));
		}
		else if(timeFalse.size()==0 && timeTrue.size()!=0) {
			res = Math.min(res, timeTrue.get(timeTrue.size()-1));
		}
		else {
			if(timeTrue.get(timeTrue.size()-1) > timeFalse.get(timeFalse.size()-1)) {
				res = Math.min(res, timeTrue.get(timeTrue.size()-1));
			}else {
				res = Math.min(res, timeFalse.get(timeFalse.size()-1));
			}
		}
		
	}
	
	

}
