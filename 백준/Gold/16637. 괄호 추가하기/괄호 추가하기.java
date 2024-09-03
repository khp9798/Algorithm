import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

	static int N;
	
	static List<Integer> nums = new ArrayList<>();
	static List<Character> operator = new ArrayList<>();
	

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		N = sc.nextInt();


		String str = sc.next();
		for (int i = 0; i < N; i++) {
			if(i%2==0) {
				nums.add(str.charAt(i)-'0');
			}else {
				operator.add(str.charAt(i));
			}
		}

		

		dfs(0,nums.get(0));
		
		System.out.println(res);
	}

	static int res = Integer.MIN_VALUE;
	static void dfs(int operatorIdx, int answer) {
		if(operatorIdx==operator.size()) {
			res = Math.max(res, answer);
			return;
		}
		
		
		int cal1 = cal(answer,operator.get(operatorIdx),nums.get(operatorIdx+1));
		dfs(operatorIdx+1,cal1);
		
		if(operatorIdx+2 <= operator.size()) {
			int cal2 = cal(answer,operator.get(operatorIdx),cal(nums.get(operatorIdx+1),operator.get(operatorIdx+1),nums.get(operatorIdx+2)));
			dfs(operatorIdx+2,cal2);
		}
		
	}

	
	private static int cal(int A, int oper, int B) {
		if (oper == '+') {
			return A + B;
		}
		else if (oper == '*') {
			return A * B;
		}
		else if (oper == '-') {
			return A - B;
		}
		return 0;
		
		
	}

}
