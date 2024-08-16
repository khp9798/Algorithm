import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.PriorityQueue;
import java.util.StringTokenizer;
 
public class Solution {
     
    public static void main(String[] args) throws Exception {
         
         
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
         
         
        int T = Integer.parseInt(br.readLine());
        StringTokenizer st;
        for(int t=1; t<=T; t++) {
            //연산의 수
            int N = Integer.parseInt(br.readLine());
            PriorityQueue<Integer> pq = new PriorityQueue<>((p1,p2)->p2-p1);
            StringBuilder sb = new StringBuilder();
            for(int i=0; i<N; i++) {
                st = new StringTokenizer(br.readLine());
                //어떤 연산인지 입력
                int cal = Integer.parseInt(st.nextToken());
                //1이면 삽입 연산
                if(cal== 1) { 
                    int data = Integer.parseInt(st.nextToken());
                    pq.add(data);
                }
                //2이면 pop연산
                else {
                    if (pq.isEmpty()) {
                        sb.append(-1);
                    } else {
                        sb.append(pq.poll());
                    }
                    sb.append(" ");
                }
                 
                 
            }
             
            bw.write("#"+t+" "+sb.toString()+"\n");
             
        }
        bw.flush();
        bw.close();
    }
 
}