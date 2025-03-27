import java.util.*;
import java.io.*;


public class Main {
	
	static int[][] arr;
	
	static int white;
	
	static int blue;
	
	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(br.readLine());
		
		arr = new int[n][n];
		
		for(int i=0; i<n; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int j=0; j<n; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		
		divide(0,0,n);
		
		System.out.println(white);
		System.out.println(blue);
	}
	
	
	static void divide(int r, int c, int size) {
		
		if(check(r,c,size)) {
			if(arr[r][c] == 0) white++;
			else blue++;
			
			return;
		}
		
		
		divide(r,c,size/2);
		divide(r,c+size/2, size/2);
		divide(r+size/2, c, size/2);
		divide(r+size/2, c+size/2, size/2);
		
	}
	
	
	static boolean check(int r, int c, int size) {
		
		for(int i=r; i<r+size; i++) {
			for(int j=c; j<c+size; j++) {
				if(arr[i][j] != arr[r][c]) {
					return false;
				}
			}
		}
		
		return true;
	}

}
