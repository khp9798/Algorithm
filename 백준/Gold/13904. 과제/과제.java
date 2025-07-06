import java.io.*;
import java.util.*;

class Main {

    static class Task{
        int deadLine, score;

        Task(int deadLine, int score){
            this.deadLine = deadLine;
            this.score = score;
        }
    }
    public static void main(String[] args) throws IOException {
        // 코드 작성
        try(BufferedReader br = new BufferedReader(new InputStreamReader(System.in))){
            int n = Integer.parseInt(br.readLine());

            Task[] tasks = new Task[n];

            StringTokenizer st;
            for(int i=0; i<n; i++){
                st = new StringTokenizer(br.readLine());

                tasks[i] = new Task(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
            }

            Arrays.sort(tasks, (a,b) -> {
                return b.deadLine - a.deadLine;
            });

            PriorityQueue<Integer> pq = new PriorityQueue<>(Comparator.reverseOrder());

            int day = tasks[0].deadLine;
            int idx = 0;
            long total = 0;

            for(; day >=1 ; day--){

                while(idx < n && tasks[idx].deadLine >= day){
                    pq.offer(tasks[idx].score);
                    idx++;
                }

                if(!pq.isEmpty()){
                    total+=pq.poll();
                }
            }

            System.out.println(total);
        }
    }
}