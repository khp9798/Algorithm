import java.util.*;

public class Solution {
    public int solution(int n) {
        int answer = 0;

        String str = n+"";
        
        System.out.println(str);
        
        for(int i=0; i<str.length(); i++){
            answer+=str.charAt(i)-'0';
        }

        return answer;
    }
}