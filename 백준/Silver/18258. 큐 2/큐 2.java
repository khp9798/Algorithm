import java.io.*;
import java.util.*;

class Main {
    public static void main(String[] args) throws IOException {
        // 코드 작성
        try(BufferedReader br = new BufferedReader(new InputStreamReader(System.in))){
            int n = Integer.parseInt(br.readLine());

            Deque<Integer> q = new ArrayDeque<>();

            StringBuilder sb = new StringBuilder();

            for(int i=0; i<n; i++){
                String[] command = br.readLine().split(" ");

                switch(command[0]){
                    case "push":
                        q.offerLast(Integer.parseInt(command[1]));
                        break;
                    case "pop":
                        sb.append(q.isEmpty()? -1 : q.pollFirst()).append("\n");
                        break;
                    case "size":
                        sb.append(q.size()).append("\n");
                        break;
                    case "empty":
                        sb.append(q.isEmpty() ? 1 : 0).append("\n");
                        break;
                    case "front":
                        sb.append(q.isEmpty() ? -1 : q.peekFirst()).append("\n");
                        break;
                    default:
                        sb.append(q.isEmpty()? -1 : q.peekLast()).append("\n");
                        break;
                }
            }

            

            System.out.println(sb);
        }
    }
}