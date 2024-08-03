import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int num = sc.nextInt();

		int total = 0;
		
		boolean[][] arr = new boolean[101][101];
		
		for(int i=0; i<num; i++) {
			int x=sc.nextInt();
			int y=sc.nextInt();
			
			for(int j=x; j<x+10; j++ ) {
				for(int k=y; k<y+10; k++) {
					if(!arr[k][j]) {
						arr[k][j] = true;
					}
				}
			}
		}
		
		int [] dr = {1,0};
		int [] dc = {0,1};
		for(int i=0;i<arr.length;i++){
	         for(int j=0;j<arr.length;j++){
	 
	            for(int d=0;d<2;d++){
	               int ni = i+dr[d];
	               int nj = j+dc[d];
	 
	               if(ni>=0 && ni<=100 && nj>=0 && nj<=100 && arr[i][j] != arr[ni][nj]) total++;
	            }
	 
	         }
	      }

		

		System.out.println(total);

	}

}
