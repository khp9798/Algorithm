import java.util.*;
import java.io.*;

public class Main {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		StringTokenizer st = new StringTokenizer(br.readLine());

		// 수의 개수
		int n = Integer.parseInt(st.nextToken());

		int L = Integer.parseInt(st.nextToken());

		Deque<Num> deq = new ArrayDeque<>();

		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < n; i++) {
			int num = Integer.parseInt(st.nextToken());

			while (!deq.isEmpty() && deq.getLast().num > num) {
				deq.removeLast();
			}

			deq.addLast(new Num(i, num));

			if (deq.getFirst().idx <= i - L) {
				deq.removeFirst();

			}
			bw.write(deq.getFirst().num + " ");
		}
		
		bw.flush();
		br.close();
		bw.close();

	}

	static class Num {
		int idx;
		int num;

		Num(int idx, int num) {
			this.idx = idx;
			this.num = num;
		}
	}

}
