import java.util.*;

class Solution {
    public int solution(int[][] board, int[] moves) {
        int answer = 0;
        
        Stack<Integer> bucket = new Stack<>();
        
        for(int r=0; r<board.length; r++){
            for(int c=0; c<board.length; c++){
                System.out.print(board[r][c]+" ");
            }
            System.out.println();
        }
    
        
        
        for(int i=0; i<moves.length; i++){
            int c = moves[i]-1;
            for(int r=0; r<board.length; r++){
                if(board[r][c]!=0){
                    
                    int doll = board[r][c];
                    
                    board[r][c]=0;
                    
                    System.out.println("r : "+r+", c : "+c);
                    
                    if(!bucket.isEmpty() && bucket.peek() == doll){
                        System.out.println(bucket.pop());
                        answer+=2;
                    }
                    else{
                        bucket.add(doll);
                    }
                    break;
                }
            }
            
        }
        return answer;
    }
}