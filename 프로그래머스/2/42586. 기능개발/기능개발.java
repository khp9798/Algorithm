import java.util.*;

class Solution {
    public List<Integer> solution(int[] progresses, int[] speeds) {
        List<Integer> answer = new ArrayList<>();
        
        Queue<Job> q = new LinkedList<>();
        
        for(int i=0; i<speeds.length; i++){
            Job job = new Job(i,progresses[i],speeds[i]);
            System.out.println("day : "+job.day);
            q.add(job);
        }
        
        int preDay = q.peek().day;
        int idx = 0;
        
        while(!q.isEmpty()){
            int count = 0;
            while(!q.isEmpty() && preDay>=q.peek().day){
                q.poll();
                count++;
            }
            answer.add(count);
            if(!q.isEmpty()) preDay=q.peek().day;
        }
        
        return answer;
    }
}


class Job{
    int idx;
    int day;
    
    Job(int idx, int progresses, int speeds){
        this.idx = idx;
        this.day = (int)Math.ceil((100.0 - progresses) / speeds);
    }
}