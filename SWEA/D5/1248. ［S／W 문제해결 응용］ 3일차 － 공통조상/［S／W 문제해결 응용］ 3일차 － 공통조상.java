

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Solution {

	static int treecnt = 0;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int T = sc.nextInt();

		for (int t = 1; t <= T; t++) {
			// 노드의 갯수
			int V = sc.nextInt();

			// 간선의 갯수
			int E = sc.nextInt();

			// 공통 조상을 찾는 두개의 노드 번호
			int a = sc.nextInt();
			int b = sc.nextInt();

			// tree 구현
			int[][] tree = new int[2][V + 1];

			// 이 방식이면 자식 노드의 순서가 달라질 수 있다.
			// 입력이 비어있는 노드를 세지 않고 번호를 매겼기 때문
			// 그러나 공통 조상을 찾는 알고리즘이기 때문에 상관없을 듯하다
			for (int i = 0; i < E; i++) {
				int parent = sc.nextInt();
				int child = sc.nextInt();

				// 부모 왼쪽 아래 있는 자식이라는 뜻
				if (tree[0][parent] == 0) {
					tree[0][parent] = child;
				}
				// 부모 오른쪽 아래 있는 자식이라는 뜻
				else {
					tree[1][parent] = child;
				}
			}
//			System.out.println(Arrays.deepToString(tree));
			List<Integer> josangnodealist = new ArrayList<>();
			List<Integer> josangnodeblist = new ArrayList<>();

			int josangnodea = a;
			int josangnodeb = b;

			
			int c = V;
			while(josangnodea!=1 || josangnodeb!=1) {
				if(c<1) {
					c=V;
				}
				int left = tree[0][c];
				int right = tree[1][c];
				if (left == josangnodea || right == josangnodea) {
					josangnodealist.add(c);
					josangnodea = c;
//					System.out.println(josangnodea);
				}
				
				if (left == josangnodeb || right == josangnodeb) {
					josangnodeblist.add(c);
					josangnodeb = c;
				}
				else {
					c--;					
				}
			}




//			System.out.println(josangnodealist);
//			System.out.println(josangnodeblist);

			int sameparent = 0;
			int parenta=0;
			int parentb=0;
			out : for (int i = 0; i < josangnodealist.size(); i++) {
				for (int j = 0; j < josangnodeblist.size(); j++) {
					parenta = josangnodealist.get(i);
					parentb = josangnodeblist.get(j);				
					if (parenta == parentb) {
						sameparent = parenta;
						break out;
					}
				}
			}
			System.out.print("#"+t);
			System.out.print(" "+sameparent);


			// 중위 순회하면서 트리 크기 구함.
			preOrder(sameparent, tree);

			System.out.println(" "+treecnt);
			
			//초기화
			treecnt=0;
		}

	}

	public static void preOrder(int x, int[][] tree) {
		if (x!=0 && tree[0][x] == 0 && tree[1][x] == 0) { // 왼쪽 자식이나 오른쪽 자식이 없다면 (0이라면) 순회X
			// 자기자신은 세고
			treecnt++;
			return;
		}
		// 노드의 자식이 한쪽만 있는 경우는 자식이 있는 쪽만 세야하므로 조건절 추가
		else if(x!=0){
			treecnt++;

			preOrder(tree[0][x], tree);

			preOrder(tree[1][x], tree);

		}
	}

}
