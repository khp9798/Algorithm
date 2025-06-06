class Solution {
    public int[] solution(String[] wallpaper) {
        int[] answer = new int[4];
        
        answer[0] = Integer.MAX_VALUE;
        answer[1] = Integer.MAX_VALUE;
        
        answer[2] = Integer.MIN_VALUE;
        answer[3] = Integer.MIN_VALUE;
        
        for(int r=0; r<wallpaper.length; r++){
            String s = wallpaper[r];
            
            for(int i=0; i<s.length(); i++){
                if(s.charAt(i)=='#'){
                    System.out.println("("+r+", "+i+")");
                    
                    answer[0] = Math.min(answer[0],r);
                    answer[1] = Math.min(answer[1],i);
                    
                    answer[2] = Math.max(answer[2],r+1);
                    answer[3] = Math.max(answer[3],i+1);
                }
            }
        }
        return answer;
    }
}