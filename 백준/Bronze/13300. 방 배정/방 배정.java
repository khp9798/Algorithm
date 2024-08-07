import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		//학생 수 
		int N = sc.nextInt();
		
		//한 방에 배정할 수 있는 최대 인원 수
		int k = sc.nextInt();
		
		//col은 성별 row는 학년
		int[][] student = new int[7][2];
		
		for(int i=0; i<N; i++) {
			//성별 입력
			int s = sc.nextInt();
			
			//학년 입력
			int y = sc.nextInt();
			
			student[y][s]++;
		}
		
		
		//방 갯수 세기
		int count=0;
		for(int r=0; r<student.length; r++) {
			for(int c=0; c<student[0].length; c++) {
				count+=student[r][c]/k;
				if(student[r][c]%2!=0) {
					count++;
				}
			}
		}
		
		System.out.println(count);

	}

}
