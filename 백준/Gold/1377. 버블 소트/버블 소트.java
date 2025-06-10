import java.util.*;
import java.io.*;

public class Main {

	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(br.readLine());
		
		Num[] arr = new Num[n];
		for(int i=0; i<n; i++) {
			arr[i] = new Num(i, Integer.parseInt(br.readLine()));
		}

		Arrays.sort(arr, (x,y) -> x.value - y.value);
		
		int answer = 0;
		
		for(int i=0; i<n; i++) {
			int diff = arr[i].idx - i;
			answer = Math.max(diff, answer);
		}
		
		System.out.println(answer+1);
	}
	
	static class Num{
		int idx;
		int value;
		
		Num(int idx, int value){
			this.idx = idx;
			this.value = value;
		}
	}

}
