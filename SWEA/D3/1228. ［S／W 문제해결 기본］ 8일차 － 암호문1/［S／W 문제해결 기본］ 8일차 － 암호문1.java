

import java.util.LinkedList;
import java.util.Scanner;

public class Solution {

	public static void main(String[] args) {
		
		
		
		Scanner sc = new Scanner(System.in);
		

		for(int t=1; t<=10; t++) {
			//원본 암호문의 길이
			int N = sc.nextInt();
			
			
			LinkedList<Integer> list = new LinkedList<>();
			
			//원본 암호문 입력 받기
			for(int i=0; i<N; i++) {
				list.add(sc.nextInt());
			}
			

			
			//명령어의 갯수
			int commandcnt = sc.nextInt();
			
			//명령어의 갯수만큼 명령함
			for(int i=0; i<commandcnt; i++) {
				//I면 insert
				String a = sc.next();
				
				//어느 위치에 삽입할지
				int idx = sc.nextInt();
				
				//몇 개를 삽입할지
				int cnt = sc.nextInt();
				
				//삽입할 내용 입력 받아서 추가
				for(int k=0; k<cnt; k++) {
					list.add(idx+k, sc.nextInt());					
				}
				

			}
			
			
			System.out.print("#"+t);
			for(int i=0; i<10; i++) {
				System.out.print(" "+list.get(i));
			}
			System.out.println();
			
		}

	}

}
