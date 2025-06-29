import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException{
        try(BufferedReader br = new BufferedReader(new InputStreamReader(System.in))){
            int n = Integer.parseInt(br.readLine());


            PriorityQueue<Integer> left = new PriorityQueue<>(Comparator.reverseOrder());
            PriorityQueue<Integer> right = new PriorityQueue<>();

            StringBuilder sb = new StringBuilder();

            for(int i=0; i<n; i++){
                left.offer(Integer.parseInt(br.readLine()));

                right.offer(left.poll());

                if(left.size()<right.size()){
                    left.offer(right.poll());
                }

                sb.append(left.peek()).append("\n");
            }

            System.out.println(sb);
        }

    }
}
