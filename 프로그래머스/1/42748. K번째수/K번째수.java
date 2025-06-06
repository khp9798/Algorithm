import java.util.*;

class Solution {
    public int[] solution(int[] array, int[][] commands) {
        int[] answer = new int[commands.length];
        
        for(int r=0; r<commands.length; r++){
            
            int[] subarr = Arrays.copyOfRange(array,commands[r][0]-1,commands[r][1]);
            
            Arrays.sort(subarr);
            answer[r] = subarr[commands[r][2]-1];
            
            for(int i=0; i<subarr.length; i++){
                System.out.print(subarr[i]+" ");
            }
            
            System.out.println();
        }
        return answer;
    }
}