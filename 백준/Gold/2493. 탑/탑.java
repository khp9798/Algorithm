import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Stack;
import java.util.StringTokenizer;

class Main{
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());

        int [] top = new int[n];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i=0; i<n; i++){
            top[i] = Integer.parseInt(st.nextToken());
        }

        int [] res = new int[n];

        Stack<Integer> stack = new Stack<>();

        for(int i=0; i<n; i++){
            
            while(!stack.isEmpty() && top[stack.peek()]<top[i]){
                stack.pop();
            }

            if(!stack.isEmpty()){
                res[i] = stack.peek()+1;
            }
            stack.push(i);
        }

        for(int i=0; i<n; i++){
            bw.write(res[i]+" ");
        }

        bw.flush();
    }
}