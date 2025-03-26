import java.util.*;
import java.io.*;


public class Main {

	static int M;
	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		M = Integer.parseInt(br.readLine());
		
		Set<Integer> set = new HashSet<>();
		
		StringBuilder sb = new StringBuilder();
		
		
		for(int i=0; i<M; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			
			String command = st.nextToken();
			
			int num = 0;
			if(!(command.equals("empty") || command.equals("all")) ) {
				num = Integer.parseInt(st.nextToken());
			}
			switch(command) {
				case "add" : set.add(num);
						break;
				case "remove" : set.remove(num);
						break;
				case "check" : sb.append(set.contains(num) ? 1 : 0).append("\n");
						break;
				case "toggle" : if(set.contains(num)) {
					set.remove(num);					
				}else {
					set.add(num);
				}
					break;
				case "all" : for(int j=1; j<=20; j++) {
					set.add(j);
				}
					break;
				default : set.clear();
					break;
			}
			
			
			
			
		}
		
		System.out.println(sb.toString());
	}

}
