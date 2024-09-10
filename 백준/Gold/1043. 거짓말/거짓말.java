import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Main {

	static int N;

	static int M;

	static int[] truePerson;

	static List<Integer>[] party;

	static int[] p;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		N = sc.nextInt();

		M = sc.nextInt();

		p = new int[N + 1];

		truePerson = new int[sc.nextInt()];

		for (int i = 0; i < truePerson.length; i++) {
			truePerson[i] = sc.nextInt();
		}

		party = new ArrayList[M];

		for (int i = 0; i < M; i++) {
			party[i] = new ArrayList<>();
		}

		for (int i = 0; i < M; i++) {
			int cnt = sc.nextInt();

			for (int j = 0; j < cnt; j++) {
				party[i].add(sc.nextInt());
			}
		}
		
		

		for (int i = 1; i <= N; i++) {
			p[i] = i;
		}

		for (int i = 0; i < truePerson.length; i++) {
			Union(truePerson[0],truePerson[i]);
		}

		for (int i = 0; i < M; i++) {
			for (int j = 1; j < party[i].size(); j++) {
				Union(party[i].get(j - 1), party[i].get(j));
			}
		}
		
		
		int count =0;
		for(int i=0; i<M; i++) {
			boolean res = true;
			for(int j=0; j<party[i].size(); j++) {
				if(truePerson.length !=0 && findSet(party[i].get(j))==findSet(truePerson[0])) {
					res = false;
					break;
				}
			}
			if(res) count++;
		}

//		System.out.println(Arrays.toString(p));
		System.out.println(count);

	}

	static int findSet(int x) {
		if (p[x] != x) {
			p[x] = findSet(p[x]);
		}
		return p[x];
	}

	static void Union(int x, int y) {

		p[findSet(y)] = findSet(x);

	}

}
