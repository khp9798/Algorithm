import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException{
        try(BufferedReader br= new BufferedReader(new InputStreamReader(System.in))){
            int n = Integer.parseInt(br.readLine());

            int[] origin = new int[n];

            StringTokenizer st= new StringTokenizer(br.readLine()," ");
            for(int i=0; i<n; i++){
                origin[i] = Integer.parseInt(st.nextToken());
            }

            int[] sorted = origin.clone();

            Arrays.sort(sorted);

            Map<Integer, Integer> map = new HashMap<>();

            int rank = 0;

            for(int v : sorted){
                if(!map.containsKey(v)){
                    map.put(v, rank++);
                }
            }


            StringBuilder sb = new StringBuilder();
            for(int v : origin){
                sb.append(map.get(v)).append(" ");
            }
            System.out.println(sb);
        }
    }
}
