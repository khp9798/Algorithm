import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


public class Main {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int n = Integer.parseInt(br.readLine());
		
		
		
		int maxx = Integer.MIN_VALUE;
		int minx = Integer.MAX_VALUE;
		int maxy = Integer.MIN_VALUE;
		int miny = Integer.MAX_VALUE;
		for(int i=0; i<n; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			
			int x = Integer.parseInt(st.nextToken());
			
			int y = Integer.parseInt(st.nextToken());
			
			
			if(maxx<x) {
				maxx=x;
			}
			if(maxy<y) {
				maxy=y;
			}
			if(minx>x) {
				minx=x;
			}
			if(miny>y) {
				miny=y;
			}
		}
		
		System.out.println((maxx-minx)*(maxy-miny));
	}

}
