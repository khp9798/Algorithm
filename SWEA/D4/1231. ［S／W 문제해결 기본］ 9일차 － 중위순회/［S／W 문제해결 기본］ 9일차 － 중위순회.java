

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
	static int Nodesize = 0;
	public static class Node{
		int number;
		char data;
		int left;
		int right;
		
		
		public Node(int number, char data, int left, int right) {
			super();
			this.number = number;
			this.data = data;
			this.left = left;
			this.right = right;
		}

	}
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		
		
		for(int t=1; t<=10; t++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			//노드의 수
			int N = Integer.parseInt(st.nextToken());
			
			Node[] nodes = new Node[N+1];
			for(int i=1; i<N+1; i++) {
				st = new StringTokenizer(br.readLine());
				
				int num = Integer.parseInt(st.nextToken());
				char data = st.nextToken().charAt(0);
				int left=-1;
				int right=-1;
				if(st.countTokens()>=1) {
					left = Integer.parseInt(st.nextToken());
				}
				
				if(st.countTokens()==1) {
					right = Integer.parseInt(st.nextToken());					
				}
				
				nodes[i] = new Node(num,data,left,right);
				
//				System.out.println(i + " "+nodes[i].data+" "+nodes[i].left+" "+nodes[i].right);
				Nodesize++;
			}
			
			
			inorder(1,nodes);
			System.out.println("#"+ t+answer);
			
			answer=" ";
		}
		
		

	}

	static String answer = " ";
	//중위순회
	//L V R
	public static void inorder(int rootidx,Node[] nodes) {
		if(rootidx>= nodes.length) {
			return;
		}
		if((nodes[rootidx].left == -1 && nodes[rootidx].right == -1)) {
			answer+=nodes[rootidx].data;
			return;
		}
		inorder(rootidx*2,nodes);
		answer+=nodes[rootidx].data;
		inorder(rootidx*2+1,nodes);
	}
}
