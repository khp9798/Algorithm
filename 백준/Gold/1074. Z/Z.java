
import java.util.*;

public class Main {

	static int N,r,c;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		N = sc.nextInt();
		r = sc.nextInt();
		c = sc.nextInt();
		
		
		System.out.println(z(r,c,N));
	}
	
	static int z(int row, int col, int level) {
		if(level==0) return 0;
		
		int half = 1<<(level-1);
		
		if(row<half && col<half) return z(row,col,level-1);
		if(row<half && col>=half) return half*half+z(row,col-half,level-1);
		if(row>=half && col<half) return 2*half*half+z(row-half,col,level-1);
		return 3*half*half+z(row-half,col-half,level-1);
	}

}
