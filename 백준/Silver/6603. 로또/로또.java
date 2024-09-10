
import java.util.Scanner;


class Main {

	static int N;

	static boolean[] select;
	static int[] num;
	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		while ((N = sc.nextInt()) != 0) {
			num = new int[N];

			for (int i = 0; i < N; i++) {
				num[i] = sc.nextInt();

			}
			select = new boolean[N];
			
			
			dfs(0,0);
			System.out.println();
		}


	}

	private static void dfs(int idx,int depth) {
		if(depth==6) {
			for(int i=0; i<N; i++) {
				if(select[i]) {
					System.out.print(num[i]+" ");
				}
			}
			System.out.println();
			return;
		}
		
		
		for(int i=idx; i<N; i++) {
			if(!select[i]) {
				select[i] = true;
				dfs(i,depth+1);
				select[i] = false;
			}
		}
	}

}