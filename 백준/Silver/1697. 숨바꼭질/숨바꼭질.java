
import java.util.*;
import java.io.*;

public class Main {

	static Queue<Integer> q = new LinkedList<>();
	static int[] dist;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine());

		int n = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());

		dist = new int[200000];

		q.add(n);
		Arrays.fill(dist, -1);
		dist[n] = 0;

		while (!q.isEmpty()) {
			int curr = q.poll();

			if (curr == k) {
				System.out.println(dist[curr]);
				return;
			}

			int[] nx = new int[] { curr + 1, curr - 1, curr * 2 };

			for (int num : nx) {
				addQ(num, dist[curr]);
			}
		}

	}

	static void addQ(int idx, int count) {
		if (idx < 0 || idx >= 200000)
			return;
		else if (dist[idx] >= 0)
			return;

		dist[idx] = count + 1;
		q.add(idx);
	}

}
