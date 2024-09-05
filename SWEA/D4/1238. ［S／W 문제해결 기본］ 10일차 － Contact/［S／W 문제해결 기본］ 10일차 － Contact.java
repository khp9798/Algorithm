
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;

public class Solution {

	static int[][] rel;
	static boolean[] visited;
	static int maxcnt;
	static int maxnum;
	static List<Node> nodes;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		for (int t = 1; t <= 10; t++) {
			rel = new int[101][101];
			visited = new boolean[101];
			maxcnt = 0;
			maxnum = 0;
			nodes = new ArrayList<>();

			// 데이터 길이
			int N = sc.nextInt();

			// 시작점
			int Start = sc.nextInt();

			for (int i = 0; i < N / 2; i++) {
				int A = sc.nextInt();
				int B = sc.nextInt();

				rel[A][B] = 1;
			}

			bfs(Start);

			int res = 0;
			for (int i = 0; i < nodes.size(); i++) {
				if (nodes.get(i).cnt == maxcnt) {
					maxnum = Math.max(maxnum, nodes.get(i).num);
				}
			}

			System.out.println("#" + t + " " + maxnum);
		}

	}

	static class Node {
		int num;
		int cnt;

		public Node(int num, int cnt) {
			super();
			this.num = num;
			this.cnt = cnt;
		}

		@Override
		public String toString() {
			return "Node [num=" + num + ", cnt=" + cnt + "]";
		}

	}

	private static void bfs(int start) {
		Queue<Node> queue = new LinkedList();
		queue.add(new Node(start, 0));
		visited[start] = true;

		while (!queue.isEmpty()) {
			Node n = queue.poll();

			int num = n.num;
			int cnt = n.cnt;

			if (maxcnt <= cnt) {
				maxcnt = cnt;
			}

			for (int i = 1; i <= 100; i++) {
				if (!visited[i] && rel[num][i] == 1) {
					visited[i] = true;
					queue.add(new Node(i, cnt + 1));
					nodes.add(new Node(i, cnt + 1));
				}
			}
		}

	}

}
