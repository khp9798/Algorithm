import java.util.*;

class Solution {
    public int[] solution(int n, String[] words) {
        int[] answer = {0,0};
        
        Set<String> set = new HashSet<>();
        set.add(words[0]);
        
        int index = 0;
        
        for(int i=1; i<words.length; i++){
            if(words[i].charAt(0) != words[i-1].charAt(words[i-1].length()-1)){
                index=i;
                break;
            }
            if(set.contains(words[i])){
                index = i;
                break;
            }
            
            set.add(words[i]);
        }
        
        if(index>0){
            answer[0] = index%n+1;
            answer[1] = index/n+1;
        }
        

        // [실행] 버튼을 누르면 출력 값을 볼 수 있습니다. 
        System.out.println("Hello Java");

        return answer;
    }
}