import java.util.*;
import java.io.*;


public class Main {

	static int n;
	static int m;
	
	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		
		m = Integer.parseInt(st.nextToken());
		
		List<String> noSee = new ArrayList<>();
		
		Set<String> noHear = new HashSet<>();
		
		StringBuilder sb = new StringBuilder();
		
		
		for(int i=0; i<n; i++) {
			noHear.add(br.readLine());
		}
		
		int result = 0;
		for(int i=0; i<m; i++) {
			String str = br.readLine();
			if(noHear.contains(str)) result++;
			noSee.add(str);
		}
		
		sb.append(result).append("\n");
		
		List<String> sortArr = new ArrayList<>();
		
		for(int i=0; i<m; i++) {
			if(noHear.contains(noSee.get(i))) {
				sortArr.add(noSee.get(i));
			}
		}
		
		Collections.sort(sortArr);
		
		for(int i=0; i<sortArr.size(); i++){
			sb.append(sortArr.get(i)).append("\n");
		}
		
		System.out.println(sb.toString());
	}

}
