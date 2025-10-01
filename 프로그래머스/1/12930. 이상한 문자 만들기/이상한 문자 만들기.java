class Solution {
    public String solution(String s) {
        StringBuilder sb = new StringBuilder();
        
        int num = 0;
        
        for(int i=0; i<s.length(); i++){
            
            char c = s.charAt(i);
            
            if(c==' '){
                sb.append(c);
                num = 0;
            }else{
                if(num%2 == 0){
                    sb.append(Character.toUpperCase(c));
                    num++;
                }else{
                    sb.append(Character.toLowerCase(c));
                    num++;
                }
            }
        }
        
        
        return sb.toString();
    }
}