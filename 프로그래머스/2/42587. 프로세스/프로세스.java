import java.util.*;

class Solution {
    public int solution(int[] priorities, int location) {
        int answer = 0;
        
        Queue<Process> q = new LinkedList<>();
        PriorityQueue<Integer> pq = new PriorityQueue<>((p1,p2) -> {
            return p2-p1;
        });
        
        for(int i=0; i<priorities.length; i++){
            Process p = new Process(i,priorities[i]);
            q.offer(p);
            pq.offer(p.priority);
        }
        
        while(!q.isEmpty()){
            Process p = q.poll();
            System.out.println(p.priority);
            
            if(p.priority == pq.peek()){
                answer++;
                System.out.println(pq.poll());
                if(p.num == location){
                    return answer;
                }
            }else{
                q.offer(p);
            }
        }
        
        return answer;
    }
    
    class Process{
        int num;
        int priority;
        
        Process(int num, int priority){
            this.num = num;
            this.priority = priority;
        }
    }
}