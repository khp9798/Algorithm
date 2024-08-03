import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		
		for(int i=0; i<4; i++) {
			int x1 = sc.nextInt();
			int y1 = sc.nextInt();
			int x2 = sc.nextInt();
			int y2 = sc.nextInt();
			
			int p1 = sc.nextInt();
			int q1 = sc.nextInt();
			int p2 = sc.nextInt();
			int q2 = sc.nextInt();
			
			
			//공통부분이 없을 때
			if(x2<p1 || y2<q1 || q2<y1 || p2<x1) {
				System.out.println("d");
			}
			//공통부분이 점일 때
			else if(x2==p1 && y2 == q1 || x2==p1 && y1==q2 || p2==x1 && y2==q1 || x1==p2 && y1==q2) {
				System.out.println("c");
			}
			//공통부분이 선분일 때
			else if((q1==y2 && p1<x2) || (q1==y2 && p1<x1) || (x2==p1 && q1<y1) || (x2==p1 && q1<y2) || (y1==q2 && p1<x1)
					|| (y1==q2 && p1<x2) || (x1==p2 && q1<y1) || (x1==p2 && q1<y2)) {
				System.out.println("b");
			}
			else {
				System.out.println("a");
			}
		}
	}

}
