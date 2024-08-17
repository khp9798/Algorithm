import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		//스위치의 갯수
		int N = Integer.parseInt(br.readLine());
		
		//스위치 상태를 저장할 배열  0번 인덱스는 안씀
		int[] sw = new int[N+1];
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		//스위치 상태 입력 받기
		for(int i=1; i<N+1; i++) {
			sw[i] = Integer.parseInt(st.nextToken());
		}
		
		
		//학생 수 입력
		int studentcnt = Integer.parseInt(br.readLine());
		
		for(int s=0; s<studentcnt; s++) {
			st = new StringTokenizer(br.readLine());
			
			int gender = Integer.parseInt(st.nextToken());
			int num = Integer.parseInt(st.nextToken());
			
			//남자라면
			if(gender==1) {
				for(int i=num; i<N+1; i+=num) {
					sw[i] = sw[i] == 1 ? 0:1;
				}
			}
			//여자라면 num으로 받은 번호 중심으로 양 옆이 대칭이 아닐 때까지 간다.
			else {
				//일단 num은 바꿔야됨
				sw[num] = sw[num] == 1? 0:1;
				
				//탐색범위
				int a=1;
				while(1<=num-a && num+a<N+1&& sw[num-a]==sw[num+a]) {
					sw[num-a] = sw[num-a] == 1? 0:1;
					sw[num+a] = sw[num+a] == 1? 0:1;
					a++;
				}
			}
			
			
			
		}
		
		for(int i=1; i<N+1; i++) {
			System.out.print(sw[i]+" ");
			if(i%20==0) {
				System.out.println();
			}
		}
	}

}
