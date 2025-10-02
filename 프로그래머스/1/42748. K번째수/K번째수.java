import java.util.*;

class Solution {
    public int[] solution(int[] array, int[][] commands) {
        int[] answer = new int[commands.length];
        
        for(int r=0; r<commands.length; r++){
            int i = commands[r][0];
            int j = commands[r][1];
            int k = commands[r][2];
            
            answer[r] = cal(array,i,j,k);
        }
        
        return answer;
    }
    
    public int cal(int[] arr, int i, int j, int k){
        int[] temp = Arrays.copyOfRange(arr,i-1,j);
        
        Arrays.sort(temp);
    
        return temp[k-1];
    }
}