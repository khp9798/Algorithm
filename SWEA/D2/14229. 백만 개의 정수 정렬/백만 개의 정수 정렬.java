


import java.util.Scanner;

public class Solution {
	static int [] arr = new int[1000000];
	static int N = arr.length; // 배열의 길이
	static int[] tmp = new int[N];
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		for(int i=0; i<N; i++) {
			arr[i] = sc.nextInt();
		}
		mergeSort(0,N-1);
		System.out.println(arr[500000]);
	}
	
	
	//left : 구간의 시작 위치 / right : 구간의 끝
	static void mergeSort(int left, int right) {
		

		if(left<right) {
			int mid = (left+right)/2;
			mergeSort(left,mid);
			mergeSort(mid+1,right);
			merge(left,mid,right);
		}
		
		
	}


	//left는 시작구간, right는 끝구간, mid는 왼쪽 구간의 끝 , mid+1은 오른쪽 구간의 시작
	private static void merge(int left, int mid, int right) {
		//left와 mid+1을 비교해서 정렬

		int L = left ; //왼쪽 구간의 시작 포인트 
		int R = mid+1; //오른쪽 구간의 시작 포인트
		
		int idx = left; //tmp 배열의 인덱스
		
		while(L <= mid && R <=right) {
			if(arr[L] <= arr[R]) {
				tmp[idx] = arr[L];
				idx++;
				L++;
			}else {
				tmp[idx] = arr[R];
				idx++;
				R++;
			}
			
			
		}
		
		
		//왼쪽 구간에 값이 남았어
		if(L<=mid) {
			for(int i=L; i<=mid; i++) {
				tmp[idx++] = arr[i];
			}
		}
		//오른쪽 구간의 값이 남았어
		else {
			for(int i=R; i<=right; i++) {
				tmp[idx++] = arr[i];
			}
		}
		
		
		
		//원본배열에 반영하자
		for(int i=left; i<=right; i++) {
			arr[i] = tmp[i];
		}
	}

}
