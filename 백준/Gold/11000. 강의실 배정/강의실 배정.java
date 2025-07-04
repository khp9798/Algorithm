import java.io.*;
import java.util.*;

class Main {

    static class Study implements Comparable<Study>{
        int s, t;

        Study(int s, int t){
            this.s = s;
            this.t =t;
        }

        @Override
        public int compareTo(Study s){
            if(this.s != s.s)
                return this.s - s.s;
            return this.s - s.s;
        }
    }

    public static void main(String[] args) throws IOException {
        // 코드 작성
        try(BufferedReader br = new BufferedReader(new InputStreamReader(System.in))){
            int n = Integer.parseInt(br.readLine());

            Study[] studies = new Study[n];

            for(int i=0; i<n; i++){
                String[] str = br.readLine().split(" ");

                int a = Integer.parseInt(str[0]);
                int b = Integer.parseInt(str[1]);

                studies[i] = new Study(a,b);
            }


            Arrays.sort(studies);

            PriorityQueue<Integer> pq = new PriorityQueue<>();

            for(Study study : studies){
                if(!pq.isEmpty() && pq.peek() <= study.s){
                    pq.poll();
                }
                pq.offer(study.t);
            }

            System.out.println(pq.size());
        }
    }
}