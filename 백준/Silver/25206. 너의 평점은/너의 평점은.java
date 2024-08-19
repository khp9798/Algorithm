

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		
		double sum=0;
		double scoresum=0;
		for(int i=0; i<20; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			
			String name = st.nextToken();
			
			double score = Double.parseDouble(st.nextToken());
			
			
			
			
			String rank = st.nextToken();
			
			if(rank.equals("A+")) {
				sum+=score*4.5;
				scoresum+=score;
			}
			else if(rank.equals("A0")) {
				sum+=score*4.0;
				scoresum+=score;
			}
			else if(rank.equals("B+")) {
				sum+=score*3.5;
				scoresum+=score;
			}
			else if(rank.equals("B0")) {
				sum+=score*3.0;
				scoresum+=score;
			}
			else if(rank.equals("C+")) {
				sum+=score*2.5;
				scoresum+=score;
			}
			else if(rank.equals("C0")) {
				sum+=score*2.0;
				scoresum+=score;
			}
			else if(rank.equals("D+")) {
				sum+=score*1.5;
				scoresum+=score;
			}
			else if(rank.equals("D0")) {
				sum+=score*1.0;
				scoresum+=score;
			}
			else if(rank.equals("F")) {
				sum+=score*0.0;
				scoresum+=score;
			}
		}
		
		System.out.println(sum/scoresum);
	}

}
