import java.util.*;
import java.io.*;

public class Main {

	static int[] count;
	static int[] current;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine());

		// DNA 문자열의 길이
		int s = Integer.parseInt(st.nextToken());

		// 비밀번호로 사용될 부분 문자열의 길이
		int p = Integer.parseInt(st.nextToken());

		// DNA 문자열
		char[] dna = br.readLine().toCharArray();

		// A,C,G,T 의 필요 최소개수
		count = new int[4];

		// 현재 문자열의 A,C,G,T 개수
		current = new int[4];

		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < 4; i++) {
			count[i] = Integer.parseInt(st.nextToken());
		}

		// 구간탐색 시작지점
		int start = 0;

		// 구간탐색 종료지점
		int end = p - 1;

		// 정답
		int answer = 0;

		for (int i = start; i <= end; i++) {
			add(dna[i]);
		}

		if (checkCount()) {
			answer++;
		}

		while (end < s - 1) {
			delete(dna[start]);
			start++;

			end++;
			add(dna[end]);

			if (checkCount()) {
				answer++;
			}
		}

		System.out.println(answer);

	}
	
	public static boolean checkCount() {
		for(int i=0; i<4; i++) {
			if(current[i]<count[i]) {
				return false;
			}
		}
		
		return true;
	}

	public static void add(char c) {
		switch (c) {
		case 'A':
			current[0]++;
			break;
		case 'C':
			current[1]++;
			break;
		case 'G':
			current[2]++;
			break;
		default:
			current[3]++;
			break;
		}
	}

	public static void delete(char c) {
		switch (c) {
		case 'A':
			current[0]--;
			break;
		case 'C':
			current[1]--;
			break;
		case 'G':
			current[2]--;
			break;
		default:
			current[3]--;
			break;
		}
	}

}
