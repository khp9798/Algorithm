

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class Solution {
	static class Node{
		int num;
		String data;
		int left;
		int right;
		public Node(int num, String data, int left, int right) {
			super();
			this.num = num;
			this.data = data;
			this.left = left;
			this.right = right;
		}
		
		
	}
	
	static Stack<Integer> calculate = new Stack<>();
	
	
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		for(int t=1; t<=10; t++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			
			//노드의 개수
			int N = Integer.parseInt(st.nextToken());
			
			Node[] nodes = new Node[N+1];
			for(int i=1; i<=N; i++) {
				st = new StringTokenizer(br.readLine());
				
				int num = Integer.parseInt(st.nextToken());
				String data = st.nextToken();
				int left = -1;
				int right = -1;
				if(st.countTokens()>=1) {
					left = Integer.parseInt(st.nextToken());
				}
				if(st.countTokens()==1) {
					right = Integer.parseInt(st.nextToken());
				}
				
				nodes[i] = new Node(num, data, left, right);
				
				
			}
			
			postorder(1, nodes);
			

			System.out.println("#"+t+" "+calculate.pop());
		}

	}
	

	//L R V 후위순회를 할거임
	public static void postorder(int rootidx, Node[] nodes) {
		if(rootidx>= nodes.length) {
			return;
		}
		if((nodes[rootidx].left == -1 && nodes[rootidx].right == -1)) {
			//어차피 말단 노드는 숫자기 때문에 판별 안해줘도 된다.
			calculate.add(Integer.parseInt(nodes[rootidx].data));	

			return;
		}
		//완전 이진 트리가 아니기 때문에 매개변수를 left , right로 해줬다.
		postorder(nodes[rootidx].left,nodes);
		postorder(nodes[rootidx].right,nodes);
		String data = nodes[rootidx].data;
		if(possibleint(data)) {
			calculate.add(Integer.parseInt(data));
		}else {
			int b = 0;
			int a = 0;
			int result=0;
			switch(data) {
			case "/":
				b = calculate.pop();
				a = calculate.pop();
				result = a/b;
				calculate.add(result);
				break;
			case "+":
				b = calculate.pop();
				a = calculate.pop();
				result = a+b;
				calculate.add(result);
				break;
			case "-":
				b = calculate.pop();
				a = calculate.pop();
				result = a-b;
				calculate.add(result);
				break;
			case "*":
				b = calculate.pop();
				a = calculate.pop();
				result = a*b;
				calculate.add(result);
				break;
			}
		}
	}
	
	//data를 int로 바꿀 수 있는지 없는지 판단 함수
	public static boolean possibleint(String data) {
		try {
			Integer.parseInt(data);
			return true;
		}catch(NumberFormatException e){
			return false;
		}
	}

}
