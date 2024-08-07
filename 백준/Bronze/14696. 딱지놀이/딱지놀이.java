import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		//총 라운드 수
		int N = sc.nextInt();
		
		//라운드 수 만큼 반복
		for(int t=0; t<N; t++) {
			//a가 가진 그림의 개수
			int a = sc.nextInt();
			
			int[] countA = new int[5];
			
			for(int i=0; i<a; i++) {
				countA[sc.nextInt()]++;
			}
			
			//b가 가진 그림의 개수
			int b = sc.nextInt();
			
			int[] countB = new int[5];
			
			for(int i=0; i<b; i++) {
				countB[sc.nextInt()]++;
			}
			
			
			for(int i=countA.length-1; i>=0; i--) {
				if(countA[i]==countB[i]) {
					if(i==0) {
						System.out.println("D");
					}else {
						continue;						
					}
				}
				else if(countA[i]>countB[i]) {
					System.out.println("A");
					break;
				}
				else {
					System.out.println("B");
					break;
				}
			}
		}

	}

}
