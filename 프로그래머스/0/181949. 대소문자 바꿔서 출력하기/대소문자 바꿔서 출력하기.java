import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String a = sc.next();
        
        StringBuilder sb = new StringBuilder();
        for(int i=0; i<a.length(); i++){
            char c = a.charAt(i);
            
            if(Character.isUpperCase(c)){
                sb.append(Character.toLowerCase(c));
            }else{
                sb.append(Character.toUpperCase(c));
            }
        }
        
        System.out.println(sb.toString());
    }
}