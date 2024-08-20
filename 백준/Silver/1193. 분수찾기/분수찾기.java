import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		//같은 대각선에 있는 수의 갯수는  분자 분모의 합-1;
		
		int num = sc.nextInt();
		
		int i=1;
		while(i*(i+1)/2 <num) {
			i++;
		}

		//분자 분모의 합
		int sum = i+1;
		
		//합이 sum인 대각선 라인에 숫자가 n~i*(i+1)/2 까지 있다.  숫자의 갯수는 i개
		//그렇다면 n은 i*i+1/2 -i +1
		
		int start  = i*(i+1)/2 -i+1;
		int end = i*(i+1)/2;
		
//		System.out.println(start+" "+end);
		
		//분자 분모 합이 홀수 일 때는 위에서 아래로
		//분자 분모 합이 짝수 일 때는 아래서 위로 진행방향
		if(sum%2!=0) {
			//분자 num-start+1
			System.out.println((num-start+1)+"/"+(sum-(num-start+1)));
		}else {
			//분자 end-num+1
			System.out.println((end-num+1)+"/"+(sum-(end-num+1)));
		}
		
	}

}
