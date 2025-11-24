import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        int[] skill = new int[N];
        for (int i = 0; i < N; i++) {
            skill[i] = Integer.parseInt(st.nextToken());
        }
        
        Deque<Integer> dq = new ArrayDeque<>();
        
        for (int i = N - 1; i >= 0; i--) {
            int card = N - i;
            int s = skill[i];
            
            if (s == 1) {
                dq.addFirst(card);
            } else if (s == 2) {
                int first = dq.pollFirst();
                dq.addFirst(card);
                dq.addFirst(first);
            } else { // s == 3
                dq.addLast(card);
            }
        }
        
        StringBuilder sb = new StringBuilder();
        while (!dq.isEmpty()) {
            sb.append(dq.pollFirst()).append(" ");
        }
        
        System.out.println(sb);
    }
}
