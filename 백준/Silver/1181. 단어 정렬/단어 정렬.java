import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

class Main {
	static class Word implements Comparable<Word>{
		String data;
		
		

		public Word(String data) {
			super();
			this.data = data;
		}



		public int compareTo(Word o) {
			if(this.data.length()!=o.data.length()) {
				return this.data.length()-o.data.length();
			}
			return this.data.compareTo(o.data);
		}

		
	}
	
	
	static Word[] arr;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(br.readLine());

		
		arr = new Word[N];
		
		
		for(int i=0; i<N; i++) {
			arr[i] = new Word(br.readLine());
		}

		
		Arrays.sort(arr);
		
		System.out.println(arr[0].data);
		for(int i=1; i<arr.length; i++) {
			if(!arr[i].data.equals(arr[i-1].data)) {
				System.out.println(arr[i].data);
			}
		}
	}
}