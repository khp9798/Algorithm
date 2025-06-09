import java.util.*;

class Solution {
    public int solution(String[][] clothes) {
        Map<String, Integer> info = new HashMap<>();
        
        for(int i=0; i<clothes.length; i++){
            String key = clothes[i][1];
            System.out.println(key);
            info.put(key, info.getOrDefault(key,0)+1);
        }
        
        int answer=1;
        for(String key : info.keySet()){
            System.out.println(info.get(key));
            answer*=info.get(key)+1;
        }
        
        return answer-1;
    }
}