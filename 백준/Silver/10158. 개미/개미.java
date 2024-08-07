import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        // 격자 공간의 크기
        int w = Integer.parseInt(st.nextToken());
        int h = Integer.parseInt(st.nextToken());

        // 현재 있는 좌표
        st = new StringTokenizer(br.readLine());
        int p = Integer.parseInt(st.nextToken());
        int q = Integer.parseInt(st.nextToken());

        // 걸린 시간
        int t = Integer.parseInt(br.readLine());
        
        p = w-Math.abs(w-(p+t)%(w*2));
        q = h-Math.abs(h-(q+t)%(h*2));
        
        
        System.out.println(p+" "+q);

	}

}
