import java.util.*;

class Solution {
    boolean solution(String s) {
        boolean answer = true;
        
        Stack<String> st = new Stack<>();

        for(int i=0; i<s.length(); i++){
            if(s.charAt(i) == ')' && st.size()>0 && st.peek().equals("(")){
                st.pop();
                answer = true;
            }
            else if(s.charAt(i) == '('){
                st.push("(");
            }
            else{
                st.push(")");
                answer=false;
            }
        
        }
        
        
        if(st.size()>0){
            System.out.println("여기 안들림?");
            answer=false;
        }

        return answer;
    }
}