import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main{
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int M = Integer.parseInt(br.readLine());
		
		StringBuffer sb = new StringBuffer();
		int set = 0;
		for (int i = 0; i < M; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			String command = st.nextToken();
			
			int input = -1;
			switch(command) {
			case "add":
				input = Integer.parseInt(st.nextToken());
				set = set | (1 << input);
				break;
			case "remove":
				input = Integer.parseInt(st.nextToken());
				set = set & ~(1 << input);
				break;
			case "check":
				input = Integer.parseInt(st.nextToken());
				sb.append(((set & (1 << input)) > 0) ? "1\n" : "0\n");
				break;
			case "toggle":
				input = Integer.parseInt(st.nextToken());
				set = set ^ (1 << input);
				break;
			case "all":
				set = (1 << 21) - 1;
				break;
			case "empty":
				set = 0;
				break;
			}
		}
		System.out.print(sb.toString());
	}
}