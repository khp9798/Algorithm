import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Stack;
import java.util.StringTokenizer;

class Main{
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        int[] A = new int[n];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i=0; i<n; i++){
            A[i] = Integer.parseInt(st.nextToken());
        }

        int[] res = new int[n];

        Stack<Integer> stack = new Stack<>();

        for(int i=0; i<n; i++){

            while(!stack.isEmpty() && A[stack.peek()] < A[i]){
                res[stack.pop()] = A[i];
            }

            stack.push(i);
            
        }

        StringBuilder sb = new StringBuilder();
        for(int i=0; i<n; i++){
            sb.append(res[i]==0?-1 : res[i]).append(" ");
        }

        System.out.println(sb.toString());
    }
}