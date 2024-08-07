import java.util.Arrays;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		//색종이의 갯수
		int N = sc.nextInt();
		
		//평면
		int [][] map = new int[1001][1001];
		
		
		for(int num=1; num<=N; num++) {
			//x가 col값 , y가 row 값
			int x = sc.nextInt();
			int y = sc.nextInt();
			
			
			//가로 세로 길이 값
			int width = sc.nextInt();
			int height = sc.nextInt();

			
			for(int r=map.length-1-y; r>(map.length-1-y)-height; r--) {
				for(int c=x; c<x+width; c++) {
					map[r][c] = num;
				}
			}
			
			
		}
		
		int[] count = new int[N+1];
		
		for ( int r=0; r<map.length; r++) {
			for (int c=0; c<map.length; c++) {
				if(map[r][c]!=0) {
					count[map[r][c]]++;
				}
			}
		}
		
		for(int i=1; i<count.length; i++) {
			System.out.println(count[i]);
		}
		
		
		
	}

}
