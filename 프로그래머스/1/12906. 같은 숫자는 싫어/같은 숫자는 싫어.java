import java.util.*;

public class Solution {
    public int[] solution(int []arr) {
        int[] answer = {};
        
        List<Integer> list = new ArrayList<>();
        
        list.add(arr[0]);
        
        // [실행] 버튼을 누르면 출력 값을 볼 수 있습니다.
        System.out.println("Hello Java");
        
        for(int i=1; i<arr.length; i++){
            if(arr[i-1]!=arr[i]){
                list.add(arr[i]);
            }
        }
        
        answer = new int[list.size()];
        
        for(int i=0; i<answer.length; i++){
            answer[i] = list.get(i);
        }

        return answer;
    }
}