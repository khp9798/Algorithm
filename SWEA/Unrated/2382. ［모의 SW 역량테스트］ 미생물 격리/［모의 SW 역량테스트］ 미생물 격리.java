import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Solution {

	static int N;
	static int M;
	static int K;

	static class Micro implements Comparable<Micro> {
		int r;
		int c;
		int cnt;
		int d;

		public Micro(int r, int c, int cnt, int d) {
			super();
			this.r = r;
			this.c = c;
			this.cnt = cnt;
			this.d = d;
		}

		@Override
		public String toString() {
			return "Micro [r=" + r + ", c=" + c + ", cnt=" + cnt + ", d=" + d + "]";
		}

		@Override
		public int compareTo(Micro o) {
			if (this.r != o.r) {
				return this.r - o.r;
			} else if (this.c != o.c) {
				return this.c - o.c;
			} else {
				return o.cnt-this.cnt;
			}
		}

	}

	/*
	 * 맵을 만든다 가려고 하는 길에 미생물이 있으면 서로 cnt를 비교하고 더 큰값의 direction을 따른다. cnt는 서로 더해서
	 * 합쳐진다.
	 * 
	 * if (nr==0 || nr==N-1 || nc==0 || nc==N-1) map[nr][nc] = cnt/2;
	 * 
	 * if (nr<0 || nr>=N || nc<0 || nc>=N) continue;
	 * 
	 */

	static int[] dr = { 0, -1, 1, 0, 0 };
	static int[] dc = { 0, 0, 0, -1, 1 };

	static List<Micro> micros;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int T = sc.nextInt();

		for (int t = 1; t <= T; t++) {
			// 셀의 크기
			N = sc.nextInt();

			micros = new ArrayList<>();

			// 걸리는 시간
			M = sc.nextInt();

			// 미생물의 개수
			K = sc.nextInt();

			for (int i = 0; i < K; i++) {
				int r = sc.nextInt();
				int c = sc.nextInt();
				micros.add(new Micro(r, c, sc.nextInt(), sc.nextInt()));

			}
			
			
			

			while (M != 0) {
				moveMicro();
				UnionMicro();
				M--;
			}

			int res = 0;
			
			
			for (int i = 0; i < micros.size(); i++) {
				res += micros.get(i).cnt;
			}

			System.out.println("#" + t + " " + res);
		}

	}

	static void moveMicro() {
		for (int i = 0; i < micros.size(); i++) {
			Micro m = micros.get(i);
			int d = m.d;

			int nr = m.r + dr[d];
			int nc = m.c + dc[d];

//			if (nr < 0 || nr >= N || nc < 0 || nc >= N)
//				continue;

			if (nr == 0 || nr == N - 1 || nc == 0 || nc == N - 1) {

				m.cnt /= 2;
				m.d = d % 2 == 1 ? d + 1 : d - 1;
				m.r = nr;
				m.c = nc;
				continue;
			}

			micros.set(i, new Micro(nr, nc, m.cnt, m.d));

		}

	}

	static void UnionMicro() {
		Collections.sort(micros);

		
		for (int i = 0; i < micros.size() - 1; i++) {
			Micro m1 = micros.get(i);
			Micro m2 = micros.get(i + 1);

			if (m1.r == m2.r && m1.c == m2.c) {
				int a = m1.cnt;
				int b = m2.cnt;
				micros.set(i, new Micro(m1.r, m1.c, m1.cnt + m2.cnt, a > b ? m1.d : m2.d));
				micros.remove(i + 1);
				i--;
			}
		}
	}

}
