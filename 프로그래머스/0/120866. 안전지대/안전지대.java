class Solution {
    public int solution(int[][] board) {
        int answer = 0;
        
        boolean[][] visited = new boolean[board.length][board.length];
        
        int[] dr = {-1,1,0,0,-1,-1,1,1};
        int[] dc = {0,0,-1,1,-1,1,-1,1};
        
        for(int r=0; r<board.length; r++){
            for(int c=0; c<board.length; c++){
                if(board[r][c]==1){
                    
                    visited[r][c] = true;
                    
                    for(int d=0; d<8; d++){
                        int nr = r+dr[d];
                        int nc = c+dc[d];
                        
                        if(nr<0 || nc<0 || nr>board.length-1 || nc>board.length-1)
                            continue;
                        
                        if(visited[nr][nc]) continue;
                        
                        visited[nr][nc] = true;
                    }
                }
            }
        }
        
        
        for(int r=0; r<visited.length; r++){
            for(int c=0; c<visited.length; c++){
                if(!visited[r][c]) answer++;
            }
        }
        return answer;
    }
}