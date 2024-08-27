import java.util.Scanner;

public class Main {

	static int K;
	static int[] arr;
	static boolean[] visited;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		//고른 수 의 개수
		K = sc.nextInt();

		while(K!=0) {
			arr = new int[K];
			visited = new boolean[K];
			
			for(int i=0; i<K; i++) {
				arr[i] = sc.nextInt();
			}
			
			
			//kC6을 할거임
			
			comb(0,0);
			System.out.println();
			K= sc.nextInt();
		}
		

	}

	static void comb(int start,int depth) {
		if(depth==6) {
			for(int i=0; i<visited.length; i++) {
				if(visited[i]) {
					System.out.print(arr[i]+" ");
				}
			}
			System.out.println();
			return;
		}
		if(start>=K) {
			return;
		}
		
		
		
		visited[start] = true;
		comb(start+1,depth+1);
		visited[start] = false;
		comb(start+1,depth);
		
	}
	
	

}
