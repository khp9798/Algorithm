import java.util.*;

public class Solution {
    public int[] solution(int []arr) {
        int[] answer = {};
        
        Deque<Integer> d = new LinkedList<>();
        
        for(int i=0; i<arr.length; i++){
            int num = arr[i];
            
            if(!d.isEmpty() && d.getLast() == num){
                d.removeLast();
            }
            
            d.add(num);
        }
        
        answer = new int[d.size()];
        
        for(int i=0; i<answer.length; i++){
            answer[i] = d.poll();
        }
        return answer;
    }
}