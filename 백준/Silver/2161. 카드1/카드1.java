import java.io.*;
import java.util.*;

class Main {
    public static void main(String[] args) throws IOException {
        // 코드 작성
        try(BufferedReader br = new BufferedReader(new InputStreamReader(System.in))){
            int n = Integer.parseInt(br.readLine());

            Deque<Integer> deq = new ArrayDeque<>();

            for(int i=1; i<=n; i++){
                deq.addLast(i);
            }

            StringBuilder sb = new StringBuilder();

            while(deq.size()>1){
                sb.append(deq.pollFirst()+" ");

                deq.addLast(deq.pollFirst());
            }

            sb.append(deq.pollFirst());

            System.out.println(sb);
        }
    }
}