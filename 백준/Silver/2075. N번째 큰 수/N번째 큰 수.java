
import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());


        StringTokenizer st;

        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());

        for(int y=0; y<n; y++){
            st=new StringTokenizer(br.readLine());
            for(int x=0; x<n; x++){
                pq.add(Integer.parseInt(st.nextToken()));
            }
        }


        for(int i=0; i<n; i++){
            if(i==n-1) System.out.println(pq.poll());
            else pq.poll();
        }
        
    }
}
