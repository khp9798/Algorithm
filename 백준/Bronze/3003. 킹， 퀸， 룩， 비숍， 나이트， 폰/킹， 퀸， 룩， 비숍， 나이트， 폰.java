
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	// 킹 1개, 퀸 1개, 룩 2개, 비숍 2개, 나이트 2개, 폰 8개
	static int [] chess = {1,1,2,2,2,8};
	public static void main(String[] args) throws Exception {
		BufferedReader br=  new BufferedReader(new InputStreamReader(System.in));
		
		int[] mine = new int[6];
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i=0; i<mine.length; i++) {
			mine[i] = Integer.parseInt(st.nextToken());
		}
		
		int [] answer = new int[6];
		
		for(int i=0; i<answer.length; i++) {
			answer[i] = chess[i] - mine[i];
			System.out.print(answer[i]+" ");
		}

	}

}
