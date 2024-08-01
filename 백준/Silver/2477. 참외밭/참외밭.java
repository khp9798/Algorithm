import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);

		int k = sc.nextInt();

		// 동서 중 최대값 저장
		int maxWidth = 0;
		// 남북 중 최대값 저장
		int maxHeight = 0;

		// 동서 중 최소값 저장
		int minWidth = 501;
		// 남북 중 최소값 저장
		int minHeight = 501;
		
		int[] direction = new int[6];
		int[] length = new int[6];
		

		for (int i = 0; i < 6; i++) {
			direction[i] = sc.nextInt();
			length[i] = sc.nextInt();

			if (direction[i] == 3 || direction[i] == 4) {
				if (maxHeight < length[i])
					maxHeight = length[i];
			} else {
				if (maxWidth < length[i])
					maxWidth = length[i];
			}

		}
		
		
		for(int i=5; i>=0; i--) {
			if(direction[i]==3 || direction[i]==4) {
				if(length[i]==maxHeight)
					if(i+3>5) {
						minWidth = length[i-3];
					}
					else {
						minWidth = length[i+3];
						
					}
					
			}else {
				if(length[i]==maxWidth) {
					if(i+3>5) {
						minHeight = length[i-3];
					}
					else {
						minHeight = length[i+3];
						
					}
				}
			}
		}
		
		int koreanmelon = ((maxWidth*maxHeight) - (minWidth*minHeight))*k;
		System.out.println(koreanmelon);

	}

}
